package MyStudent;//Student类创建在myStudent包中
import java.util.Arrays;
//创建一个Student类，包括的属性有学号、班级、姓名、性别、出生年月等，且都是private类型
public class Student {
	private int num;
	private int clas;
	private String name;
	private String gender;
	private int[] birthday;
	private static int count;//统计班级人数的私有域count
	///声明三个构造函数，初始化对象的所有域
	public Student(){
		this.num=0;
		this.clas=0;
		this.name=null;
		this.gender=null;
		this.birthday=null;
		Student.count++;
	}
	public Student(int nu,int cla,String nam,String gen,int[] bir){
		this.num=nu;
		this.clas=cla;
		this.name=nam;
		this.gender=gen;
		this.birthday=bir;
		Student.count++;
	}
	public Student(int nu,String nam){
		this(nu,0,nam,null,null);
		Student.count++;

	}
	//声明分别获得与修改各属性的public方法（set、get方法
	public void setNum(int nu) {
		this.num=nu;
	}
	public void setClas(int cla) {
		this.clas=cla;
	}
	public void setName(String nam) {
		this.name=nam;
	}
	public void setGender(String Gend) {
		this.gender=Gend;
	}
	public void setBirthday(int[] bir) {
		this.birthday=bir;
	}
	public int  getNum() {
		return this.num;
	}
	public int  getClas() {
		return this.clas;
	}
	public String  getName() {
		return this.name;
	}
	public String  getGender() {
		return this.gender;
	}
	public int[]  getBirthday() {
		return this.birthday;
	}
	//声明toString（）方法，把该类的所有域信息组合成一个字符串。
	public String toString() {
		String s;
		String s1=String.valueOf(this.num);
		String s2=String.valueOf(this.clas);
		s="Student:"+"\n"+"num："+s1+"\n"+"clas:"+s2+"\n"+"name:"+this.name+"\n"+"gender:"+this.gender+"\n"+"birthday"+Arrays.toString(birthday)+"\n";
		return s;
	}
	//班级总人数的public方法
	public int sum() {
		return Student.count;
	}
}
