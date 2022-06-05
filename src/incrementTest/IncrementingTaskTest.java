package incrementTest;

import handlers.ExecutorPoolHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementingTaskTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        final AtomicInteger container = new AtomicInteger();
        for (int i = 0; i < 2000; i++) {
            executor.execute(new IntegerIncrementingRunnableTask(container));
        }
        executor.shutdown();
        ExecutorPoolHandler.shutdownAndAwaitTermination(executor);

        System.out.println("Current value is " + container.get());
    }

}
