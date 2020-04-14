import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
    //多线程下 线程安全的计数器
    private static volatile AtomicInteger COUNT = new AtomicInteger(0);
    public static void main(String[] args) {
        for(int i = 0;i <20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 1;j< 10000; j++){
                        COUNT.incrementAndGet();//++i
                      //  COUNT.getAndIncrement();//先获取再自增
                    }
                }
            }).start();
        }
    while (Thread.activeCount()>1)
        Thread.yield();
        System.out.println(COUNT.get());
    }

}
