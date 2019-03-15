package desingle;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		FutureClient fc = new FutureClient();
		Data data = fc.request("请求参数");//
		System.out.println("请求发送成功!");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("做其他的事情...");

		String result = data.getRequest();
		System.out.println(result);
		System.out.println("总共耗时:"+(System.currentTimeMillis() - start));
		
	}
}
