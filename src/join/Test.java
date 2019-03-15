package join;


import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {

//        Executors
        ExecutorService executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10));

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 i:" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    t1.join();//t2等待t1先执行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 i:" + i);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //首先t3获取到t2的syn锁，然后在调用join方法的waite方法释放锁，然后t2开始执行，执行完了就该t3执行
                    t2.join();//t3等待t2先执行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 i:" + i);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
