package iopractice;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: fangqingqing
 * @Date: 2025/5/6 - 05 - 06 - 15:25
 * @Description: iopractice
 * @version: 1.0
 * 一键修复快捷键：Alt+Enter
 */
public class MyFile {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\Code\\Java_code");
        File f2=new File("D:"+File.separator+"Code"+File.separator+"Java_code");
        System.out.println(f1.canRead());
        System.out.println(f1.canWrite());
        System.out.println(f1.canExecute());//判断文件是否可执行
        System.out.println(f1.exists());//判断文件是否存在
        System.out.println(f1.isDirectory());//判断是否是文件夹
        System.out.println(f1.isFile());//
        System.out.println(f1.isHidden());
        System.out.println(f1.length());//获取文件大小
        System.out.println(f1.getAbsolutePath());//获取绝对路径
        System.out.println(f1.getPath());
        System.out.println(f1.getParent());//获取父路径
        System.out.println(f1.getName());//获取文件名
        System.out.println(f1.lastModified());//获取最后修改时间
        File f3 = new File("demo.txt");

//        if(f3.exists()){
//            f3.delete();
//            System.out.println("已经删除");
//        }else{
//            try {
//                f3.createNewFile();
//                System.out.println("创建成功");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        System.out.println("======================创建目录========================");
        File ff=new File("D:"+File.separator+"Code"+File.separator+"Java_code");
        File ff2=new File("D:\\Code\\Java_code\\rubbish");
        ff2.mkdir();//创建一级目录
        ff2.mkdirs();//创建多级目录
        System.out.println("删除：如果是删除目录的话，只会删除一层，" +
                "并且前提：这层目录是空的，里面没有内容，如果内容就不会被删除");
        ff2.delete();//删除单层目录

        File[] files=f1.listFiles();
        for(File file:files){
            System.out.println(file.getName()+"地址"+file.getAbsolutePath());
        }
        System.out.println("=====================写入/读取文件=========================");
        System.out.println("✅ 文件不存在时：如果目标文件不存在，FileWriter 会自动创建空文件。\n" +
                "❌ 父目录不存在时：如果文件路径中的目录层级不存在（如 D:/data/logs/output.txt 中的 logs 目录不存在），则会抛出 IOException。");
        FileWriter fw= null;
        try {
            fw = new FileWriter(f3);
            String str1="Sold out\n" +
                    "In a world full of followers ,I'll be a leader.\n" +
                    "In a world full of doubters,I'll be a believer.\n";
            for(int i=0;i<str1.length();i++){
                fw.write(str1.charAt(i));//第i个位置的字符；
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileReader fr = new FileReader(f3);
        int n = fr.read();
        System.out.println("n是字符对应的 Unicode 编码");
        while(n!=-1){
//            fw.write(n);
            System.out.print(" FileReader:"+n);
            System.out.println();
            System.out.print("FileReader(char): "+(char) n);
            System.out.println();
            n = fr.read();
        }
        char[] cha=new char[50];
        int len=fr.read(cha);
        while(len!=-1){
            String str2=new String(cha,0,len);
            System.out.println(str2);
            len=fr.read(cha);
        }
        fr.close();

        System.out.println("==========================对文件追加=================================");
        System.out.println("new FileWriter(f)   相当于对原文件进行覆盖操作。\n" +
                "new FileWriter(f,false)  相当于对源文件进行覆盖操作。不是追加。\n" +
                " new FileWriter(f,true)   对原来的文件进行追加，而不是覆盖。\n");
        File f33=new File("D:\\Code\\Java_code\\Javabase\\demo.txt");
        String str2=new String("I'm stepping out without hesitation.\n" +
                "Because the battle's alraedy been won.\n" +
                "I'm sold out.\n" +
                "I'm no longer living. \n" +
                "Just for myself.\n") ;
        char[] chb=str2.toCharArray();
        FileWriter fww=new FileWriter(f33,true);
        fww.write(chb);
        System.out.println("fww.write(chb);");
        String str3=new String("Running after Jesus\n" +
                "with my whole heart\n");
        fww.write(str3);
//        char[] chc=str3.toCharArray();
//        fww.write(chc);
        fww.close();
        System.out.println("==========================拷贝文件========================");
        File f4=new File("D:\\Code\\Java_code\\Javabase\\democopy1.txt");
        FileReader f4r= null;
        FileWriter f4w= null;
        try {
            f4r = new FileReader(f33);
            f4w = new FileWriter(f4);
            char[] chd=new char[80];
            int len4 =f4r.read(chd);

            while(len4!=-1){
    //            String s = new String(chd,0,len);
                f4w.write(chd,0,len4);
                len4=f4r.read(chd);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("后创的流，先关");
            f4w.close();
            f4r.close();
        }

        System.out.println("文本文件：.txt   .java  .c  .cpp  ---》建议使用字符流操作\n" +
                "非文本文件：.jpg,  .mp3  ,   .mp4 , .doc  , .ppt  ---》建议使用字节流操作\n");
        //        int ch1 =fr.read();
//        int ch2 =fr.read();
//        int ch3 =fr.read();
//        int ch4 =fr.read();



    }
}
