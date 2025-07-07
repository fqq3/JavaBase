import java.util.Scanner;
public class Judgeorder {
	private static final boolean I=true;
	private static final boolean O=false;
	
	static class Zhan {
	    int num; // 成员变量
	    boolean state; // 成员变量
	}
	static boolean check(int k,int n,Zhan[] ain) {
	    boolean result=O;//默认在外面
        for(int i=k+1;i<n;i++) {//  注意不要检查自己啊！！！
        	if(ain[i].state==I) {//后进的有一个在里面
        		result=I;
        		break;
        	}		   
       }
        return result;//检查结果为出不来
    }
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();//进栈的数量
		int h=0;//要出栈的数字
		int k=0;//出栈数字的序号
		boolean can=true;//能按序列出来吗
		Zhan[] arrIN=new Zhan[n];//创建进栈序列
		int[] arrOUT= new int[n];//创建出栈序列
		for(int i=0;i<n;i++) {//初始化进站序列
			arrIN[i] = new Zhan();///////////
			arrIN[i].num=i+1;
			arrIN[i].state=O;//都在外面，没入栈
		}
		for(int i=0;i<n;i++) {//初始化出栈序列
			arrOUT[i]=in.nextInt();
		}
		in.close();	
		for(int i=0;k<n;) {//遍历
			if(i<n-1) arrIN[i].state=I;//模拟进栈
			if(arrOUT[k]==arrIN[i].num) {//进栈和出栈元素相等
				h=arrIN[i].num;
				
				arrIN[arrOUT[k]-1].state=O;//继续出栈
				k++;
				
				if(i<n-1) {i++;}//继续进栈
				
				
			}else if(arrOUT[k]>arrIN[i].num){//出大于进
				if(i<n-1) {i++;}//进栈 只进不出
				continue;
			}
			else{//出小于进 13 24
				h=arrOUT[k];//h=4 h=3<4 2<3
				if(check(h-1,n,arrIN)){//判断能否出去n=4//有一个在里面，不能出来
					can=false;//出不去
					break;//
				}else {
					arrIN[arrOUT[k]-1].state=O;//
					k++;//出去
					
				}
				
			}
			
		}
		if(can) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}

