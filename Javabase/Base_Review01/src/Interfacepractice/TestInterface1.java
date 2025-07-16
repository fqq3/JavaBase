package Interfacepractice;

/**
* @Auther: fangqingqing
* @Date: 2025/4/20 - 04 - 20 - 11:58 
* @Description: Interfacepractice
* @version: 1.0
*/public interface TestInterface1 {
    public static final int num=10;
    public abstract void action();
    public default void sleep(){
        System.out.println("interface 里的sleep");
    }
    public static void a(){
        System.out.println("静态方法不能重写,在interface1 ing!!");
    }

}
class Test implements TestInterface1{
    public void action(){
        System.out.println("action");
    }
    public void none(){
        TestInterface1.super.sleep();
        System.out.println("none");
    }
    public static void a(){
        System.out.println("UtilDatePractice 中的static 方法");
    }
    public void sleep(){
        System.out.println("类里的sleep");
    }

}