import java.io.*;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class AAA {
    private  static final Integer num1= 33;
    private   int num2 = 33;

    public static void main(String[] args) {
        //先从redis中读取，如果没有的话，那么就从磁盘中读取，读取后放入redis中
        byte[] bytes = download();
        System.out.println(bytes.length);
    }
    public static byte[] download(){
        File file = new File("D:\\instructions.pdf");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] bytes = new byte[(int)file.length()];
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream("D:\\download.pdf");
            int len;
            while ((len = fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }
}
