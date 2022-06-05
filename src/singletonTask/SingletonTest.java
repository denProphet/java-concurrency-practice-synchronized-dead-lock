package singletonTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {
    public static void main(String[] args) {

        final int taskAmount = 2000;

        CountDownLatch startFlag = new CountDownLatch(1);
        CountDownLatch finishFlag = new CountDownLatch(taskAmount);

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < taskAmount; i++) {
            executor.submit(new SingletonRunnableTask(startFlag, finishFlag));
        }

        startFlag.countDown();
        try {
            finishFlag.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println(SingletonInstance.getInstanceCount());
    }
}
