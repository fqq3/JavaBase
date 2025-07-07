package Interfacepractice;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/20 - 04 - 20 - 13:57
 * @Description: Interfacepractice
 * @version: 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        Test t=new Test();
        Test.a();
        TestInterface1.a();
        System.out.println("1）被public default修饰的非抽象方法：\n" +
                "注意1：default修饰符必须要加上，否则出错\n" +
                "注意2：实现类中要是想重写接口中的非抽象方法，那么default修饰符必须不能加，否则出错。");
        System.out.println("类的组成：属性、方法、构造器、代码块（普通块、静态块、构造块、同步块），内部类（成员内部类、局部内部类）");
        System.out.println("局部方法：方法内、块内、构造器内");
        System.out.println("9.创建内部类的对象：\n" +
                "        静态的成员内部类创建对象：\n" +
                "        TestOuter.E e = new TestOuter.E();\n" +
                "        非静态的成员内部类创建对象：\n" +
                "        错误：TestOuter.D d = new TestOuter.D();\n" +
                "        TestOuter t = new TestOuter();\n" +
                "        TestOuter.D d = t.new D();");
        System.out.println(" public Comparable method3(){\n" +
                "        //3.匿名内部类\n" +
                "        return new Comparable(){\n" +
                "            @Override\n" +
                "            public int compareTo(Object o) {\n" +
                "                return 200;\n" +
                "            }\n" +
                "        };\n" +
                "    }");
    }
}
