package threadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.*;


public class SimpleThreadLocal<T> {

    private final Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>());

    //增
    public void add(T val){
        Thread thread = Thread.currentThread();
        map.put(thread,val);
    }
    // 删
    public void remove(){
      map.remove(Thread.currentThread());
    }
    // 改
    public void update(T val){
        map.put(Thread.currentThread(),val);
    }
    // 查
    public T get(){
        Thread thread = Thread.currentThread();
        if(!map.containsKey(thread)){
            map.put(thread,null);
            return null;
        }else {
            return map.get(thread);
        }
    }

    public static void main(String[] args) {
        SimpleThreadLocal<List<String>> threadLocal = new SimpleThreadLocal<>();

        new Thread(() -> {
            List<String> params = new ArrayList<>(3);
            params.add("张三");
            params.add("李四");
            params.add("王五");
            threadLocal.add(params);
            System.out.println(Thread.currentThread().getName());
            threadLocal.get().forEach(param -> System.out.println(param));
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                List<String> params = new ArrayList<>(2);
                params.add("Chinese");
                params.add("English");
                threadLocal.add(params);
                System.out.println(Thread.currentThread().getName());
                threadLocal.get().forEach(param -> System.out.println(param));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {

                System.out.println(Thread.currentThread().getName());
                List<String> vals = threadLocal.get();
                if (vals == null){
                    System.out.println("Null.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
