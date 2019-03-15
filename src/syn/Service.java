package syn;


public class Service {

    public synchronized void service1(){
        System.out.println("service1");
        service2();
    }

    private synchronized void service2() {
        System.out.println("service2");
        service3();
    }
    private synchronized void service3() {
        System.out.println("service3");
    }

    public static void main(String[] args) {
        Service service = new Service();
        new Thread(()->{
            service.service1();
        }).start();
    }
}


