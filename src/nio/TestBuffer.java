package nio;


import java.nio.Buffer;
import java.nio.ByteBuffer;

public class TestBuffer {
    public static void main(String[] args) {
        byte[] bytes = {1, 2, 3, 4};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.limit(2);
        System.out.println("byteBuffer.capacity():"+byteBuffer.capacity()+" byteBuffer.limit():"+byteBuffer.limit());
        byteBuffer.position(1);
        byteBuffer.put((byte) 7);
//        byteBuffer.put((byte) 8);
        System.out.println("byteBuffer.position():"+byteBuffer.position());
        byteBuffer.mark();
        byteBuffer.limit(1);//设置了limit的大小比position小的时候，那么position的值就只有变成limit的值了
        System.out.println("byteBuffer.position():"+byteBuffer.position());
        System.out.println("byteBuffer.limit():"+byteBuffer.limit());
        byteBuffer.mark();
        byteBuffer.reset();//让position回到mark的地方,如果没有设置mark()方法就会报错InvalidMarkException，
        // 或者position,limit在mark（）方法后设置的值比mark小，也会报错InvalidMarkException
        System.out.println();
        System.out.println("byteBuffer.position():"+byteBuffer.position());

        System.out.println("byteBuffer.isReadOnly():"+byteBuffer.isReadOnly());

        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        buffer.clear();
        System.out.println("buffer.isDirect():"+buffer.isDirect());
    }
}
