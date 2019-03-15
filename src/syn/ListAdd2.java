package syn;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class ListAdd2 {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("bjsxt");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ListAdd2 list2 = new ListAdd2();

        final Object lock = new Object();

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            try {
//                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        list2.add();
                        System.out.println("当前线程:" + Thread.currentThread().getName() + "添加了一个元素");
                        Thread.sleep(500);
                        if (list2.size() == 5) {
                            //唤醒
                            System.out.println("已经发出通知!");
                            countDownLatch.countDown();
//                            lock.notify();
                        }
                    }
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
//            synchronized (lock) {
//                System.out.println(Thread.currentThread().getName());
                if (5 != list2.size()) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    try {
////                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
//            }
            System.out.println("当前线程收到通知:" + Thread.currentThread().getName());
            throw new RuntimeException();

        }, "t2");

        t1.start();
        t2.start();

    }
}
