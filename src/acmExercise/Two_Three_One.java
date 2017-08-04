/**************************
 *                        *
 * Young Shaw             *
 * 2017年7月29日                	  *
 *                        *
 **************************/
package acmExercise;

import java.util.Map;
import java.util.Scanner;

public class Two_Three_One {
	static class Pac{
		int w;
		int v;
		Pac(int w,int v){
			this.w=w;
			this.v=v;
		}
	}

	static int n,W;
	static Pac pac[];
	static int dp[][];
	@SuppressWarnings("resource")
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		pac=new Pac[n];
		dp=new int[n][n];
		//ddd
		for(int i=0;i<n;i++){
			pac[i]=new Pac(s.nextInt(),s.nextInt());
		}
		W=s.nextInt();
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dp[i][j]=-1;
			}
		}
		
		System.out.println(rec(0,W));
		
		
	}
	static int rec(int i, int j){
		if(dp[i][j]>=0){
			return dp[i][j];
		}
		int res;
		if(i==n-1){
			res=0;
		} else if(j<pac[j].w){
			res=rec(i+1,j);
		} else {
			res=(rec(i+1,j) >= rec(i+1,j-pac[j].w)+pac[j].v ? rec(i+1,j) : rec(i+1,j-pac[j].w)+pac[j].v);
		}
		
		return res;
	}
	
	

}
