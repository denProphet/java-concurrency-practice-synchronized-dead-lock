package deadLockTest;

public class DeadLockGenerator implements Runnable {
    private static class CommonResource { //lock
        //smth
    }

    private final CommonResource resource1 = new CommonResource();
    private final CommonResource resource2 = new CommonResource();

    public void work1() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName()
                    + " Использование 1 ресурса");
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName()
                        + " Использование 2 ресурса");
                System.out.println(Thread.currentThread().getName()
                        + " Идет процесс выполнения работы 1");
            }
        }
    }

    public void work2() {
        synchronized (resource2) {
            System.out.println(Thread.currentThread().getName()
                    + " Использование 2 ресурса");

            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName()
                        + " Использование 1 ресурса");
                System.out.println(Thread.currentThread().getName()
                        + " Идет процесс выполнения работы 2");
            }
        }
    }

    @Override
    public void run() {
        work1();
        work2();
    }
}
