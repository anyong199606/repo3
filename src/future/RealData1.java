package future;

import java.util.concurrent.*;


public class RealData1 implements Callable<String> {
    private String result;

    public RealData1(String result) {
        this.result = result;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(result);
        //模拟耗时的构造数据过程
        Thread.sleep(5000);
        return sb.toString();
    }
}

class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long strat = System.currentTimeMillis();
        RunnableFuture<String> futureTask = new FutureTask<>(new RealData1("Hello"));

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(futureTask);

        System.out.println("请求完毕！");

        try {
            Thread.sleep(2000);
            System.out.println("这里经过了一个2秒的操作！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("真实数据：" + futureTask.get());
        System.out.println("用时:"+(System.currentTimeMillis() - strat));
        executorService.shutdown();
    }
}
