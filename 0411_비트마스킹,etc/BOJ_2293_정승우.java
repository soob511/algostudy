package com.ssafy.day0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293_정승우 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//종류 가지 수
		int N = Integer.parseInt(st.nextToken());
		// 가치의 합
		int K = Integer.parseInt(st.nextToken());
	
		//동전을 사용하여 K원이 되는 경우의 수
		int[][] dp = new int[N][K+1];
		//동전 종류 저장
		int[] coin = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		

		
		for(int i=0; i<N; i++) {
			dp[i][0]=1;
		}
		
		for(int i=0; i<N; i++) {
			for (int j=1; j<=K; j++) {
				//해당 코인보다 가치의 합이 같거나 더 커지는 경우
				if(j >= coin[i]) {
					//첫번째 코인
					if (i==0)dp[i][j] += dp[i][j - coin[i]];
					// 그 이후 코인들
					else dp[i][j] =dp[i-1][j] + dp[i][j - coin[i]];
				} else { // 해당 코인의 값이 가치의 합보다 더 큰경우 그 전에 구한 값 가져옴 
					dp[i][j] = dp[i-1][j];
				}
			}
			
			
		}
//		for(int[]a : dp) {
//			System.out.println(Arrays.toString(a));
//		}
		System.out.println(dp[N-1][K]);
	}

}
