package thread;


public class SynObject {

    public synchronized void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend了！");
            Thread.currentThread().suspend();
            try {
                Thread.sleep(5000);
                Thread.currentThread().resume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }

}

class Run {
    public static void main(String[] args) {
        try {
            final SynObject synObject = new SynObject();
            Thread thread1 = new Thread(() -> {
                synObject.printString();
            });
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);

            Thread thread2 = new Thread(() -> {
                System.out.println("t2启动了，但是进入不了printString方法！只打印一个begin");
                System.out.println("因为printString方法被a线程锁定并且永远suspend了");
                synObject.printString();
                System.out.println("Thread 2 complete");
            });
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
