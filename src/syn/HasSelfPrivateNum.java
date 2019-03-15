package syn;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class HasSelfPrivateNum {
    private int num;
    public void addI(String username) throws InterruptedException {
        synchronized(HasSelfPrivateNum.class){
            if (username.equals("a")){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username+"   num="+num);
        }

    }

    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum);
        ThreadB threadB = new ThreadB( new HasSelfPrivateNum());
        threadA.start();
        threadB.start();
    }

}

class ThreadA extends Thread{
    private HasSelfPrivateNum hasSelfPrivateNum;
    public ThreadA(HasSelfPrivateNum hasSelfPrivateNum){
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        try {
            hasSelfPrivateNum.addI("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadB extends Thread{
    private HasSelfPrivateNum hasSelfPrivateNum;
    public ThreadB(HasSelfPrivateNum hasSelfPrivateNum){
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        try {
            hasSelfPrivateNum.addI("b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}