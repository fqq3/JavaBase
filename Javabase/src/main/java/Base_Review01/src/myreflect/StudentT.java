package myreflect;

import test.java.junittest.MyAnnotation;

/**
 * @author: fqq
 * @Date: 2025/5/15 - 05 - 15 - 19:17
 * @Description: myreflect
 * @version: 1.0
 */
@MyAnno(value="stut")
public class StudentT extends PersonT implements TestInt{
    private int sno;
    double height;//认的包作用域
    protected double weight;
    public double score;

    @MyAnno("lilili")
    public String showInfo(){
        return "我是学生";
    }
    public String showInfo(int a,int b){
        return "重载show-Info";
    }
    public void work(int a){
        System.out.println("我以后要成为一名程序员");
    }
    void happy(){
        System.out.println("我很开心！！！1");
    }
    protected int getSno(){
        return sno;
    }
    //构造器
    public StudentT(){
        System.out.println("空参构造器");
    }
    private StudentT(int sno){
        this.sno=sno;
    }
    StudentT(int sno,double weight){
        this.sno=sno;
        this.weight=weight;
    }
    protected StudentT (int sno,double weight,double height){
        this.sno=sno;
        this.weight=weight;
    }

    @Override
    @MyAnnotation(value="hihihiihi")
    public void any() {
        System.out.println("重写实现了any()方法");
    }
    @Override
    public String toString(){
        return "StudentT{" +
                "sno=" + sno +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }
}
