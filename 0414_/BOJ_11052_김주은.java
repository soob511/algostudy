package com.ssafy.add.d0414;

import java.util.*;

public class Main_BJ_11052_카드구매하기_김주은 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=i;j<=N;j++) {
				dp[j] = Math.max(dp[j], dp[j-i]+arr[i]);
			}
		}
		
		System.out.println(dp[N]);
		sc.close();
	}

}
