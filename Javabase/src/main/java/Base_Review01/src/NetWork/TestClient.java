package NetWork;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Auther: fqq
 * @Date: 2025/5/11 - 05 - 11 - 22:03
 * @Description: NetWork
 * @version: 1.0
 */
public class TestClient {
    public static void main(String[] args) {
        Socket s1= null;//创建客户端Socket对象
        OutputStream os1=null;//输出流
        ObjectOutputStream oos1=null;//对象输出流
        InputStream is=null;//创建输入流
        DataInputStream dis=null;//数据输入流

        try {
            s1 = new Socket("192.168.230.10",8888);
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name=sc.next();
            System.out.println("请输入密码：");
            String pwd=sc.next();
            //将账号和密码封装为一个User的对象：
            User u1=new User(name,pwd);
            //向外发送数据
            os1= s1.getOutputStream();
            oos1=new ObjectOutputStream(os1);
            oos1.writeObject(u1);

            //接收服务器端的回话
            is= s1.getInputStream();
            dis=new DataInputStream(is);
            boolean b=dis.readBoolean();
            if(b){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
            //        String str=dis.readUTF();
//        System.out.println("服务器发送信息为："+str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(dis!=null){
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                if (is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(oos1!=null){
                    oos1.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os1!=null) {
                    os1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(s1!=null) {
                    s1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
