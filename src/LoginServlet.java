/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public synchronized static void doPost(String username,String password) {
        try {
            usernameRef = username;
            if (username.equals("a")){
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username:"+usernameRef+" password:"+passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ALogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}

class BLogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}

class Run{
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        BLogin bLogin = new BLogin();
        aLogin.start();
        bLogin.start();
    }
}
