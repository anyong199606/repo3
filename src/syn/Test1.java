package syn;


public class Test1 {
    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        thread10.setDaemon(true);
        new Thread(thread10).start();

        new Thread(new Thread10()).start();
        for (int i=0;i<10;i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
        }
        System.out.println("主线程执行完毕!!!!");
    }
}
class Thread11 extends Thread{

    @Override
    public void run() {
        t();
    }
    private void t(){
        for (int i=0;i<300;i++){
            System.out.println(Thread.currentThread().getName()+"   "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread10 extends Thread{

    @Override
    public void run() {
        t();
    }
    private void t(){
        for (int i=0;i<30;i++){
            System.out.println(Thread.currentThread().getName()+"   "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
