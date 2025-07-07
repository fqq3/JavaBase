package classpractice;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/18 - 04 - 18 - 11:42
 * @Description: classpractice
 * @version: 1.0
 */
public class PracticeMain {

    public static void change2(Person p){
        p = new Person("李沐",3,22);
    }
    //静态块
    static{
        System.out.println("-----这是静态块");
    }
    //构造块
    {
        System.out.println("------这是构造块");
    }
    //构造器
    public PracticeMain(){
        System.out.println("这是空构造器");
    }
    public static void main(String[] args) {
        Person p1= new Person("小明",133325,18);//p1是一个地址
        p1.setHeight(1.78);//成员变量有默认值，不需要初始化，堆内存
        p1.setWeight(65.5);
        p1.eat();
        change2(p1);// p是对p1的值的复制，p1又赋了一个新地址故不改变p1
        //空构造器可以避免一些错误，要写
        //只要写了构造器，系统就不再分配，务必保持空构造器一直存在
        //成员方法里不写this，同名变量会遵循就近原则
        //同一个类里面可以用this调用成员方法，有时可以省略
        //同一个类中的构造器可以相互用this调用，注意：this修饰构造器必须放在第一行
        System.out.println(" static修饰属性总结：\n" +
                "        （1）static修饰的成员变量被该类的所有对象共享，在类加载的时候一起加载入方法区中的静态域中\n" +
                "        （2）static修饰的成员变量先于对象存在\n" +
                "        （3）访问方式： 对象名.属性名    类名.属性名（推荐）" +
                "\n静态属性 （类变量）当一个类的某个属性一样时，用static修饰很方便");

        //非静态属性（实例变量）
        System.out.println("静态方法：只能访问静态属性，不能访问非静态属性，不能访问非静态方法，不能访问this");
        //静态的方法可以用  也可以 用  类名.方法名 （推荐）
        //static方法占用的内存直到这个类被卸载回收才会被释放，基本是不会释放的
        //（1）代码块执行顺序：
        //最先执行静态块，只在类加载的时候执行一次，所以一般以后实战写项目：创建工厂，数据库的初始化信息都放入静态块。
        //一般用于执行一些全局性的初始化操作。
        //再执行构造块，（不常用）
        //再执行构造器，
        //再执行方法中的普通块。
        //（1）名字全部小写
        //（2）中间用.隔开
        //（3）一般都是公司域名倒着写 ：  com.jd   com.msb
        //（4）加上模块名字：
        //com.jd.login    com.jd.register
        //（5）不能使用系统中的关键字：nul,con,com1---com9.....
        //（6）包声明的位置一般都在非注释性代码的第一行：
        //1）使用不同包下的类要需要导包： import **.*.*;  例如：import java.util.Date;
        //（2）在导包以后，还想用其他包下同名的类，就必须要手动自己写所在的包。
        //（3）同一个包下的类想使用不需要导包，可以直接使用。
        //（4）在java.lang包下的类，可以直接使用无需导包：
        //（5）IDEA中导包快捷键：alt+enter
        //        可以自己设置自动导包
        //（6）可以直接导入*：
        System.out.println("import static java.xxx.aaa;");
        System.out.println("在静态导入后，同一个类中有相同的方法的时候，会优先走自己定义的方法。");
        System.out.println("封装性   private");
        System.out.println("实际开发中，方法一般会写成 setter，getter方法：\n" +
                "可以利用IDEA快捷键生成：alt+insert -->getter and setter:");
        Student s1=new Student();
        s1.setName("李婉");
        System.out.println("一个子类只能继承一个父类，可以间接继承其他类，Object类是所有类的根基父类。");
        System.out.println("private  同类访问");
        System.out.println("缺省时 同包访问");
        System.out.println("protected 同包+子类访问");
        System.out.println("public 整个项目访问");
        System.out.println("类：修饰符：两种：缺省，public");
        System.out.println("以后写代码\n" + "一般属性：用private修饰 ，方法：用public修饰\n");
        s1.setSchoolname("南芜");
        System.out.println("重载：方法名：相同 参数：不同 返回值：无关 修饰符：无关");
        System.out.println("重写：方法名：相同 参数：相同 返回值：分类的类型>子类  修饰符：父类权限低于子类");
        //子类不能限制父类方法的访问权限，否则可能会破坏外部代码对父类方法的访问
        System.out.println("所有构造器的第一行默认情况下都有super(),但是一旦你的构造器中显示的使用super调用了父类构造器，那么这个super()就不会给你默认分配了。");
        System.out.println("alt+Insert 选constructer。在构造器中，super调用父类构造器和this调用子类构造器只能存在一个，两者不能共存：\n" +
                "因为super修饰构造器要放在第一行，this修饰构造器也要放在第一行：");
        System.out.println(p1.toString()+"引用类型tostring还是地址");
        System.out.println(s1.toString());
        System.out.println("===========多态==========");
        Person p2=s1;//多态
        p2.eat();
        Worker w = new Worker();
        w.setName("张工");
        w.talk(p2);
        System.out.println("先有父类，再有子类：--》继承   先有子类，再抽取父类 ----》泛化 \n");
        System.out.println("instanceof测试一个对象是否是一个特定类的实例，或者是这个类的子类的实例\n"+
                "向上转型：向上转型指的是将子类对象转换为父类类型:Animal an = p;\n" +
                "向下转型:将父类类型转换为子类类型。向下转型是显式的:Pig pig = (Pig)an ;"
                +"向下转型，一定要先用instanceof判断!!!!!!!"
        );
        Person pp=HR.getPerson("学生");
        System.out.println("final 修饰的变量不可更改，一般大写，" +
                "final修饰方法，那么这个方法不可以被该类的子类重写，" +
                "final修饰类，代表没有子类，该类不可以被继承：");
        System.out.println("只有抽象类才有抽象方法，抽象方法可以继承，子类必须全部重写抽象方法，抽象类不能创建对象");
        System.out.println("面试题：\n" +
                "（1）抽象类不能创建对象，那么抽象类中是否有构造器？\n" +
                "抽象类中一定有构造器。构造器的作用  给子类初始化对象的时候要先super调用父类的构造器。\n" +
                "\n" +
                "（2）抽象类是否可以被final修饰？\n" +
                "不能被final修饰，因为抽象类设计的初衷就是给子类继承用的。要是被final修饰了这个抽象类了，就不能继承，没有子类。\n");
        System.out.println("单继承（父类）多实现（接口），先继承再实现");




    }

}
