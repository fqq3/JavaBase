package MyPackage;
//import java.util.Scanner;
public class Time {
	private int hour;
	private int minute;
	private int sec;
	static int count=0;//对产生的时钟类对象进行计数
	public Time(){//构造方法1
		this.hour=0;
		this.minute=0;
		this.sec=0;
		Time.count++;
	}
	public Time(int h,int m,int s){//构造方法2
		this.hour=h;
		this.minute=m;
		this.sec=s;
		Time.count++;
	}
	public Time(int s){//构造方法3
		this(0,0,s);
		Time.count++;
	}
	public Time(int m,int s){//构造方法4
		this(0,m,s);
		Time.count++;
	}
	public void setHour(int h) {
		this.hour =h;
	}
	public void setMinute(int m) {
		this.minute =m;
	}
	public void setSec(int s) {
		this.sec=s;
	}
	public int getHour() {
		return this.hour;
	}
	public int getMinute() {
		return this.minute ;
	}
	public int getSec() {
		return this.sec;
	}
	//public static void main(String[] args) {//public static void main(String[] args){}
		
	//Scanner in=new Scanner(System.in);
	//}	
}
