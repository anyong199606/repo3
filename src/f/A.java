package f;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class A {

    public static synchronized void a(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("asad");
    }

    public static void main(String[] args) throws InterruptedException {
//        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            a();
//            try {
////                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            a();
        }, "t1");

        Thread thread2 = new Thread(() -> {
            a();
        });
        t1.start();
        thread2.start();
    }
}
