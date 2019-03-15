/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class CountOperate extends Thread {

    public CountOperate(){
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName():"+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive():"+Thread.currentThread().isAlive());//main线程
        System.out.println("this.getName():"+this.getName());
        System.out.println("this.isAlive():"+this.isAlive());//CountOperate对象
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName():"+Thread.currentThread().getName());//A
        System.out.println("Thread.currentThread().isAlive():"+Thread.currentThread().isAlive());//CountOperate线程 true
        System.out.println("this.getName():"+this.getName());//thread - 0
        System.out.println("this.isAlive():"+this.isAlive());//CountOperate对象 false
        System.out.println("run---end");
    }

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive="+t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main begin t1 isAlive="+t1.isAlive());
    }
}
