package com.bj;

import java.io.*;
import java.util.*;


public class Main_BJ_13405_퇴사_김주은 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] sangdam = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			sangdam[i][0] = Integer.parseInt(st.nextToken());
			sangdam[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			
			if(dp[i]==0) {
				dp[i]=dp[i-1];
			}
			else if(sangdam[i][0]==1) {
				dp[i]=Math.max(dp[i], sangdam[i][1]);
				continue;
			}
			
			if(i+sangdam[i][0]-1 <= N) {
				dp[i+sangdam[i][0]-1]=Math.max(dp[i+sangdam[i][0]-1],dp[i]+sangdam[i][1]);
			}
			
		}
		
		System.out.println(dp[N]);
		
		
		
		
	}

}
