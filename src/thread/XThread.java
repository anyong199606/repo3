package thread;


public class XThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i=0;i<10000;i++){
                this.join();
                System.out.println("i:"+(i+1));
            }
            System.out.println("begin");
            Thread.sleep(5000);
            System.out.println("end");
        }catch (InterruptedException e){
            System.out.println("先停止，再遇到sleep！进入catch！");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XThread xThread = new XThread();
        xThread.start();
        xThread.interrupt();
        System.out.println("end!");
    }
}
