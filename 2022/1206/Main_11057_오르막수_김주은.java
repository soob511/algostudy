package com.bj;

import java.util.Scanner;

public class Main_BJ_11057_오르막수_김주은 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[][] dp = new long[N+1][10];
		
		dp[0][9] = 1;
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<10;j++) {
				long sum = 0;
				for(int l=j;l<10;l++) {
					sum +=dp[i-1][l];
					
				}
				sum%=10007;
				dp[i][j]=sum;
			}
		}
		
		long ans = 0;
		for(int i=0;i<10;i++) {
			ans+=dp[N][i];
		}
		
		System.out.println(ans%10007);
		
	}

}
