package net;

import java.net.*;
import java.util.Enumeration;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Test {
    public static void main(String[] args) throws SocketException {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("192.168.1.179", 8080);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(inetSocketAddress1.getHostString());
        System.out.println(inetSocketAddress1.getHostName());
        System.out.println(inetSocketAddress1.getHostString());

//        System.out.println(inetSocketAddress2.getHostName());
//        System.out.println(inetSocketAddress1.getHostString());
        String str = "你好Aa1";
        System.out.println(str.getBytes().length);
        char character = '你';
        System.out.println(character);
    }
}
