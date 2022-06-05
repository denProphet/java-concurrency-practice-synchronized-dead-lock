package incrementTest;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerIncrementingRunnableTask implements Runnable{

    private final AtomicInteger counter;

   public IntegerIncrementingRunnableTask(AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.incrementAndGet();
    }
}
