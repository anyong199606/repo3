package thread;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Daemon {
}
class AThread extends Thread{
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i="+(i));
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        AThread aThread = new AThread();
        aThread.setDaemon(true);
        aThread.start();
        Thread.sleep(5000);
        System.out.println("我离开了 aThread线程也不能打印了 ");
    }
}