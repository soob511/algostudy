package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11052_카드구매하기_김정윤 {

	public static void main(String[] args) throws IOException {
		/*
		 * 카드 N개 구매 : 최대한 돈을 많이 지불
		 * 카드 i개 포함된 카드팩은 Pi원
		 * 
		 * * output :  카드 N개를 갖기 위해 지불해야하는 금액의 최댓값
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	 // 구매하려는 카드의 개수
		
		int[] card = new int[N+1];
		card[0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) card[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+1];
		
		dp[0] = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], card[j]+dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
	}

}
