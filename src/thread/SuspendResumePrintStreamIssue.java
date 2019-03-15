package thread;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class SuspendResumePrintStreamIssue extends Thread{
    private long i = 0;
    @Override
    public void run() {
        while (true){
//            try {
            i++;
//                Thread.sleep(1);
            System.out.println(i);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
 class ThreadRunMain {
    public static void main(String[] args) {
        testSuspendResumePrintStreamIssue();
    }
    public static void testSuspendResumePrintStreamIssue(){
        try {
            SuspendResumePrintStreamIssue srpsi = new SuspendResumePrintStreamIssue();
            srpsi.start();
            Thread.sleep(1000);
            srpsi.suspend();
            System.out.println("Main end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}