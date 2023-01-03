package com.ssafy.day0407;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_정승우 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//n 자리수일때 이친수의 수
		long[] dp = new long[n+1];
		
		dp[1] = 1;
		if (n>1) dp[2]=1;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
