package thread.test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Test {
    static final CountDownLatch countDownLatch = new CountDownLatch(5);
    static ArrayList<User> list_1 = new ArrayList<>();;
    static ArrayList<User> list_2 = new ArrayList<>();;
    static ArrayList<User> list_3 = new ArrayList<>();;
    static ArrayList<User> list_4 = new ArrayList<>();;
    static ArrayList<User> list_5 = new ArrayList<>();;
    static ArrayList<ArrayList<User>> lists = new ArrayList<>();
    static {
        list_1.add(new User(2 + "", 2));
        list_1.add(new User(1 + "", 1));

        list_2.add(new User(3 + "", 3));
        list_2.add(new User(4 + "", 4));

        list_3.add(new User(5 + "", 5));
        list_3.add(new User(6 + "", 6));

        list_4.add(new User(7 + "", 7));
        list_4.add(new User(8 + "", 8));

        list_5.add(new User(9 + "", 9));
        list_5.add(new User(10 + "", 10));

        lists.add(list_1);
        lists.add(list_2);
        lists.add(list_3);
        lists.add(list_4);
        lists.add(list_5);
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new MyThread(lists.get(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main end!");
    }
}

class MyThread extends Thread{
    private ArrayList<User> users;
    public MyThread(ArrayList<User> users){
        this.users = users;
    }
    @Override
    public void run() {
        for (int i=0;i<users.size();i++){
            System.out.println(Thread.currentThread().getName()+"   "+users.get(i));
        }
        Test.countDownLatch.countDown();
    }
}
