package MyRectangle;
//import  MyRectangle.MyRectangle;
public class MySquare extends MyRectangle {	
	public MySquare() {
		super();
	}
	public MySquare(int w){
		super(w,w);
	}
	public int getArea(){
		return super.area;
	}
	public String toString() {
		String s="方形的边长："+this.width+"\n"+"面积："+this.area;
		return s;
	}
	
}
