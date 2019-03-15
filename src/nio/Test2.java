package nio;

import java.nio.ByteBuffer;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Test2 {
    static int MAX_VALUE = 1900000000;
    public static void main(String[] args) {
        t2();
        try {
            System.out.println("------");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1();
    }
    public static void t1(){
        long start = System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(MAX_VALUE);
        for (int i=0;i<MAX_VALUE;i++){
            byteBuffer.put((byte)123);
        }
        System.out.println((System.currentTimeMillis() - start));
    }

    public static void t2(){
        long start = System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(MAX_VALUE);
        for (int i=0;i<MAX_VALUE;i++){
            byteBuffer.put((byte)123);
        }
        System.out.println((System.currentTimeMillis() - start));
    }

}
