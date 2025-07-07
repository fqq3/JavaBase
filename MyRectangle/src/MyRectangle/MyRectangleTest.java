package MyRectangle;
//import java.util.Scanner;

public class MyRectangleTest {
	
	static void displayF(MyRectangle mrt) {//Scanner in=new Scanner(System.in);
		System.out.printf("%s\n",mrt.toString());
	}
	static void displayS(MySquare ms) {//Scanner in=new Scanner(System.in);
		System.out.printf("%s\n",ms.toString());
	}
	public static void main(String[]args) {
		MyRectangle mrt=new MyRectangle(12,5);
		MySquare ms=new MySquare(12);
		displayF(mrt);
		displayS(ms);
		mrt.setlLength(8);
		displayF(mrt);
		MySquare mss=new MySquare(5);
		
		System.out.println(mss.getArea());
	
	}
}
