package classpractice;

import java.io.*;
import java.util.*;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/29 - 04 - 29 - 19:57
 * @Description: classpractice
 * @version: 1.0
 */
public class BoundedGenerics {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Object> obj =new ArrayList<>();
        List<Person> per =new ArrayList<>();
        List<Student> stu =new ArrayList<>();

        List<? extends Person> list1=null;//extends继承
        System.out.println("泛型受限,上限：Person及其子类");
//        list1=obj;
        list1=per;
        list1=stu;
        List< ? super Person> list2=null;
        System.out.println("泛型受限,上限：Person及其父类");
        list2=obj;
        list2=per;
//        list2=stu;

        HashSet<Student> stuhs =new HashSet<>();
        stuhs.add(new Student("Freya",11215567,18));
        stuhs.add(new Student("lisa",11215577,18));
        stuhs.add(new Student("Tia",11215569,19));
        stuhs.add(new Student("Tia",11215569,19));
        System.out.println(stuhs);
        System.out.println("放自定义的类,可以有重复元素因为没重写hashcode && equals函数");

        Comparator<Student> c = new BiJiao();
        //匿名内部类
        Comparator<Student>  cc=new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        TreeSet<Student> stuts = new TreeSet<>(c);//指定比较器
        stuts.add(new Student("ac",1256554,12));
        stuts.add(new Student("bb",1125325,19));
        stuts.add(new Student("cd",1125335,24));
        stuts.add(new Student("ww",1125375,22));
        stuts.add(new Student("df",1125335,17));
        stuts.add(new Student("bd",1126435,14));
        stuts.add(new Student("bd",1124435,20));
        System.out.println(stuts);
        System.out.println(stuts.size());
        //
        Map<Student,Integer> mm=new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return ((Integer)(o1.getId())).compareTo((Integer)(o2.getId()));
            }
        });
        System.out.println("比较什么变量，则该变量不重复");
        mm.put(new Student("acia",1256554,12),1);
        mm.put(new Student("ali",1256534,19),2);
        System.out.println(mm.put(new Student("daecio", 1258154, 5), 3));
        System.out.println(mm.put(new Student("daecio", 1258154, 12), 4));
        for(Map.Entry<Student,Integer>  entry:mm.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());

        }
//        System.out.println(mm);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("D:\\Code\\Java_code\\Javabase\\democopy1.txt")));
        oos.writeObject(new Person("lazy",123456,18));
        oos.close();
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("D:\\Code\\Java_code\\Javabase\\democopy1.txt")));
        Person p1 = (Person)(ois.readObject());
        System.out.println("p1:"+p1);
        ois.close();
    }

}
class BiJiao implements Comparator<Student> {
    @Override //按名字
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}