package NetWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: fqq
 * @Date: 2025/5/12 - 05 - 12 - 16:34
 * @Description: NetWork
 * @version: 1.0
 */
public class ServerThread extends Thread{
    InputStream is=null;//输入流
    ObjectInputStream ois=null;//对象输入流
    OutputStream os=null;//输出流
    DataOutputStream dos=null;//数据输出流
    boolean flag =false;

    ServerSocket ss= null;//创建服务器套接字
    Socket s=null;//客户端Socket
    public ServerThread(Socket s){
        this.s=s;
    }
    @Override
    public void run() {
        try{
            //获取输入流
            is=s.getInputStream();
            ois=new ObjectInputStream(is);
//        String str=dis.readUTF();
            User u1=(User)(ois.readObject());
            if(u1.getName().equals("lili") && u1.getPwd().equals("111222")){
                flag=true;
            }
//        System.out.println("客户端发来的数据为："+str);
            //向客户端发送数据
            os =s.getOutputStream();
            dos=new DataOutputStream(os);
            dos.writeBoolean(flag);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (dos != null) {
                    dos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
