package syn;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Main {

    public int i = 10;
    public synchronized void operateIMainMethod(){
        try {
            i--;
            System.out.println("main print i="+i);
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Sub extends Main{
    public synchronized void operateISubMethod(){
        try {
            while (i>0){
                i--;
                System.out.println("sub print i="+i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            Sub sub = new Sub();
            sub.operateISubMethod();
        }).start();
    }
}
