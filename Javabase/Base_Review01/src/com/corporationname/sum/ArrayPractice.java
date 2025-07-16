package com.corporationname.sum;
import java.util.Arrays;
public class ArrayPractice {
    public static void delete(int[] arr,int index){
        for(int i=index;i+1<arr.length;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=0;
    }
    //可变参数
    public static void add(int...arr){
        System.out.println("可变参数和其他数据一起作为形参的时候，可变参数一定要放在最后");
        int sum=0;
        for(int n:arr){
            sum+=n;
        }
        System.out.println("总和为"+sum);
    }

    public static void main(String[] args) {
        System.out.println("args为"+Arrays.toString(args));//Arrays.toString(
        int[] arr2=new int[5];//默认初始化
        int[] arr3= new int[]{12,26,24,57,62};//静态初始化
        int[] arr4 = {12,23,45};
//        System.arraycopy(arr3,2,arr2,0,3);
//        System.out.println("arr2为"+Arrays.toString(arr2));
        //arr4[3]= 55;
        Arrays.sort(arr3);//binarySearch只能在排序后的数组里使用
//        System.out.println("\t24索引为"+Arrays.binarySearch(arr3,24));
        int[] a=Arrays.copyOf(arr4,2);
//        System.out.println("复制后的a值为"+Arrays.toString(a));
        Arrays.fill(arr2,34);//动态初始化
//        arr2[0]=111;//动态初始化
//        arr2[1]=111;//动态初始化
//        arr2[2]=111;//动态初始化
//        arr2[3]=111;//动态初始化
//        arr2[4]=111;//动态初始化
        delete(arr3,2);
        add(arr2);
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};

        System.out.println("比较结果："+Arrays.equals(a1, a2)); // true

//        System.out.println(Arrays.toString(arr3));
//        System.out.println(Arrays.toString(arr2));
        //增强for循环:
         /*
                增强for循环：
                优点：代码简单
                缺点：单纯的增强for循环不能涉及跟索引相关的操作
                */
        //对scores数组进行遍历，遍历出来每个元素都用int类型的num接收：
        int count = 0;
//        for(int num:arr3){
//            count++;
//            //每次都将num在控制台输出
//            System.out.println("第"+count+"个学生的成绩为："+num);
//        }
        int max=arr3[0];
        for(int i=0;i<arr3.length;i++){
            if(arr3[i]>max) {
                max = arr3[i];
            }
        }

        //二维数组
        int arr[][]=new int[3][];
        System.out.println(arr.length);
        int[] aa={2,4,7,45,96,25};
        arr[0]=aa;
        System.out.println("arr[0]:\t"+Arrays.toString(arr[0]));
        System.out.println("arr[1]:\t"+Arrays.toString(arr[1]));
//        System.out.println("arr[1][0]:\t"+arr[1][0]);
         int[][] ar2=new int[3][2];
        System.out.println("ar2[0][0]:\t"+ar2[0][0]);
        int[] b=new int[]{1,2,3,4,5};
        ar2[1]=b;//对ar2重新赋值
        System.out.println("ar2[1]:\t"+Arrays.toString(ar2[1]));
        int[][] ar22={{1,2,3,4,5},{1,2,5},{1,3,4,5}};
        int[][] ar222={{1,2,3,5},{1,2,3,4,5},{1,2,3,4,5}};
        for(int i=0;i<ar222.length;i++){
            for(int j=0;j<ar222[i].length;j++){
                System.out.print("ar222["+i+"]["+j+"]: "+ ar222[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("-=-=-=-==-=-==-=-=-==-===-=-=-=-===--=-=-=-=-=-=--=-=");

        for (int i=0;i<ar222.length;i++) {
            for(int num:ar222[i]){
                System.out.print(num+"\t");
            }
            System.out.println();
        }
        System.out.println("-=-=-=-==-=-==-=-=-==-===-=-=-=-===--=-=-=-=-=-=--=-=");

        for(int[] ar:ar222){
            for(int num:ar){
                System.out.print(num+"\t");
            }
            System.out.println();

        }
    }

}
