package stack;

import java.util.Scanner;

public class Sort {
	public static void swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
	}
	
	public static void bubbleSort(int a[],int n){
		int i=0;
		for(i=n;n>0;n--){
			for(int j=0;j<i-1;j++){
				if(a[j]>a[j+1])
					swap(a[j],a[j+1]);
			}
		}
	}
	
	public static void printArray(int a[],int n){
		for(int i=0;i<n;i++)
			System.out.println(a[i]);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int array[]=new int[n];
		for(int i=0;i<n;i++)
			array[i]=s.nextInt();
		bubbleSort(array,n);
		printArray(array,n);

	}

}
