import java.lang.reflect.Field;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public enum Demo {

    Success(1,"asd");
    private final Integer id;
    private final String val;

    Demo(Integer id,String val){
        this.id = id;
        this.val = val;
    }
    public Integer getId() {
        return id;
    }

    public String getVal() {
        return val;
    }

    public static void main(String[] args) {
        Class<Demo> clazz = Demo.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }
    }
}
