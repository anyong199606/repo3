
package syn;

class ThreadTrain2 implements Runnable {
	private static int train1Count = 100;
	private Object oj = new Object();
	public boolean flag = true;

	@Override
	public void run() {
		if (flag) {
                  while (train1Count > 0) {

          			synchronized (this) {
          				if(train1Count>0){
          					try {
          						Thread.sleep(500);
          					} catch (Exception e) {
          						// TODO: handle exception
          					}
          					System.out.println(Thread.currentThread().getName()+ "             " + (100 - train1Count + 1));
          					train1Count--;
          				}
          			}

				}
		}
		else{
			while (train1Count > 0) {

				sale();
			}
		}

	}

	public   synchronized void sale() {

		if (train1Count > 0) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName() + "    " + (100 - train1Count + 1) );
			train1Count--;
		}
		// }

	}
}

public class ThreadDemo2 {

	public static void main(String[] args) throws InterruptedException {
		ThreadTrain2 threadTrain2 = new ThreadTrain2();
		Thread t1 = new Thread(threadTrain2, "t1");
		Thread t2 = new Thread(threadTrain2, "t2");
        Thread t3 = new Thread(threadTrain2, "t3");
        Thread t4 = new Thread(threadTrain2, "t4");
        t3.start();
        t4.start();
		t1.start();
	    Thread.sleep(500);
	    threadTrain2.flag=false;
		t2.start();
	}

}
