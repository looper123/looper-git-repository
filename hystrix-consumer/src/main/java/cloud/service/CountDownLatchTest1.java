package cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ZhenpengLu on 2017/9/28.
 */
@Service
public class CountDownLatchTest1 implements  Runnable{



    final AtomicInteger number = new AtomicInteger();
    volatile boolean bol = false;

    @Override
    public void run() {
        System.out.println(number.getAndIncrement());
        synchronized (this) {
            try {
                if (!bol) {
                    HelloService helloService = new HelloService();
                    helloService.helloConsumer();
                    bol = true;
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("并发数量为" + number.intValue());
        }

    }

    public static void main(String[] args) {
        ExecutorService pool = Executors. newCachedThreadPool();
        CountDownLatchTest1 test = new CountDownLatchTest1();
        for (int i=0;i<10;i++) {
            pool.execute(test);
        }
    }
}
