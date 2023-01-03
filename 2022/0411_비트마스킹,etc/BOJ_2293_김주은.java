package com.ssafy.add.d0411;

import java.util.*;
import java.io.*;

public class Main_BJ_2293_동전1_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//coin 종류 저장
		int[] coin = new int[N+1];
		for(int i=1;i<=N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		
		//dp배열
		int[][] dp = new int[N+1][K+1];
		//0행 초기화
		dp[0][0]=1;
		
		//i행에는 coin[i]를 사용할 때 추가될 수 있는 경우의 수 저장
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				//총 합이 j일 때
				//coin[i]가 j보다 작은 경우 coin[i-1]까지만 사용한 경우 + coin[i]를 사용하여 j-coin[i]원 만든 경우 
				if(j>=coin[i]) {
					dp[i][j]=dp[i-1][j] + dp[i][j-coin[i]];
				} 
				//coin[i]가 j보다 큰 경우 coin[i-1]까지만 사용한 경우의 수 그대로
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
