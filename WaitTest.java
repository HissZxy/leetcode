import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class WaitTest {
    /*
     * 等待所有线程执行完毕
     * 1.CountDownlatch  初始化一个数值 可以countdown()i--操作也可以await等待这时候会阻塞并到i=0
     * 2.semaphone  relase()方法进行一定数量许可的颁发 acquire()方法 阻塞并等待一定数量的许可
     * 相对来说 semphore功能更强更灵活
     *
     * */
    private static int COUNT = 5;
    private static CountDownLatch LATCH = new CountDownLatch(5);
    private static Semaphore SEMAPHORE = new Semaphore(0);

    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    //   LATCH.countDown();//i--
                    SEMAPHORE.release();//颁发一定数量的许可证,无参数就是1个
                }
            }).start();

        }
    }
                //SEMAPHORE.acquire(5);

  //  System.out.println(Thread.currentThread().getName());
}

