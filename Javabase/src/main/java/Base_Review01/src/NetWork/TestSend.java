package NetWork;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Auther: fqq
 * @Date: 2025/5/12 - 05 - 12 - 17:19
 * @Description: NetWork
 * @version: 1.0
 */
public class TestSend {
    public static void main(String[] args) {
        System.out.println("发送方步骤：" +
                "1.创建DatagramSocket ds " +
                "2.定义发送内容str" +
                "3.str.getByte()转换为byte[]" +
                "4.封装byte为DatagramPacket" +
                "5.端口发送数据包ds.send(dp)");
        System.out.println("学生上线");
        DatagramSocket ds = null;//UDP套接字对象DatagramSocket，用于发送数据包。此套接字将自动绑定到本地主机的一个可用端口。
        try {
            ds = new DatagramSocket(8888);
            while (true) {
                System.out.print("学生：");
                System.out.print("你好！");
                Scanner sc=new Scanner(System.in);
                String str=sc.nextLine();
                byte[] b=str.getBytes();
        //需要四个参数：1.指的是传送数据转为Z字节数组2.字节数组的长度3.封装接收方的ip4.接收方的端口号
                DatagramPacket dp=new DatagramPacket(b,b.length, InetAddress.getByName("localhost"),9999);
                ds.send(dp);//发送完成
                if(str.equals("bye")){
                    System.out.println("学生下线");
                    break;

                }

                //接收老师回复
                byte[] b1=new byte[1024];//设置一个字节数组作为接收数据的缓冲区
                DatagramPacket dp1=new DatagramPacket(b1,b1.length);//数据报包，用于存储需要发送的或接收到的数据
                ds.receive(dp1);//阻塞等待接收数据报包

                byte[] data=dp1.getData();//获取接收到的数据存储在一个字节数组中
                String str1=new String(data,0,dp1.getLength());

                System.out.println("已收到老师回复："+str1);

            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            if(ds!=null)
                ds.close();
        }


    }
}
