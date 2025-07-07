package MyRectangle;
//import java.util.Arrays;
public class MyRectangle {
	protected int width;
	protected int length;
	protected int area;
	//构造方法
	public MyRectangle(){
		this.width=0;
		this.length=0;
		this.area=0;
	}
	public MyRectangle(int w,int l){
		this.width=w;
		this.length=l;
		this.area=w*l;
	}
	
	//方法
	public void setWidth(int w) {
		this.width=w;
		this.area=w*this.length;
	}	
	public void setlLength(int length) {
		this.length=length;
		this.area=this.width*length;
	}	
	
	public int getWidth(){
		return this.width;
	}
	public int getLength(){
		return this.length;
	}
	public int getArea(){
		return this.area;
	}
	public String toString() {
		String s="矩形的宽度："+this.width+"\n"+"长度："+this.length+"\n"+"面积："+this.area;
		return s;
	}
}
