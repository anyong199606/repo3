package syn;


import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

    private LinkedList list = new LinkedList();

    private AtomicInteger count = new AtomicInteger();

    private final int minSize = 0;

    private final int maxSize;

    public MyQueue(int maxSize){
        this.maxSize = maxSize;
    }
    private final Object lock = new Object();

    public Object take(){
        synchronized (lock) {
            while (this.minSize == count.get()) {
                try {
                    System.out.println("当前已空，请添加");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("被打断");
                }
            }

            Object o = list.removeFirst();
            //count减小
            count.decrementAndGet();
            lock.notifyAll();
            System.out.println("消费："+o);
            return o;
        }
    }

    public void put(Object o){
        //todo 为什么这里要用 while 不用 if
        synchronized (lock) {
            while (this.maxSize == count.get()) {
                try {
                    System.out.println("当前已满，请消费");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("被打断");
                }
            }
            //添加元素
            list.add(o);
            try {
                //模仿生成所消耗的时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //count增加值
            count.incrementAndGet();
            //通知消费者
            lock.notifyAll();
            System.out.println("生产:"+o);
        }
    }

    public static void main(String[] args) {
        final MyQueue myQueue = new MyQueue(5);
        myQueue.put(1);
        myQueue.put(2);
        myQueue.put(3);
        myQueue.put(4);
        myQueue.put(5);
        Thread thread1 = new Thread(() -> {
            myQueue.put(6);
            myQueue.put(7);
        });

        Thread thread2 = new Thread(() -> {
            myQueue.take();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myQueue.take();
        });
        thread1.start();
        thread2.start();
    }

}
