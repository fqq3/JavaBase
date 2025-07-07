package com.corporationname.techname;

public class BuyChickens {
    /**百钱买百鸡：
公鸡5文钱一只，母鸡3文钱一只，小鸡3只一文钱，
用100文钱买一百只鸡,其中公鸡，母鸡，小鸡都必须要有，问公鸡，母鸡，小鸡要买多少只刚好凑足100文钱。
*/
    //java函数传递的是值
    public static int add(int num1,int num2){
        return num1+num2;
    }

    //定义一个方法：三个数相加：
    public static int add(int num1,int num2,int num3){
        return num1+num2+num3;
    }

    //定义一个方法：四个数相加：
    public static int add(int num1,int num2,int num3,int num4){
        return num1+num2+num3+num4;
    }
    public static void main(String[] args){
    for(int x=1;x<20;x++){
        for(int y=1;y<33;y++){
            for(int z=3;z<100;z+=3){
                if(5*x+3*y+z/3==100 && x+y+z==100){
                    System.out.println("公鸡"+x+"只，母鸡"+y+"只，小鸡"+z+"只\n");
                }
            }
        }
    }
    }
}
