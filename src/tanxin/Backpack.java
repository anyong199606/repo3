package tanxin;

import java.util.*;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Backpack {
    private List<Goods> list = new ArrayList<>(10);
    private int size;

    public int getSize() {
        return list.size();
    }
    public void addGoods(Goods goods){
        list.add(goods);
    }
}
