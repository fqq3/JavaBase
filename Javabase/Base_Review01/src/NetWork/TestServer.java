package NetWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: fqq
 * @Date: 2025/5/11 - 05 - 11 - 22:11
 * @Description: NetWork
 * @version: 1.0
 */
public class TestServer {
    public static void main(String[] args) {
        System.out.println("已经启动服务器");
        ServerSocket ss= null;//创建服务器套接字
        Socket s=null;//客户端Socket
        int count=0;
        try {
            System.out.println("Waiting for client connection...");
            ss = new ServerSocket(8888);
            while (true) {
                s=ss.accept();//阻塞方法 返回值为客户端Socket
                new ServerThread(s).start();
                count++;
                System.out.println("当前是第"+count+"个用户,相关信息如下："+s.getInetAddress());
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }

    }

}

