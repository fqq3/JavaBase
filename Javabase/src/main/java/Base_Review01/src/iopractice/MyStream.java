package iopractice;

import java.io.*;

/**
 * @author: fangqingqing
 * @Date: 2025/5/6 - 05 - 06 - 19:36
 * @Description: iopractice
 * @version: 1.0
 */
public class MyStream {
    public static void main(String[] args) {
        File f1=new File("D:\\Code\\Java_code\\Javabase\\demo.txt");
        FileInputStream fis1=null;
        try {
            fis1=new FileInputStream(f1);
            int n=fis1.read();
            while(n!=-1){
                System.out.println("FileInputStream:"+n);
                n=fis1.read();
            }
            System.out.println("编码格式UTF-8，英文1字节。中文3字节，字节流读Unicode编码，会拆开汉字");
            System.out.println("文本文件用字符流：FileReader(),FileWriter(),BufferedReader");
            System.out.println("fileInputStream的read方法返回值都是正数，避免-1，无法判断是否结束");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if(fis1!=null){
                    fis1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("===================字节流测试图片（非文本）========================");
        File f2=new File("D:\\pictures\\wy2.jpg");
        FileInputStream fis2=null;
        byte[] b1 = new byte[100];
        int len= 0;

        try {
            fis2=new FileInputStream(f2);
            len = fis2.read(b1);
//            int c2=fis2.read();
//            while(c2!=-1){
//                System.out.println(c2);
//                c2=fis2.read();
//            }
            while(len!=-1){
               for(int i=0;i<len;i++){
                   System.out.println(b1[i]);
               }
                len=fis2.read(b1);
            }
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if (fis1!=null) {
                    fis1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("===================字节流copy图片（非文本）========================");
        //原图片 f2
        //新图片
        File f3=new File("D:\\pictures\\wy2copy.jpg");
        FileInputStream fis3=null;
        FileOutputStream fos3=null;
        try{
            fis3=new FileInputStream(f2);
            fos3=new FileOutputStream(f3);
            byte[] b2=new byte[1024*8];
            len=fis3.read(b2);
            while(len!=-1){
                fos3.write(b2,0,len);
                len=fis3.read(b2);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if(fis3!=null){
                    fis3.close();
                }
                if(fos3!=null){
                    fos3.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
