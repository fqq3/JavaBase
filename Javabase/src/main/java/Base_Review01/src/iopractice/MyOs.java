package iopractice;

import java.io.*;

/**
 * @author: fangqingqing
 * @Date: 2025/5/8 - 05 - 08 - 17:45
 * @Description: iopractice
 * @version: 1.0
 */
public class MyOs {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("【1】System的属性：\n" +
                "System.in  : “标准”输入流。---》默认情况下  从键盘输入\n" +
                "System.out  :“标准”输出流。 ---》默认情况下，输出到控制台。");
        InputStream in = System.in;
////        调用方法：
//        int n = in.read();//read方法等待键盘的录入，所以这个方法是一个阻塞方法。
//        System.out.println(n);
//        Scanner scan1 = new Scanner(new FileInputStream(new File("D:\\Code\\Java_code\\Javabase\\demo.txt")));
//        while(scan1.hasNext()){
//            System.out.println(scan1.next());
//        }
        PrintStream out=System.out;
        out.print("nige  mimi");
        out.println("yi he jie dao");
        System.out.println("yigegua??");
        File f1=new File("D:\\Code\\Java_code\\Javabase\\democopy1.txt");

//        System.out.println("===========键盘录入输出到文件=====================");
//        InputStream inputStream = System.in;
//        InputStreamReader isr=new InputStreamReader(in);
//        BufferedReader br =new BufferedReader(isr);
//
//        FileWriter fw=new FileWriter(f1);
//        BufferedWriter bw=new BufferedWriter(fw);
//        String s = br.readLine();
//        while(!s.equals("exit")){
//            bw.write(s);
//            bw.newLine();
//            s=br.readLine();
//        }
//        //关闭流
//        br.close();
//        bw.close();
//
        System.out.println("===================数据流======================");
        System.out.println("DataInputStream:将文件中存储的基本数据类型和字符串  写入  内存的变量中\n" +
                "DataOutputStream:  将内存中的基本数据类型和字符串的变量 写出  文件中");
        FileOutputStream fos=new FileOutputStream(f1);//,true
        DataOutputStream dos =new DataOutputStream(fos);
        dos.writeUTF("你好");
        dos.writeInt(100);
        dos.writeDouble(100.0);
        dos.writeBoolean(true);

        DataInputStream dis=new DataInputStream(new FileInputStream(f1));
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        dis.close();//关闭流
        dos.close();//关闭流
        System.out.println("===================对象流======================");
        System.out.println("\n" +
                "【2】序列化和反序列化：\n" +
                "ObjectOutputStream 类 ： 把内存中的Java对象转换成平台无关的二进制数据，从而允许把这种二进制数据持久地保存在磁盘上，或通过网络将这种二进制数据传输到另一个网络节点。----》序列化\n" +
                "ObjectInputStream类 ： 当其它程序获取了这种二进制数据，就可以恢复成原来的Java对象。----》反序列化\n");
        FileOutputStream foss=new FileOutputStream(f1);//,true
        ObjectOutputStream oos=new ObjectOutputStream(foss);
        oos.writeObject("离开");
        oos.close();
        FileInputStream fis=new FileInputStream(f1);
        ObjectInputStream ois=new ObjectInputStream(fis);
        String s = (String)(ois.readObject());
        System.out.println(s);
        ois.close();
        System.out.println("（1）被序列化的类的内部的所有属性，必须是可序列化的 （基本数据类型都是可序列化的）\n" +
                "(2)static，transient修饰的属性 不可以被序列化。");
    }
}
