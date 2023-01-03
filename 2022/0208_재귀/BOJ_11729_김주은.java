package com.ssafy.add.d0208;

import java.util.Scanner;

public class boj_11729_하노이탑이동순서 {
	
	static int cnt=0;
	static StringBuilder sb;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		hanoi(N, 1, 2, 3);

		System.out.println(cnt + "\n" + sb.toString());
	}
	
	// from에서 to로 5개의 원판을 옮김
	public static void hanoi(int N, int from, int step, int to) {
		
		if(N==0) return;
		
		hanoi(N-1,from,to,step);
		
		sb.append(from+" "+to+"\n");
		++cnt;
		
		hanoi(N-1,step,from,to);
	}

}
