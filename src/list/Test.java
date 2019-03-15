package list;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Test {
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(1);
//        arrayList.add(1);
//        arrayList.add(1);
////        arrayList.add(1);
////        arrayList.add(1);
//
//        System.out.println(10<<3);

        byte[] bytes = {1, 2, 3};
        System.out.println(bytes.length+""+bytes);
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        System.out.println(wrap);
    }
}
