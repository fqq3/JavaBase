package com.corporationname.techname;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int answer = rand.nextInt(500) + 1;
        Scanner sc = new Scanner(System.in);
        System.out.println(answer);

        try {
            while (true) {
                //System.out.println("While 里的 answer:"+answer);
                //System.out.println("请输入你猜测的数字");
                //检查无效输入
                if (!sc.hasNextInt()) {
                    System.out.println("无效输入！请重新输入一个整数！");
                    sc.next(); // 清除无效输入
                    continue;
                }
                int guess = sc.nextInt();
                System.out.println("While 里的 guess:"+guess);

                if (answer == guess) {
                    System.out.println("You are right! Congratulations!");
                    break;
                } else if ( guess< answer) {
                    System.out.println("It's smaller than the answer!");
                   // System.out.println("While 里<的 guess:"+guess);

                } else {
                    System.out.println("It's bigger than the answer!");
                   // System.out.println("While 里>的 guess:"+guess);

                }
            }
        } finally {
            sc.close();
        }
        sc.close();
    }
}
