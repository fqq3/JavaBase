import java.util.Scanner;

public class TraingleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);//创建一个叫cin的Scanner对象
		//System.out.print("Enter a number: ");
		int num1 = cin.nextInt();
		int num2 = cin.nextInt();
		int num3 = cin.nextInt();
		cin.close();
		double s=(num1+num2+num3)/2.0;
		double area=Math.sqrt(s*(s-num1)*(s-num2)*(s-num3));
		//System.out.println("You entered: " + num1+" "+num2+" "+num3);
		System.out.println(String.format("%.3f", area));
	
	}

}
