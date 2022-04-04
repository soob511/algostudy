package day0405;
import java.io.*;

public class BOJ_2579_이길상 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 계단 개수
		int N = Integer.parseInt(br.readLine());
		
		// 1계단, 2계단 전에서 왔을때의 최댓값
		int[][] dp = new int[N+2][2];
		
		for (int i = 2; i < N+2; i++) {
			int score = Integer.parseInt(br.readLine());
			
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + score;
			dp[i][1] = dp[i-1][0] + score;
		}
		
		System.out.println(Math.max(dp[N+1][0], dp[N+1][1]));
    }

}
