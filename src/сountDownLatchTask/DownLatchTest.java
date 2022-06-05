package сountDownLatchTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DownLatchTest {
    public static void main(String[] args) {

        CountDownLatch flag = new CountDownLatch(2000);

        Executor executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 2000; i++) {
            executor.execute(new CountDownLatchWorkerRunnableTask(flag));
            //System.out.println(flag.getCount());
        }

        try {
            flag.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
