package threadLocal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

    /**
     * 三个ThreadLocal
     */
    private static final int THREAD_LOOP_SIZE = 10;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 1000;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //线程池变量指定一个线程
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //ThreadLocal在一个线程中的存储格式是 一个ThreadLocal.ThreadLocalMap以ThreadLocal为key data为val来进行存储
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                int finalJ = j;
                executorService.execute(() -> {
                    threadLocal.set(("123" + finalJ).toString());
                });
//                new Thread(()->{
//                    threadLocal.set(("123" + finalJ).toString());
//                }).start();
            }
        }
    }
}
