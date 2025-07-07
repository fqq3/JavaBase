package myexceptions;
import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class Bank{
	Scanner in=new Scanner(System.in);
	private int  save;
	public Bank() {
		this.save=0;
	}
	public Bank(int a) {
		this.save=a;
	}
	public void saveMoney(){
		System.out.print("请输入存款金额：");
		int a=in.nextInt();
		this.save=this.save+a;
	}
	public void drawMoney(){
		System.out.print("请输入取款金额：");
		int b=in.nextInt();
		try {
            if (this.save < b) {
//            	System.out.println("无法取出");
            	throw new InsufficientFundsException("余额不足，无法完成取款操作。");
            }else {
            	this.save=this.save-b;
            	System.out.println("还剩"+this.save+"元");
            }
        } catch (InsufficientFundsException e) {
//            System.out.println(e.toString());//in.next(); // 清除非整数输入
        	System.out.println(e.getMessage());
        }
	}
	}
public class Store {
	
	public static void main(String[] args) {
		//Store store=new Store();
		Bank b1=new Bank();
		b1.saveMoney();
		b1.drawMoney();
		
	}

}
