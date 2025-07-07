package junittest;

import comnclass.Gender;

/**
 * @Auther: fqq
 * @Date: 2025/5/14 - 05 - 14 - 17:00
 * @Description: junittest
 * @version: 1.0
 */
@MyAnnotation(value={"aaa","bbbb"},age={1,12})
public class PersonAPI {
    private int age;
    private String name;
    private Gender sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {

        return "PersonAPI{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    /**
    eat(),
    @param:num1 就餐人数；
    @param :num2 点的菜数
    */
    public void eat(int p,int d){
        System.out.println("正在吃第"+p+"道菜，总共有"+d+"道菜");
        //see的意思是另请参阅
    }
    /**
    @param:age 年龄
    @return int
    @exception RuntimeException
    @exception IndexOutOfBoundsException
    @See Student
    */
    //允许的注解成员类型：
    //基本数据类型：int, long, float, double, boolean, byte, short, char
    //String//Class 类型//enum 类型
    //int[], String[], Class<?>[]
    public int sleep(int age){
        new StudentAPI();
        if(age>100){
            throw new RuntimeException();
        }
        if(age<0){
            throw new IndexOutOfBoundsException();
        }
        return 10;
    }
}
