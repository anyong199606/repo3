package thread;

public class YieldExcemple {

    public static void main(String[] args) {
        Thread threada = new ThreadA();
        Thread threadb = new ThreadB();
        // 设置优先级:MIN_PRIORITY最低优先级1;NORM_PRIORITY普通优先级5;MAX_PRIORITY最高优先级10
        threada.setPriority(Thread.MIN_PRIORITY);
        threadb.setPriority(Thread.MAX_PRIORITY);

        threada.start();
        threadb.start();
    }
}

class ThreadA extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("low--" + i);
            Thread.yield();
        }
    }
}

class ThreadB extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hight--" + i);
            Thread.yield();
        }
    }
}
