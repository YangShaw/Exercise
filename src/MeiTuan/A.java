/**************************
 *                        *
 * Young Shaw             *
 * 2017Äê6ÔÂ15ÈÕ                	  *
 *                        *
 **************************/
package MeiTuan;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int ns[]=new int[n];
		for(int i=0;i<n;i++){
			ns[i]=s.nextInt();
		}
		
		int m=s.nextInt();
		int ms[]=new int[m];
		for(int i=0;i<m;i++){
			ms[i]=s.nextInt();
		}
		
		int min=0;
		int sum=0;
		for(int i=0;i<n;i++){
			sum=sum+(ns[i]-ms[i])*(ns[i]-ms[i]);
		}
		min=sum;
		
		for(int i=1;i<=m-n;i++){
			sum=0;
			for(int j=0;j<n;j++){
				int k=i+j;
				sum=sum+(ns[j]-ms[k])*(ns[j]-ms[k]);
			}
			if(sum==0){
				min=sum;
				break;
			}
			
			if(sum<min){
				min=sum;
			}
		}
		System.out.println(min);

	}

}
