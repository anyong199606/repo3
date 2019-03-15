/**
 * 注意到后面这句“当抛出这个异常的时候，中断状态已被清除”。所以isInterrupted()方法应该返回false。
 * 可是有的时候，我们需要isInterrupted这个方法返回true，怎么办呢？这里就要先说说interrupt, interrupted和isInterrupted的区别了：
 */
//public class Interrupt {
//    public static void main(String[] args) throws Exception {
//        Thread t = new Thread(new Worker());
//        t.start();
//        Thread.sleep(200);//主线程
//        t.interrupt();//t就是worker
//        System.out.println("Main thread stopped.");
//    }
//
//    public static class Worker implements Runnable {
//        public void run() {
//            System.out.println("Worker started.");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
////                e.printStackTrace();
//                System.out.println("Worker IsInterrupted: " +
//                        Thread.interrupted());
//            }
//            System.out.println("Worker stopped.");
//        }
//    }
//}

public class Interrupt  {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Worker());
        t.start();

        Thread.sleep(200);
        t.interrupt();//中断的sleep方法，虽然中断的状态设置为true了，但是会被JVM回收

        System.out.println("Main thread stopped.");
    }

    public static class Worker implements Runnable {
        public void run() {
            System.out.println("Worker started.");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread curr = Thread.currentThread();
                //再次调用interrupt方法中断自己，将中断状态设置为“中断”
                curr.interrupt();
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Static Call: " + Thread.interrupted());//clear status
                System.out.println("---------After Interrupt Status Cleared----------");
                System.out.println("Static Call: " + Thread.interrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
            }

            System.out.println("Worker stopped.");
        }
    }
}