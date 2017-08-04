package stack;

import java.util.Arrays;
import java.util.Scanner;

public class TestBS {
	
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int target=s.nextInt();
		int n=s.nextInt();
		int[]aa=new int[n];
		for(int i=0;i<n;i++){
			int a=s.nextInt();
			aa[i]=a;
		}
		Arrays.sort(aa);
		int start=0;
		int end=n-1;
		int count=0;
		int mid=0;
		boolean found=false;
		while(start<=end){
			mid=(start+end)/2;
			if(aa[mid]<=target){
				
			}
		}
		System.out.println(mid);
	}

}
