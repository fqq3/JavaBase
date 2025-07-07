package NetWork;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Auther: fqq
 * @Date: 2025/5/12 - 05 - 12 - 17:29
 * @Description: NetWork
 * @version: 1.0
 */
public class TestReceive {
    public static void main(String[] args)  {
        System.out.println("接收方步骤：" +
                "1.根据端口号创建DatagramSocket  ds \n" +
                "2.创建接收缓冲数组：new byte[1024]\n" +
                "3.创建一个空的 DatagramPacket，准备接收来自UDP套接字的数据。\n" +
                "4.ds.receive(dp);阻塞接收直到数据包到达,数据将被存储在dp的字节数组b中\n");
        System.out.println("接收方，老师上线");
        //接收
        DatagramSocket ds= null;//接收和发送UDP数据报的类
        try {
            ds = new DatagramSocket(9999);
            while (true){
                byte[] b=new byte[1024];//设置一个字节数组作为接收数据的缓冲区
                DatagramPacket dp=new DatagramPacket(b,b.length);//数据报包，用于存储需要发送的或接收到的数据
                ds.receive(dp);//阻塞等待接收数据报包

                byte[] data=dp.getData();//获取接收到的数据存储在一个字节数组中
                String str=new String(data,0,dp.getLength());
                System.out.println("收到学生留言："+str);
                if(str.equals("bye")){
                    System.out.println("老师下线");
                    break;
                }
                //发送
                Scanner sc=new Scanner(System.in);
                System.out.println("老师：");
                String str1=sc.nextLine();
                byte[] b1=str1.getBytes();
                DatagramPacket dp1=new DatagramPacket(b1,b1.length, InetAddress.getByName("localhost"),8888);
                ds.send(dp1);
            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if(ds!=null)
                ds.close();
        }


    }
}
