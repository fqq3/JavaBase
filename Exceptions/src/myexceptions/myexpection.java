package myexceptions;
import java.util.InputMismatchException;
import java.util.Scanner;
public class myexpection {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1,x2,x3;
		x1=get();
		x2=get();
		x3=x1+x2;
		System.out.println("两个整数的和为：" + x3);
	}
	private static int get() {
		Scanner in=new Scanner(System.in);
		while (true) {
            try {
            	System.out.println("请输入一个整数：");
                return in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("输入有误，请重新输入整数：");
                in.next(); // 清除非整数输入
            }
		
		}
	}

}
