package Pizza;

import java.util.Scanner;

/**
 * @author: fqq
 * @Date: 2025/5/18 - 05 - 18 - 0:02
 * @Description: Pizza
 * @version: 1.0
 */
public class PizzaStore {
    public static Pizza getPizza(int choice)
    {
        Scanner sc=new Scanner(System.in);
        Pizza p=null;
        switch(choice){
            case 1:{
                System.out.println("请输入培根克数：");
                int weight=sc.nextInt();
                System.out.println("请输入披萨大小：");
                int size=sc.nextInt();
                System.out.println("请输入披萨价格：");
                int price=sc.nextInt();
                BaconPizza  bp=new BaconPizza("培根披萨",weight,size,price);
//                System.out.println(bp.show());
                p=bp;
                break;
            }
            case 2:{
                System.out.println("请输入你想加入的水果：");
                String burdening=sc.next();
                System.out.println("请输入披萨的大小：");
                int size=sc.nextInt();
                System.out.println("请输入披萨的价格：");
                int price=sc.nextInt();
                FruitPizza fp=new FruitPizza("水果披萨",burdening,size,price);
//                System.out.println(fp.show());
                p=fp;
            }
            break;
        }
        return p;
    }

}
