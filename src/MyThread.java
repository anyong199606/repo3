
public class MyThread extends Thread {


    @Override
    public void run() {
      long start = System.currentTimeMillis();
      int count = 0;
      for (int i=0;i<50000000;i++){
          Thread.yield();
          count = count+(i+1);

      }
        System.out.println("用时:"+(System.currentTimeMillis() - start));
    }
}

class RR{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

}
