package f;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
class MixedOrder{
    volatile int a = 0;
    boolean flag = false;
    public void writer(){
        a = 1;
        flag = true;
    }
    public void read(){
//        System.out.println(Thread.currentThread().getName()+"进入read方法");
        if(flag){
            a = a + 1;
        }
        System.out.println(Thread.currentThread().getName()+"   a="+a);  //Thread-0   a=0 1 2
    }
    public static void main(String[] args) {
       for (int i=0;i<100;i++){
           MixedOrder mixedOrder = new MixedOrder();
           Thread t1 = new Thread(() -> {
               mixedOrder.read();
           });
           Thread t2 = new Thread(() -> {
               mixedOrder.writer();
           });
           t2.start();
           t1.start();
       }
    }
}