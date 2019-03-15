package thread;

import java.util.Random;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */

class MyThread1 extends Thread{
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long resut = 0;
        for (int j=0;j<10;j++){
            for (int i=0;i<50000;i++){
                Random random = new Random();
                random.nextInt();
                resut+=i;
            }
        }
        System.out.println("############## t1用的时间:"+(System.currentTimeMillis() - start));
    }
}

public class MyThread2 extends Thread{
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long resut = 0;
        for (int j=0;j<10;j++){
            for (int i=0;i<50000;i++){
                Random random = new Random();
                random.nextInt();
                resut+=i;
            }
        }
        System.out.println("************** t2用的时间:"+(System.currentTimeMillis() - start));
    }


    public static void main(String[] args) {
        //线程优先级高的，被cpu调度执行的可能性较大，但是也有可能优先级低的先执行，这只是个相对值
        //线程优先级高低与代码顺序无关
       for(int i=0;i<5;i++){
           MyThread2 myThread2 = new MyThread2();
           myThread2.setPriority(5);
           myThread2.start();
           MyThread1 myThread1 = new MyThread1();
           myThread1.setPriority(6);


           myThread1.start();
       }
    }
}

