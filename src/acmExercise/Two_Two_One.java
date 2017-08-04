/**************************
 *                        *
 * Young Shaw             *
 * 2017Äê7ÔÂ11ÈÕ                	  *
 *                        *
 **************************/
package acmExercise;

import java.util.Scanner;

public class Two_Two_One {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		
		final int coin[]= {1, 5, 10, 50, 100, 500};
		int coinNum[]=new int[6];
		int result[]=new int[6];
		int money=0;
		int ans=0;
		
		for(int i=0;i<6;i++){
			coinNum[i]=s.nextInt();
		}
		
		money=s.nextInt();
		
		for(int i=5;i>=0;i--){
			if(money/coin[i]<=coinNum[i]){
				result[i]=money/coin[i];
			} else {
				result[i]=coinNum[i];
			}
			money=money-coin[i]*result[i];
			ans=ans+result[i];
		}
		
		for(int i=0;i<6;i++){
			System.out.println(coin[i]+" : need "+result[i]+" ;");
		}
		
		System.out.println("All is "+ans);
	}
}
