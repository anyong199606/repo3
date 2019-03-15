package nio;


import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class Test8 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{1, 2, 3,4,5,6});
//        byteBuffer.position(2);
//        byteBuffer.limit(3);
//        byteBuffer.mark();
//        byteBuffer.clear(); //mark -1 position 0 limit 3  clear不是真正的删除，byte数组中的数据都在
        System.out.println("byteBuffer.capacity():" + byteBuffer.capacity() + " byteBuffer.limit():" + byteBuffer.limit() + "    byteBuffer.position():" +
                byteBuffer.position());//0

        byteBuffer.position(1);
        byteBuffer.limit(4);
        byteBuffer.mark();
        System.out.println("byteBuffer.capacity():" + byteBuffer.capacity() + " byteBuffer.limit():" + byteBuffer.limit() + "    byteBuffer.position():" +
                byteBuffer.position());//0
        byteBuffer.rewind();//limit不改变
        System.out.println("byteBuffer.capacity():" + byteBuffer.capacity() + " byteBuffer.limit():" + byteBuffer.limit() + "    byteBuffer.position():" +
                byteBuffer.position());//0
//        byteBuffer.reset();
//        System.out.println();
//        System.out.println("byteBuffer.limit():" + byteBuffer.limit());//3
//        System.out.println();
//
//        for (int i = 0; i < byteBuffer.limit(); i++) {
//            System.out.println(byteBuffer.get(i));
//        }
//        System.out.println("byteBuffer.position():" + byteBuffer.position());//3

//        try {
//
//            byteBuffer.reset();
//        }catch (InvalidMarkException e){
//            System.out.println("mark丢失");
//        }
    }

}
