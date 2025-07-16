package myreflect;

import classpractice.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author: fqq
 * @Date: 2025/5/15 - 05 - 15 - 19:29
 * @Description: myreflect
 * @version: 1.0
 */
public class TestPS {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        PersonT pt=new PersonT();
        //1.
        Class c1= pt.getClass();
        //2.
        Class c2=PersonT.class;
        System.out.println(c1+"\t"+c2);
        System.out.println(c1==c2);
        //3.用的最多，调用Class的静态方法
        Class c3=Class.forName("myreflect.PersonT");////////********
        System.out.println("c3:"+c3);
        //4:
        ClassLoader cl=TestPS.class.getClassLoader();//系统类加载器
        Class c4=cl.loadClass("myreflect.PersonT");
        System.out.println(c4);
        System.out.println("=====================Class类的具体实例============================");
        Class cl1= Person.class;
        Class cl2=Comparable.class;
        Class cl3=Override.class;
        int[] arr1={1,2,3};
        Class cl4=arr1.getClass();
        int[] arr2={5,6,7};
        Class cl5=arr2.getClass();
        System.out.println(cl4 == cl5);
        Class cl6=int.class;
        Class cl7=void.class;
        System.out.println("=================获取构造器================");
        Class cls =StudentT.class;

        System.out.println("getConstructors只能获取public修饰的构造器");
        Constructor[] cstt1=cls.getConstructors();
        for(Constructor c:cstt1){
            System.out.println(c);

        }
        System.out.println("getDeclaredConstructors:获取运行时类的全部修饰的构造器");
        Constructor[] cstt2=cls.getDeclaredConstructors();
        for(Constructor c:cstt2){
            System.out.println(c);
        }
        System.out.println("=================获取方法================");
        Constructor con1=cls.getConstructor();
//        Constructor con2=cls.getConstructor(int.class,double.class);
        Constructor con3=cls.getDeclaredConstructor(int.class);
        Object o1=con1.newInstance();
//        Object o2=con2.newInstance(178,130.5);
        System.out.println("=======================获取属性==========================");
        System.out.println("getFields:获取运行时类及其父类中声明为public的属性");
        Field[] fields=cls.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println("getDeclaredFields()获取所有属性");
        Field[] declaredFields=cls.getDeclaredFields();//***************
        System.out.println("==getField(name)获取指定属性==");
        Field score=cls.getField("score");
        System.out.println(score);
        Field sno=cls.getDeclaredField("sno");
        System.out.println(sno);
        System.out.println("=======================获取修饰符==========================");
        int modifiers=sno.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.toString(sno.getModifiers()));//****************
        System.out.println("获取属性的数据类型：getType()");
        Class clss=sno.getType();
        System.out.println(clss.getName());
        //获取属性的值
        Field sco=cls.getField("score");
        Object obj=cls.newInstance();
        sco.set(obj,98);
        System.out.println(obj);
        System.out.println("=======================获取方法==========================");
        Method[] methods=cls.getMethods();
        for(Method m:methods){
            System.out.println(m);
        }
        Method[] declaredMethods=cls.getDeclaredMethods();//*************
        for(Method m:declaredMethods){
            System.out.println(m);
        }
        System.out.println("==获取指定方法===");
        Method showInfo1=cls.getMethod("showInfo");
        Method showInfo2=cls.getMethod("showInfo",int.class,int.class);
        Method work=cls.getMethod("work",int.class);
        System.out.println("work"+work);
        System.out.println("获取方法的具体结构:Modifiers:");
        int mods=work.getModifiers();
        System.out.println("mods"+mods);
        System.out.println(Modifier.toString(mods));
        System.out.println("return type:"+work.getReturnType());
        Class[] para=work.getParameterTypes();
        for(Class c:para){
            System.out.println("参数"+c);
        }
        System.out.println("=======================获取注解==========================");
        Method mt=cls.getMethod("any");
        Annotation[] an=mt.getAnnotations();
        for(Annotation a:an){
            System.out.println("注解："+a);
        }
        Class[] excep=mt.getExceptionTypes();
        for(Class c:excep){
            System.out.println("异常："+c);
        }
        Object o=cls.newInstance();
        mt.invoke(o);
        System.out.println(showInfo2.invoke(o,1,2));
        System.out.println("======================获取interface(包括继承的)=======================");
        Class[] its=cls.getInterfaces();//
        for(Class  i:its){
            System.out.println(i);
        }
        Class sp=cls.getSuperclass();
        Class[] spitfs=sp.getInterfaces();
        for(Class c:spitfs){
            System.out.println(c);
        }
        System.out.println("===获取类所在的包===");
        Package pkg=cls.getPackage();
        System.out.println(pkg.getName()+"\t"+pkg);
        System.out.println("获取StudentT的注解");
        Annotation[] annos=cls.getAnnotations();
        for(Annotation a:annos)
        {
            System.out.println(a);
        }

    }
}
