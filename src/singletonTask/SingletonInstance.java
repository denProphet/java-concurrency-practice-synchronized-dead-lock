package singletonTask;

import java.util.concurrent.atomic.AtomicInteger;

public class SingletonInstance {

    private static SingletonInstance instance;
    private static final AtomicInteger instanceCount = new AtomicInteger();

    private SingletonInstance() {
    instanceCount.incrementAndGet();
    }

    public static  synchronized SingletonInstance getInstance() {
        if (instance == null) {
            instance = new SingletonInstance();
        }
        return instance;
    }

    public static AtomicInteger getInstanceCount() {
        return instanceCount;
    }
}
