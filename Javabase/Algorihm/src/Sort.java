/**
 @author fqq
 @version 1.0
 @date 2020/05/05
 @description 排序算法 选择、冒泡、插入
 */

public class Sort {
    //一句话概括: 选择排序 i++~n-1
    //在i~n-1中选出最小的放在i位置上,然后i+1~n-1范围上继续.
    /**
     @param arr 待排序数组
     */
    public static void selectionSort(int [] arr){

        if(arr == null || arr.length <2 ){  //null数组，其 length 属性会导致 NullPointerException。
            return;
        }
        int min=0;//最小值索引
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){//选出最小
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    //一句话概括: 冒泡排序 i~n--
    //0~i范围上,相邻位置选出较大数,最大值最终来到i位置,然后0~i-1范围上继续
    public static void bubbleSort(int [] arr ){
        if(arr ==null || arr.length<2 ){
            return;
        }
        for(int end=arr.length-1;end>0;end--){//length-1~1
            for(int j=0;j<end;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    //插入排序一句话,0~i-1范围上已经有序,新来的数从右往左滑倒不再小的位置插入,然后继续
    public static void insertSort (int [] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j+1]<arr[j]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }
}
