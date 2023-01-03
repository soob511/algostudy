package com.ssafy.add.d0407;

import java.io.*;
import java.util.*;

public class Main_BJ_2193_이친수_김주은 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[] dp = new long[N+1];
		
		dp[1]=1;
		
		if(N>=2) {
			for(int i=2;i<=N;i++) {
				dp[i]=dp[i-1]+dp[i-2];
			}
		}
		
		System.out.println(dp[N]);
	}

}
