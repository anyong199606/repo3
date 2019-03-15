package factory;

import java.util.List;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public interface Factory {

    default void create(String name){
        Product p = createProduct(name);
        registerProduct(p);
    }

    void registerProduct(Product p);

    Product createProduct(String name);

    List<String> getOwers();

}
