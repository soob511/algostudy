package recur;

import java.util.Scanner;

public class Main_11729 {

	static int count=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		hanoi(n,1,3,2);
		System.out.println(count);
		System.out.println(sb.toString());
		

	}
	public static void hanoi(int n,int start,int end,int mid) {
		
		
		if(n==1) {
			sb.append(start+" "+end+"\n");
			count++;
			return;
		}
		
		//n-1 원판이동
		hanoi(n-1,start,mid,end);
		//n원판이동
		hanoi(1,start,end,mid);
		//n-1ㅇㅣ동
		hanoi(n-1,mid,end,start);
	}
}
