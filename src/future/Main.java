package future;

import java.util.concurrent.FutureTask;

/**
 * 系统启动，调用Client发出请求
 */
public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("Hello Future!");
        System.out.println("请求完毕！");

        try {
            //模拟处理其他业务
            System.out.println("处理其他业务逻辑...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("真实数据：" + data.getResult());
    }
}