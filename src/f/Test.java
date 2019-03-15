package f;


import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
  volatile   boolean flag = false;
    public void sleep() {
        System.out.println("sleep进入");
        while (!flag) {
        }
        System.out.println("sleep退出");
    }

    public void setFlag() {
        flag = true;
    }

    public static void main(String[] args) throws InterruptedException {
        long strat = System.currentTimeMillis();
        Test test = new Test();
        Thread t1 = new Thread(() -> {
            test.setFlag();
        });
        Thread t2 = new Thread(() -> {
            test.sleep();
        });
        t2.start();
        Thread.sleep(1000);
        t1.start();
        System.out.println((System.currentTimeMillis() - strat));
        Thread.sleep(1000);
        System.out.println(test.flag);
    }
}
