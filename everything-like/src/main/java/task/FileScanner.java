package task;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanner {
    //1.核心线程数：始终运行的线程数量  --=--正式工
    //2.最大的线程数：有新任务之后并且当前运行的线程数小于最大线程数的时候 创建新的线程来处理新的任务----正式工+临时工会解雇掉
    //3.-4. 数量 时间单位  不需要等待  ：超过3这个数量的 4这个时间单位 2-1（最大线程数-核心线程数）
    //这些线程就会关闭
    //5.工作的阻塞队列
    //6.如果超出工作队列的长度 我们任务要处理的方式；（4种策略）
    //AbortPolicy   退出什么都不做
    //CallerRunsPolicy
    //DiscardOldestPolicy丢弃老的线程
    //DiscardPolicy丢弃新的
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(
            3, 3, 0, TimeUnit.MICROSECONDS,
            new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy()
    );

    // private ExecutorService exe = Executor.newFixedThreadPooL(4);
    private volatile AtomicInteger count = new AtomicInteger();
    private Object lock = new Object();//第一种：synchronized(lock)进行wait等待

    private CountDownLatch latch = new CountDownLatch(1);
    //使用await 进行等待 知道lartch = 0;
    private Semaphore semaphore = new Semaphore(0);
    private ScanCallback callback;
    public FileScanner(ScanCallback callback) {
        this.callback = callback;
    }

    //acquire阻塞等待一定数量的许可;
    //计数器 不传入数值 表述初始化值为0
    //锁对象 线程等待
    /*
     * 扫描文件的方法
     *
     * 最开始不知道有多少子文件夹，不知道应该启动多少线程
     *
     *
     *
     * */
    public void scan(String path) {
        count.incrementAndGet();//启动更目录扫描任务++i  计数器
        doScan(new File(path));//更目录当做未处理的文件夹
    }

    /*
     *
     * dir待处理的文件夹
     *
     * */
    private void doScan(File dir) {
        callback.callback(dir);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    File[] children = dir.listFiles();//下一级子目录
                    if (children != null) {
                        for (File child : children) {
                            if (child.isDirectory()) {//如果是文件夹递归处理
                               // System.out.println("文件夹" + child.getParent());


                                count.incrementAndGet();//启动子目录扫描任务++i  计数器
                                doScan(child);
                            } //else {//如果是文件没有下一个文件夹
                               // System.out.println("文件" + child.getPath());
                           // }
                        }
                    }
                }finally {//保证线程的计数不管是否出现异常 都可以执行--操作
                    int r = count.decrementAndGet();
                    if (r == 0) {
                        //第一种
                        /*synchronized (lock) {
                            lock.notify();*/
                            //可能会出现问题 会造成什么结果  之前的代码出现异常 之后的代码一直阻塞线程
                      //  }
                        //第二种
                       // latch.countDown();
                        //第三种实现方式
                        semaphore.release();

                    }
                }

            }
        });
    }

    /*
     * 等待扫描任务结束（scan方法）
     *多线程的任务等待thread.start
     * 1.join方法  需要使用线程Thread类的引用对象
     * 2.wait方法  线程间的等待
     *
     * */
    public void waitFinish() throws InterruptedException {
        //第一种实现
     //   synchronized (lock) {
       //     lock.wait();
//        }.
        //第二种实现
      //  latch.await();
        semaphore.acquire();

        }


       /* public static void main (String[]args){
       /* Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());//后执行
            }
        });
        t.start();
        System.out.println(Thread.currentThread().getName());//先执行
            //需要让T2执行完毕 在执行一段代码
            Object obj = new Object();
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            t2.start();
            synchronized (obj) {
                obj.wait();
            }
            // t2.join();
            System.out.println(Thread.currentThread().getName());
        }*/
    }

