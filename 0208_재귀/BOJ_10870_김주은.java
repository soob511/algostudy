package com.ssafy.add.d0208;

import java.util.Scanner;

public class boj_10870_피보나치수5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibonacci(N));
	}
	
	public static int fibonacci(int N) {
		
		if(N==0) return 0;
		if(N==1) return 1;
		
		
		return fibonacci(N-1)+fibonacci(N-2);
		
	}

}
