package com.ssafy.algostudy;

import java.util.Scanner;

public class BOJ_11729_정승우 {


	static int cnt=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new  Scanner(System.in);
		int n = sc.nextInt();
		hanoi(n,1,2,3);
		System.out.println(cnt);
		System.out.println(sb);
		
	}	
	
		
		public static void hanoi(int n, int from, int temp, int to) { //n :탑의 수, from:탑 출발지, temp :경유지, to:도착지
			
			cnt++; // 옮긴 횟수를 출력
			
			//n값이 1일때 
			if (n==1) { 
				sb.append(from+" "+to+"\n"); //값을 StringBuilder에 저장한 후 한번에 출력
				return;
			}
			
			else {
				hanoi (n-1, from, to, temp); // 매개변수 값을 변경하며 재귀를 통해 값을 구함
				
				sb.append(from+" "+to+"\n");
				
				hanoi(n-1,temp,from,to); // 매개변수 값을 변경하며 재귀를 통해 값을 구함
				
			}
			
		}
		
	

}
