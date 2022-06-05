package singletonTask;

import java.util.concurrent.CountDownLatch;

public class SingletonRunnableTask implements Runnable {

    private final CountDownLatch startFlag;
    private final CountDownLatch finishFlag;

    public SingletonRunnableTask(CountDownLatch startFlag, CountDownLatch finishFlag) {
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
    }


    @Override
    public void run() {
        try {
            startFlag.await();
            SingletonInstance.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finishFlag.countDown();
    }

}
