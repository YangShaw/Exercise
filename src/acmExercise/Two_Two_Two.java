/**************************
 *                        *
 * Young Shaw             *
 * 2017年7月11日                	  *
 *                        *
 **************************/
package acmExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Two_Two_Two {
	 

	public static void main(String[] args) {
		
		class Work{
			int start;
			int end;
			public Work(int start,int end){
				this.start=start;
				this.end=end;
			}
		}
		
		class MyComparator implements Comparator {  
			   
		    //接口，必须实现的方法  
		    public int compare(Object o1, Object o2) {  
		        Work w1 = (Work) o1;  
		        Work w2 = (Work) o2;  
		        if (w1.end<w2.end)  
		            return -1;  
		        else if (w1.end > w2.end)  
		            return 1;  
		        else  
		            return 0;  
		    }  
		} 

		Scanner s=new Scanner(System.in);
		int start[]=new int[100000];
		int end[]=new int[100000];
		List<Work> workList=new ArrayList<Work>();
		int ans=0;
		int t=0;
		
		int n=s.nextInt();
		for(int i=0;i<n;i++){
			start[i]=s.nextInt();
		}
		for(int i=0;i<n;i++){
			end[i]=s.nextInt();
		}
		for(int i=0;i<n;i++){
			workList.add(new Work(start[i],end[i]));
		}
		MyComparator mc=new MyComparator();
		workList.sort(mc);
		
		for(int i=0;i<n;i++){
			System.out.println(i+" : "+"start at "+workList.get(i).start+
					" and end at "+workList.get(i).end);
		}
		
		for(int i=0;i<n;i++){
			if(t<workList.get(i).start){
				ans++;
				t=workList.get(i).end;
			}
		}
		System.out.println("The number of available works is "+ans);
	}

}
