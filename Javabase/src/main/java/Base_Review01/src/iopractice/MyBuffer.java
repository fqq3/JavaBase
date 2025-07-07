package iopractice;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author: fangqingqing
 * @Date: 2025/5/7 - 05 - 07 - 21:32
 * @Description: iopractice
 * @version: 1.0
 */
public class MyBuffer {
    public static void main(String[] args) {
        // 打印当前环境默认编码
        System.out.println("Default encoding: " + java.nio.charset.Charset.defaultCharset());
        // 测试标准UTF-8输出
        System.out.println("Test UTF-8: " + new String("你好".getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));

        File f1 =new File("D:\\pictures\\wy2.jpg");
        File f2 =new File("D:\\pictures\\wy2copy1.jpg");
        File f11 =new File("D:\\Code\\Java_code\\Javabase\\demo.txt");
        File f12 =new File("D:\\Code\\Java_code\\Javabase\\democopy1.txt");

        long startTime = System.currentTimeMillis();
        System.out.println("=======================字节流=======================");
        try {
            FileInputStream fis1=new FileInputStream(f1);
            FileOutputStream fis2=new FileOutputStream(f2);
            BufferedInputStream bis1=new BufferedInputStream(fis1);
            BufferedOutputStream bis2=new BufferedOutputStream(fis2);
            //   byte[] allBytes = inputStream.readAllBytes();
            byte[] bf=new byte[1024*8];
            int len=bis1.read(bf);
            while(len!=-1){
                bis2.write(bf,0,len);
                len=bis1.read(bf);
            }

            bis2.close();
            bis1.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        f2.delete();
//        System.out.println("f2第一次delete");
        long endTime = System.currentTimeMillis();
        System.out.println("复制完成的时间为："+(endTime-startTime));
        System.out.println("=======================字符流=======================");
        try {
            FileReader fr1=new FileReader(f11);
            FileWriter fw1=new FileWriter(f12);
            BufferedReader br1=new BufferedReader(fr1);
            BufferedWriter bw1=new BufferedWriter(fw1);
            System.out.println("==============方法一：缓冲数组============");
            char[] chars=new char[1024*8];
            int len=br1.read(chars);
            while(len!=-1){
                bw1.write(chars,0,len);
                len=br1.read(chars);
            }
//            System.out.println("==============方法二：String数组============");
//            String str1=br1.readLine();
//            while(str1!=null){
//                bw1.write(str1);
//                bw1.newLine();
//                str1=br1.readLine();
//            }

            bw1.close();
            br1.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        f12.delete();
        System.out.println("f12第二次delete");
        System.out.println("==============转换流============");
        try {
            FileInputStream fis1=new FileInputStream(f11);
            FileOutputStream fos1=new FileOutputStream(f12);
            InputStreamReader  isr1=new InputStreamReader(fis1,"utf-8");
            OutputStreamWriter osw1=new OutputStreamWriter(fos1,"gbk");
            char[] chars = new char[1024*8];
            int len=isr1.read(chars);
            while(len!=-1){
                System.out.println(new String(chars,0,len) );
                osw1.write(chars,0,len);
                len=isr1.read(chars);
            }
            osw1.close();
            isr1.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        f12.delete();
        System.out.println("f12第三次delete");

    }
}
