/**************************
 *                        *
 * Young Shaw             *
 * 2017年7月12日                	  *
 *                        *
 **************************/
package acmExercise;

import java.util.Scanner;

public class Two_Two_Three {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		s.nextLine();
		String ori=s.nextLine();
		char oriArr[]=ori.toCharArray();
		char dstArr[]=new char[n];
		
		int a=0;
		int b=n-1;
		int count=0;
		while(a<=b){
			boolean isLeft=false;
			for(int i=0;a+i<b;i++){
				if(oriArr[a+i]<oriArr[b-i]){
					isLeft=true;
					break;
				} else if(oriArr[a+i]>oriArr[b-i]){
					break;
				} 
			}
			if(isLeft){
				dstArr[count]=oriArr[a];
				a++;
			} else {
				dstArr[count]=oriArr[b];
				b--;
			}
			count++;
		}
		for(int i=0;i<n;i++){
			System.out.print(dstArr[i]);
		}
		System.out.println();
	}

}
