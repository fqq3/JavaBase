package classpractice;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/17 - 04 - 17 - 21:46
 * @Description: classpractice
 * @version: 1.0
 */
public class Person implements Comparable<Person>,Serializable {//implements Comparable<Person>

    private static final long serialVersionUID = 11111L;
    private int id;
    private int age;//成员变量，类中方法外
    private String name;
    private double height;
    private double weight;
//    private String school;
    public Person(){

    }
    public  Person(String name,int id, int age){
        this.setName(name);
        this.setId(id);
        this.setAge(age);
    }
    public void eat(){
        System.out.println("在吃饭");
    }
    public void sleep(String s){
        System.out.println("我在"+s+"睡觉");

    }
    protected void introductions(){
        System.out.println("我叫"+name+"今年"+age+"岁，身高"+height+"体重"+weight);
    }
    public void setId(int id) {
        this.id = id;
        System.out.println("id设置为"+this.id);
    }
    public void setAge(int n){
        this.age=n;
        System.out.println("年龄设置为"+this.age);
    }
    public void setHeight(double height) {
        this.height = height;
        System.out.println("身高设置为"+this.height);
    }
    public void setName(String name) {
        this.name = name;
        System.out.println("姓名设置为"+this.name);
    }
    public void setWeight(double weight) {
        this.weight = weight;
        System.out.println("体重设置为"+this.weight);
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
    public String toString(){
        return this.getName()+"是一个学生,"+"今年"+this.getAge()+"岁,"+"身份证号码是："+this.getId()
                +"身高是"+this.getHeight()+"体重是"+this.getWeight();
    }
    public void talk(Person p){
        p.introductions();
        System.out.println("我是"+this.getName()+"和"+p.getName()+"聊天很开心");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return id == person.id && age == person.age && Double.compare(height, person.height) == 0 && Double.compare(weight, person.weight) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, height, weight);
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }

}
