package stack;

import java.util.Scanner;

public class TestStack {

	public static void main(String[] args) {
		MyStack st=new MyStack(50);
		st.push(17);
		st.push(20);
		st.push(78);
		st.push(46);
		st.print();
		st.pop();
		st.print();
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		for(int i=0;i<a;i++){
			System.out.println(i);
			System.out.println("hhh");
		}
		while(a<10){
			System.out.println(2*a);
			a++;
		}
		
	}

}
