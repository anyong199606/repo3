package syn;


public class Test2 {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            //主线程睡眠
            Thread.sleep(5000);
            //先暂停mythread线程，阻塞一会
            thread.suspend();
            //打印当前的count值
            System.out.println("当前时间:"+System.currentTimeMillis()+"   count:"+thread.getCount());
            //主线程睡眠
            Thread.sleep(5000);
            //打印当前的count值
            System.out.println("当前时间:"+System.currentTimeMillis()+"   count:"+thread.getCount());

            //恢复线程
            thread.resume();
            //主线程睡眠
            Thread.sleep(5000);
            //先暂停mythread线程，阻塞一会
            thread.suspend();
            //打印当前的count值
            System.out.println("当前时间:"+System.currentTimeMillis()+"   count:"+thread.getCount());
            //主线程睡眠
            Thread.sleep(5000);
            //打印当前的count值
            System.out.println("当前时间:"+System.currentTimeMillis()+"   count:"+thread.getCount());
            return;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true){
            count++;
        }
    }
}
