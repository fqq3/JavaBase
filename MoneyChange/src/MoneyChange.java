import java.util.Scanner;

public class MoneyChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);//创建一个叫cin的Scanner对象
		//System.out.print("Enter a number: ");
		int money = cin.nextInt();
		cin.close();
		int num[] = new int[4];
		num[0] = money/10;
		money = money%10;
		num[1]= money/5;
		money = money%5;
		num[2]= money/2;
		money = money%2;
		num[3]= money;
		System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]);
	}

}
