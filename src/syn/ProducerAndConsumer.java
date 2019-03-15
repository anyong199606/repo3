package syn;

import java.util.LinkedList;
import java.util.Queue;


public class ProducerAndConsumer {

    private final static int MAX_SIZE = 10;

    private static Queue<Integer> queue = new LinkedList<Integer>();

    static class Producer extends Thread{
        @Override
        public void run() {
            //进行生产
            product();
        }

        private void product() {
                synchronized (queue){
                    //判断条件
                    while (queue.size() == MAX_SIZE){
                        System.out.println("当前队列已满,请消费");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //进行添加
                    queue.add(1);
                    queue.notify();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                }

        }
    }
    static class Consumer  extends Thread{
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            synchronized (queue){
                while (0 == queue.size()){
                    System.out.println("当前队列已空,请生产");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //开始消费
                queue.poll();
                queue.notify();
                System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
            }

        }
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        producer.start();
        consumer.start();
    }
}
