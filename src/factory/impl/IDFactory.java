package factory.impl;

import factory.Factory;
import factory.Product;

import java.util.*;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class IDFactory implements Factory {

    private List<String> owers = new ArrayList<>(10);

    @Override
    public void registerProduct(Product p) {
        owers.add(p.getName());
    }

    @Override
    public Product createProduct(String name) {
        return new IDProduct(name);
    }
    public List<String> getOwers(){
        return owers;
    }
}
