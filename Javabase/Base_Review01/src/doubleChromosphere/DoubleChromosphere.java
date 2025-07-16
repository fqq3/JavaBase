package doubleChromosphere;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DoubleChromosphere {
    public static int[] getLuckyBall(){
        int[] lucky=new int[7];
        for(int i=0;i<7;i++){
            if(i != 7){
            lucky[i]=new Random().nextInt(33)+1;
            }else{
                lucky[i]=(int)(Math.random()*16+1);
            }
        }
        return lucky;
    }
    public static int getLevel(int[] balls,int[] luckyBall){
        int level=0;
        int red=0;
        int bule=0;
        for(int i=0;i<7;i++){
            if(i!= 6){
                for (int j=0;j<6;j++) {
                    if(balls[i]==luckyBall[j]){
                        red++;
                    }
                }
            }else{

                if(balls[i]==luckyBall[6]){
                    bule++;
                }
            }
        }
        if(red==6 && bule==1){
            level=1;
        }else if(red==5 && bule==1){
            level=2;
        }else if(red==5 && bule==1){
            level=3;
        }else if((red==5 && bule==0)||(red==4 && bule==1)){
            level=4;
        }else if((red==4 && bule==0)|| (red==3 && bule==1)){
            level=5;
        }else if(red<3 && bule==1){
            level=6;
        }else{
            level=7;
        }
        return level;
    }
    public static void main(String[] args) {
        int[] ball=new int[7];
//        Arrays.toString();
        while(true) {
            System.out.println("----欢迎使用双色球彩票系统-----");
            System.out.println("1.购买彩票");
            System.out.println("2.查看开奖");
            System.out.println("3.退出");
            Scanner sc=new Scanner(System.in);
            int selection=sc.nextInt();
            int count=0;
            switch(selection) {
                case 1:
                    System.out.println("正在购买彩票");
                    System.out.println("请输入你要买几注彩票");
                    count=sc.nextInt();

                    for(int i=0;i<7;i++){
                       if(i!=7){
                           System.out.println("请录入第"+i+"个红球");
                           ball[i]=sc.nextInt();

                       }else{
                           System.out.println("请录入第"+i+"个蓝球");
                           ball[i]=sc.nextInt();
                       }
                    }
                    System.out.println("您一共购买了"+count+"注，共花费"+count*2+"元，您的号码是：");
                    for(int bal:ball){
                        System.out.print(bal+" ");
                    }
                    System.out.println();

                    break;
                case 2:
                    System.out.println("查看开奖");
                    int[] luckyBall = getLuckyBall();
                    System.out.println("中奖号码为"+ Arrays.toString(luckyBall));
                    int level= getLevel(ball,luckyBall);
                    switch(level){
                        case 1:
                            System.out.println("恭喜你中了一等奖，每注中奖金额为100万元，您的奖金共有"+ count *100+"万元");
                            break;
                        case 2:
                            System.out.println("恭喜你中了二等奖，每注中奖金额为30万元，您的奖金共有"+ count *30+"万元");
                            break;
                        case 3:
                            System.out.println("恭喜你中了三等奖，每注中奖金额为10万元，您的奖金共有"+ count *10+"万元");
                            break;
                        case 4:
                            System.out.println("恭喜你中了四等奖，每注中奖金额为2万元，您的奖金共有"+ count *2+"万元");
                            break;
                        case 5:
                            System.out.println("恭喜你中了五等奖，每注中奖金额为3000元，您的奖金共有"+ count *3000+"元");
                            break;
                        case 6:
                            System.out.println("恭喜你中了六等奖，每注中奖金额为5元，您的奖金共有"+ count *5+"元");
                            break;
                        case 7:
                            System.out.println("您为福彩事业做出了巨大的贡献");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("退出");
                    return ;
            }
        }

    }
}
