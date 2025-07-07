import java.util.Scanner;
public class Rubikscube {
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();//边长
		in.close();
		int num=1;
		int[][] a=new int [n][n];
		//int[][] b=new int [n][n];
		int x = 0,y = 0;
		a[0][0] = 1;
		while(num<n*n) {
			 while(y+1<=n-1 && a[x][y+1]== 0) a[x][++y] = ++num;
		     while(x+1<=n-1 && a[x+1][y]== 0) a[++x][y] = ++num;
		     while(y-1>=0 && a[x][y-1]== 0) a[x][--y] = ++num;
		     while(x-1>=0 && a[x-1][y]== 0) a[--x][y] = ++num;
	
		}
		 for(int i = 0;i<n;i++)
		    {
		        for(int j = 0;j<n;j++)
		        {
		        	//b[i][j]=a[i][j]//
		        	System.out.printf("%5d",a[i][j]);
		        }
		        System.out.println();
		    }
		
	}
}