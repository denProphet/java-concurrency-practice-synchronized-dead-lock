package deadLockTest;

public class DeadLockTest {

    public static void main(String[] args) {

        DeadLockGenerator deadLock = new DeadLockGenerator();
        Thread t1 = new Thread(deadLock, "thread 1");
        Thread t2 = new Thread(deadLock, "thread 2");

        t1.start();
        t2.start();

    }
}
