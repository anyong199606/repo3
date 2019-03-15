package factory.impl;

import factory.Product;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class IDProduct implements Product {
    private String name;
    IDProduct (String name){
        System.out.println("正在制作:"+name+"明信片");
        this.name = name;
    }
    @Override
    public void use() {
        System.out.println("正在使用:"+name+"明信片");
    }
    public String getName(){
        return this.name;
    }
}
