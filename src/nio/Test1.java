package nio;

import java.util.*;
import java.nio.ByteBuffer;

public class Test1 {
    static ByteBuffer byteBuffer1;
    static ByteBuffer byteBuffer2;
    static ByteBuffer byteBuffer3;
    static List<ByteBuffer> list;
    static {
        byteBuffer1 = ByteBuffer.wrap(new byte[]{'a', 'b', 'c'});
        byteBuffer2 = ByteBuffer.wrap(new byte[]{'x', 'y', 'z'});
        byteBuffer3 = ByteBuffer.wrap(new byte[]{'1', '2', '3'});
        list = new ArrayList<>();
        list.add(byteBuffer1);
        list.add(byteBuffer2);
        list.add(byteBuffer3);
    }

    public static void main(String[] args) {
        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        list.toArray(byteBuffers);
        for (ByteBuffer b : byteBuffers){
            while (b.hasRemaining()){
                System.out.print((char) b.get());
            }
            System.out.println();
        }
    }
}
