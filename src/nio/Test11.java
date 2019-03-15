package nio;


import java.nio.CharBuffer;

public class Test11 {

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(20);
        System.out.println("charBuffer.position():"+charBuffer.position()+" charBuffer.limit():"+charBuffer.limit());
        charBuffer.put("我是中国人我在中华人民共和国");
        System.out.println("charBuffer.position():"+charBuffer.position()+" charBuffer.limit():"+charBuffer.limit());
        charBuffer.position(0);
        System.out.println("charBuffer.position():"+charBuffer.position()+" charBuffer.limit():"+charBuffer.limit());
        for (int i=0;i<charBuffer.limit();i++){
            System.out.println(charBuffer.get());
        }
        System.out.println("charBuffer.position():"+charBuffer.position()+" charBuffer.limit():"+charBuffer.limit());
        charBuffer.clear();
        System.out.println("charBuffer.position():"+charBuffer.position()+" charBuffer.limit():"+charBuffer.limit());

        charBuffer.put("我是美国人");
        System.out.println("charBuffer.position():"+charBuffer.position()+" charBuffer.limit():"+charBuffer.limit());
        charBuffer.flip();
        System.out.println("charBuffer.position():"+charBuffer.position()+" charBuffer.limit():"+charBuffer.limit());
        for (int i=0;i<charBuffer.limit();i++){
            System.out.println(charBuffer.get());
        }
    }

}
