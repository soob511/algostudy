package com.ssafy.day0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_정승우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//포도주 잔
		int[] drink = new int[N];
		
		for(int i=0; i<N; i++) {
			drink[i] = Integer.parseInt(br.readLine());
			
		}
		//포도주 잔이 3개보다 적다면
		if(N < 3) {
			int answer = 0;
			//answer에 누적한 값이 최대값
			for( int i=0; i<N; i++) {
				answer += drink[i];
			}
			System.out.println(answer);
			return;
		}
		//dp 배열 선언
		int[] dp = new int[N];
		// dp[0],dp[1]은 연속하는 세 수가 아니라서 그냥 더함
		dp[0] = drink[0];
		dp[1] = drink[0]+drink[1];
		// dp[2]연속하기 때문에 더 큰 값을 더해줌
		dp[2] = Math.max(dp[1], Math.max(drink[1]+drink[2], dp[0]+drink[2]));
		
		for(int i=3; i<N; i++) {
			dp[i] = Math.max(dp[i-3]+drink[i-1]+drink[i], dp[i-2]+drink[i]);
			dp[i] = Math.max(dp[i-1],  dp[i]);
			
		}
		//최대로 마실 수 있는 포도주의 양 출력
		System.out.println(dp[N-1]);
		
	}

}
