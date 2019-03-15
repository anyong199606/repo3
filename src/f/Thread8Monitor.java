package f;

public class Thread8Monitor {

	
	/**
	 * 1:两个普通方法，两个线程，标准打印是什么?// one two
	 * 2:两个普通方法 新增Thread.sleep()给one()方.打印结果是什么？//two one
	 * 3:新增 普通方法，three(),打印结构：three two one two/three one
	 * 
	 * 4:两个普通方法，加了synchronize打印的结果是：//one two
	 * 5:修改one方法为静态方法，打印结果是://two one
	 * 6：修改两个方法都是静态方法: //one two
	 * 
	 * 
	 * 7:一个静态同步one(),一个非静态方法同步: 两个对象number对象 //two one
	 * 8:两个静态方法同步:   两个对象number对象  //one two
	 *  线程八锁：
	 *   1：非静态方法的锁默认是：this, 静态方法的锁为对应的：Class.类锁
	 *   2：只要你操作的对象是同一个，在某一时刻线程持有的锁，无论几个方法都是互斥的。都锁竞争的问题。
	 * 
	 */
	
	public static void main(String[] args) {
		
		Number number = new Number();
		Number number2 = new Number();
		new Thread(new Runnable() {
			@Override
			public void run() {
				number.one();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				number2.two();
			}
		}).start();
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				number.three();
//			}
//		}).start();
	}
	
}

class Number{
	
	public static synchronized void one() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("one");
	}
	
	public static synchronized void two() {
		System.out.println("two");
	}
	
	/*public void three() {
		System.out.println("three");
	}*/
}