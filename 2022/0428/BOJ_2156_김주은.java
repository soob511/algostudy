package com.ssafy.add.d0428;

import java.util.Scanner;

public class Main_BJ_2156_포도주시식_김주은 {
	
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int[] dp = new int[N+1];
		if(N>=1) dp[1]=arr[1];
		if(N>=2) dp[2]=arr[1]+arr[2];
		
		for(int i=3;i<=N;i++) {
			int max = dp[i-1]; //현재 잔 선택x
			max = Math.max(max, dp[i-2]+arr[i]); //현재 잔 선택(연속 중 첫번째 잔)
			max = Math.max(max, dp[i-3]+arr[i-1]+arr[i]); //현재 잔 선택(연속 중 두번째 잔)
			
			dp[i]=max;
		}
		
		
		System.out.println(dp[N]);
	}
}
