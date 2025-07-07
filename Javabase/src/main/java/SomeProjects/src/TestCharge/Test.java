package TestCharge;

import java.util.Scanner;

/**
 * @author: fqq
 * @Date: 2025/5/17 - 05 - 17 - 21:41
 * @Description: TestCharge
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String details="";
        int balance=0;//余额
        while(true) {
            System.out.println("--------欢迎使用小鲨鱼记账系统--------");
            System.out.println("1.收支明细");
            System.out.println("2.登记收入");
            System.out.println("3.登记支出");
            System.out.println("4.退出");
            System.out.println("请输入你要选择的功能：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice!=1 && choice!=2 && choice!=3 && choice!=4){
                System.out.println("对不起，输入错误，请重新输入:");
                choice=sc.nextInt();

            }
            switch (choice) {
                case 1:
                    System.out.println("已进入收支明细");
                    System.out.print("---------当前收支明细记录---------");
                    if(details!="") {
                        details = details.substring(0, details.length() - 1);
                    }
                    System.out.println(details);
                    break;
                case 2:
                    System.out.println("已进入登记收入");
                    System.out.println("请输入收入金额：");
                    int money = sc.nextInt();
                    balance+=money;
                    System.out.println("请录入收入说明：");
                    String income = sc.next();
                    details+="\n收入:"+money+"元\t"+"收入说明："+income+"\n余额："+balance+"元\n";
                    break;
                case 3:
                    System.out.println("已进入登记支出");
                    System.out.println("请输入支出金额：");
                    int spend=sc.nextInt();
                    balance-=spend;
                    System.out.println("请录入支出说明");
                    String outcome=sc.next();
                    details+="\n支出:"+spend+"元\t"+"支出说明："+outcome+"\n余额："+balance+"元\n";
                    break;
                case 4:
                    System.out.println("已进入退出阶段");
                    System.out.println("确定要退出吗？");
                    String isExit=sc.next();
                    switch(isExit){
                        case "Y":
                            System.out.println("欢迎下次使用");
                            return;
                    }


            }
        }

    }
}
