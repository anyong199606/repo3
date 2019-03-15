/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
import java.io.InputStream;
import java.util.List;

public class Person {

    public String name = "aaaaa";
    private int password = 555;
    private static int age = 23;

    static {
        System.out.println("Person类初始化了");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader1 loader1 = new ClassLoader1();
        ClassLoader2 loader2 = new ClassLoader2();
        Class<?> clazz1 = loader1.loadClass("Person");
        Class<?> clazz2 = loader1.loadClass("Person");
        System.out.println(clazz1.getClassLoader());

        System.out.println("hahah");
        System.out.println("dfsdfsd");
        System.out.println("dss111fds");
    }
}
class ClassLoader1 extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}

class ClassLoader2 extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}