/**************************
 *                        *
 * Young Shaw             *
 * 2017��7��13��                	  *
 *                        *
 **************************/
package acmExercise;

import java.util.*;


public class Two_Two_Four {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int r=s.nextInt();
		List<Integer> x=new ArrayList<Integer>();
		int ans=0;
		
		for(int i=0;i<n;i++){
			x.add(s.nextInt());
		}
		x.sort(null);	//	sortҲ����ʹ��null������Ĭ�����򷽷�

		int i=0;
		while(i<n){
			int cur=x.get(i);
			i++;
			
			while(i<n&&x.get(i)<=cur+r)
				i++;
			int point=x.get(i-1);
			System.out.println(point);
			
			while(i<n&&x.get(i)<=point+r)
				i++;
			
			ans++;
		}
		System.out.println(ans);
	}

}
