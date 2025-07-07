package MyStudent;//import java.util.Scanner;
public class StudentTest {
	static void display(Student st) {//Scanner in=new Scanner(System.in);
		System.out.printf("%s",st.toString());
	}
	public static Student older(Student s1,Student s2) {
		int b1[]=s1.getBirthday();
		int b2[]=s2.getBirthday();
		for(int i=0;i<3;i++) {
			if(b1[i]>b2[i]) {
				return s2;
				//break;
			}else if(b1[i]<b2[i]){
				return s1;//st1.birthday[i]>st2.birthday[i]
			}
		}
		return s1;
	}
	public static void main(String[]args) {
		//创建两个Student类的对象
		Student st1=new Student(113,1,"li","man",new int[]{2003,2,15});
		Student st2=new Student(114,2,"wang","woman",new int[]{2004,6,8});
		//输出对象的所有域信息
		display(st1);
		display(st2);
		//修改对象的姓名并输出
		st1.setName("libai");
		st2.setName("wangwei");
		System.out.println(st1.getName());
		System.out.println(st2.getName());
		//比较两个对象的年龄大小，输出年龄较大的对象。
		Student sstt=older(st1,st2);
		System.out.println(sstt.toString());
	}
}
