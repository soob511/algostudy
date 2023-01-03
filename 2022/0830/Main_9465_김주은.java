package com.bj;

import java.io.*;
import java.util.*;

public class Main_BJ_9465_스티커_김주은 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[2][N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				map[0][i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				map[1][i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[2][N];
			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			
			for(int i=1;i<N;i++) {
				int max;
				max = Math.max(dp[0][i-1], dp[1][i-1]+map[0][i]);
				if(i>=2) {
					max = Math.max(max, dp[0][i-2]+map[0][i]);
				}
				dp[0][i]=max;
				
				
				max = Math.max(dp[1][i-1], dp[0][i-1]+map[1][i]);
				if(i>=2) {
					max = Math.max(max, dp[1][i-2]+map[1][i]);
				}
				dp[1][i]=max;
			}
			
			System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
		}
	}

}
