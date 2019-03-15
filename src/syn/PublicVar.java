package syn;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class PublicVar {

    public String username = "A";
    public String password = "AA";

    public synchronized void setVal(String username,String password){
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("Thread.currentThread().getName():"+Thread.currentThread().getName()
                                +"  username:"+this.username+"  password:"+this.password);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void getVal(){
        System.out.println("Thread.currentThread().getName():"+Thread.currentThread().getName()
                +"  username:"+this.username+"  password:"+this.password);
    }

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        Thread1 thread1 = new Thread1(publicVar);
        thread1.start();
        Thread.sleep(200);
        publicVar.getVal();
        Thread.sleep(5000);
        publicVar.getVal();
    }
}
class Thread1 extends Thread{
    private PublicVar publicVar;
    public Thread1(PublicVar publicVar){
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        publicVar.setVal("B","BB");
    }
}
