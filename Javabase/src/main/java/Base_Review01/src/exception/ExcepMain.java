package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/20 - 04 - 20 - 19:05
 * @Description: exception
 * @version: 1.0
 */
public class ExcepMain {
    public static void main(String[] args) {

        try {
            Scanner sc =new Scanner(System.in);
            System.out.println("请录入第一个数：");
            int num1=sc.nextInt();
            System.out.println("请录入第二个数：");
            int num2=sc.nextInt();
            System.out.println("请录入第三个数：");
            System.out.println("二者之商："+num1/num2);
        }catch (InputMismatchException e) {
            System.out.println("输入不匹配");
        }catch(ArithmeticException e){
            System.out.println("除数不能为0");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("1.不提示问题");
            System.out.println("2.提示出现异常！！");
            System.out.println("3.1打印异常信息！！print e.toString():"+e.toString());
            System.out.println("3.2显示异常描述信息对应的字符串，如果没有就显示null;print e.getMessage():"+e.getMessage());
            System.out.println("3.3显示异常的堆栈信息:e.printStackTrace();");
            //e.printStackTrace();
            System.out.println("4.抛出异常 throw e;");
            System.out.println("什么情况下，try-catch后面的代码不执行？\n" +
                    "（1）throw抛出异常的情况\n" +
                    "（2）catch中没有正常的进行异常捕获\n" +
                    "（3）在try中遇到return");

        }finally{
            System.out.println(" 想让try-catch后面的代码必须执行\n" +
                    "只要将必须执行的代码放入finally中，那么这个代码无论如何一定执行。\n"
            +"即使try里有return,先执行finally");
            System.out.println("只有System.exit()终止当前的虚拟机执行,可以让finally不执行");
            System.out.println("】try中出现异常以后，将异常类型跟catch后面的类型依次比较，按照代码的顺序进行比对，执行第一个与异常类型匹配的catch语句\n" +
                    "【2】一旦执行其中一条catch语句之后，后面的catch语句就会被忽略了！\n" +
                    "【3】在安排catch语句的顺序的时候，一般会将特殊异常放在前面（并列），一般化的异常放在后面。\n" +
                    "先写子类异常，再写父类异常。\n" +
                    "【4】在JDK1.7以后，异常新处理方式：可以并列用|符号连接：");
            System.out.println("运行异常：运行时发现异常，空指针等");
            System.out.println("检查异常：写好代码检测出异常，未调试");
            System.out.println("感谢使用~");

        }
//        Scanner sc =new Scanner(System.in);
//        int n1=sc.nextInt();
//        int n2=sc.nextInt();
//        if(n2==0){
////            try{
////                throw new Exception() ;
////            }catch(Exception e){
////                e.printStackTrace();
////            }
//            throw new Exception();
//        }
        Student s = new Student();;
        s.setName("lili");
        s.setAge(18);
        s.setSex("女");
        Student ss=new Student(22, "Lihua","abc");
        System.out.println("s:"+s);
        System.out.println("重载与抛出的异常无关");
        System.out.println("重写子类异常<父类");
    }
}
