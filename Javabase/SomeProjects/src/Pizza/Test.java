package Pizza;

import java.util.Scanner;

/**
 * @author: fqq
 * @Date: 2025/5/17 - 05 - 17 - 23:25
 * @Description: Pisa
 * @version: 1.0
 */

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("侵犯选择想要制作的披萨：1.培根披萨 2.水果披萨");
        int choice=sc.nextInt();
        Pizza p=PizzaStore.getPizza(choice);//工厂模型
        System.out.println(p.show());
    }
}
