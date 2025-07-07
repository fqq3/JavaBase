package newproperty;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/5/16 - 05 - 16 - 17:49
 * @Description: newproperty
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) throws FileNotFoundException {
        Per<String> per=new Per() {
            @Override
            public void eat(Object o) {
                super.eat(o);
            }
        };
        Per<String> perr=new Per<>() {
            @Override
            public void eat(String s) {
                super.eat(s);
            }
        };
        per.eat("牛奶");
        System.out.println("====================异常处理===========================");
        InputStreamReader isr1 =null;
        try{
            isr1 =new InputStreamReader(new FileInputStream("D:\\Code\\Java_code\\Javabase\\demo.txt"));
            isr1.read();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != isr1){
                try {
                    isr1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("=============java8==================");
        try(InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\Code\\Java_code\\Javabase\\demo.txt"));){
            isr.read();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("===================java9====================");
        InputStreamReader istr=new InputStreamReader(new FileInputStream( "D:\\Code\\Java_code\\Javabase\\demo.txt"));
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("D:\\Code\\Java_code\\Javabase\\demo.txt"));
        try(istr;osw){
            istr.read();
        }catch(Exception e){
            e.printStackTrace();
        }
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);



    }
}
class Per<T>{
    public void eat(T t){
        System.out.println("eat方法");
    }
}