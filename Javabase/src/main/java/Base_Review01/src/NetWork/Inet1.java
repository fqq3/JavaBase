package NetWork;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Inet1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia1=InetAddress.getByName("192.168.1.100");
        System.out.println(ia1);
        InetAddress ialocal=InetAddress.getByName("localhost");
        System.out.println("本机ip地址"+ialocal);

        InetAddress ia2=InetAddress.getByName("MO");
        System.out.println(ia2);
        InetAddress ia3=InetAddress.getByName("www.mashibing.com");
        System.out.println("域名解析后对应的ip地址"+ia3);
        System.out.println("获取域名"+ia3.getHostName());
        System.out.println("获取ip地址"+ia3.getHostAddress());
        InetSocketAddress isa1=new InetSocketAddress("192.168.1.100",8040);
        System.out.println(isa1.getHostName());
        System.out.println(isa1);
        System.out.println(isa1.getPort());
        System.out.println(isa1.getAddress());

    }
}
