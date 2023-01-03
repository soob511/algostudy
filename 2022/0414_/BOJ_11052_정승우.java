package com.ssafy.day0414;

import java.util.Scanner;


public class BOJ_11052_정승우 {

	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		//카드 n개일때 최대값 구하는 배열
		int dp [] = new int[N+1];
		//카드 배열
		int c [] = new int[N+1];
		for(int i =1 ; i < N+1 ;i++) {
			c[i] =sc.nextInt();
		}
		for(int i =1 ; i < N+1;i++) {
			for(int j=1 ; j<=i;j++) {
				dp[i] = Math.max(dp[i],c[j]+dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}