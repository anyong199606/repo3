/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
import java.lang.reflect.Field;

import org.junit.Test;

//反射字段(属性)：作用：封装数据，所以目的就是往里面添加数据
public class Demo04 {
    private Demo04 demo;
    public static void main(String[] args) {
        Demo04 demo1 = new Demo04();
        Demo04 demo2 = new Demo04();
        demo1.demo = demo2;
        demo2.demo = demo1;
//        demo04 = null;
        demo1 = null;
        demo2 = null;
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("该对象被回收了");

    }
}
