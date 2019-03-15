
public class SynObject {

    private String username = "a";
    private String password = "aa";

    //锁的是对象
    public synchronized void printString(String username,String password){
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class MThread extends Thread{
    private SynObject synObject;
    public MThread(SynObject synObject){
        this.synObject = synObject;
    }

    @Override
    public void run() {
        synObject.printString("b","bb");
    }
}

class R{
    public static void main(String[] args) {
        try {
            SynObject synObject = new SynObject();
            MThread mThread = new MThread(synObject);
            mThread.start();
            Thread.sleep(500);//main线程睡眠
            mThread.stop();
            System.out.println(synObject.getUsername()+"    "+synObject.getPassword());
        }catch (Exception e){

        }
    }
}