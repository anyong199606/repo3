package channel;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class DBOperate implements Closeable{
    @Override
    public void close() throws IOException {
        System.out.println("连接已关闭");
    }

    public static void main(String[] args) {
        try (DBOperate dbOperate = new DBOperate();){
            System.out.println("使用db："+dbOperate+"连接数据库");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
