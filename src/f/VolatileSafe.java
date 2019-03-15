package f;


public class VolatileSafe {

    boolean close;

    public void close(){
        close=true;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork(){
        while (!close){
            System.out.println("safe....");
        }
    }

    public static void main(String[] args) {
        //如果t1先执行一直输出safe...
        //如果t2先执行，那么什么都不输出
        VolatileSafe volatileSafe = new VolatileSafe();
        Thread t1 = new Thread(() -> {
            volatileSafe.close();
        });
        Thread t2 = new Thread(() -> {
            volatileSafe.doWork();
        });
        t1.start();
        t2.start();
    }
}