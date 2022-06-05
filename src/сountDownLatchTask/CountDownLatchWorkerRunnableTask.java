package сountDownLatchTask;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchWorkerRunnableTask implements Runnable{
    private final CountDownLatch flag;

    public CountDownLatchWorkerRunnableTask(CountDownLatch flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag.countDown();
    }
}
