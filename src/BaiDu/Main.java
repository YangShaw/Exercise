/**************************
 *                        *
 * Young Shaw             *
 * 2017��8��6��                	  *
 *                        *
 **************************/
package BaiDu;

import java.util.Scanner;

public class Main {
	public static int a[];
	public static int b[];
	public static int k[];
	public static int p[];
	public static int record[][]=new int[1001][11];//��¼�Ѿ������������
	public static int count;//������
	public static final int INF=1000000000;
	
	public static int compute(int health, int defense){
		if(record[health][defense]==-1){
			int min=INF;
			int value=0;
			for(int i=0;i<k.length;i++){
				if(p[i]>defense){
					value=(health/(p[i]-defense))*k[i];
					int reminder=health%(p[i]-defense);
					if(reminder!=0){
						value=value+compute2(reminder,defense);
					}
					if(value<min){
						min=value;
					}
				}
				
			}
			
			if(min==INF){
				return -1;
			} else {
				record[health][defense]=min;
			}
		}
		
		return record[health][defense];
	}
	
	public static int compute2(int reminder, int defense){
		int min=INF;
		int value=0;
		for(int i=0;i<k.length;i++){
			if(p[i]>defense){
				value=(reminder/(p[i]-defense))*k[i];
				int reminder2=reminder%(p[i]-defense);
				if(reminder2!=0){
					value=value+k[i];
				}
				if(value<min){
					min=value;
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();//������
		int m=s.nextInt();//������
		a=new int[n];//����Ѫ��
		b=new int[n];//���޷���
		k=new int[m];//��������
		p=new int[m];//�����˺�
		
		
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
			b[i]=s.nextInt();
		}
		
		for(int i=0;i<m;i++){
			k[i]=s.nextInt();
			p[i]=s.nextInt();
		}
		
		for(int i=0;i<1001;i++){
			for(int j=0;j<11;j++){
				record[i][j]=-1;
			}
		}
		
		count=0;
		
		for(int i=0;i<n;i++){//ÿ���������μ�������
			int thisCount=compute(a[i],b[i]);
			if(thisCount==-1){
				System.out.println(-1);
				return;
			}
			else{
				count=count+thisCount;
			}
		}
		System.out.println(count);
	}
}
