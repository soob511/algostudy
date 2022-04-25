package com.ssafy.day0425;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2169_정승우 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		//오->왼
		int[] goLeft = new int[m+1];
		//왼->오
		int[] goRight = new int[m+1];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<m+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dp 첫번째행의 큰값은 map의 첫번째행을 왼->오 로 더해가면서 이동한 값
		for(int i=1; i<m+1; i++)
			dp[1][i] = (dp[1][i-1] + map[1][i]);
		
		
		//dp 2행 ~ n행까지
		for(int r=2; r<n+1; r++) {
		
			//goright는 0을 제외한 왼쪽에서 바로 윗행 값과 더한 결과
			goRight[1] = dp[r-1][1] + map[r][1];
			for(int c=2; c<m+1; c++)
				//그 이후 오른쪽으로 가면서 오른쪽으로 이동하는 값과 그 위의 값중 큰 값을 map[r][c]와 더해줌
				goRight[c] = Math.max(goRight[c-1], dp[r-1][c]) + map[r][c];
			
			//goleft는 가장 오른쪽에서 바로 윗행값과 더한 결과 
			goLeft[m] = dp[r-1][m] + map[r][m];
			for(int c=m-1; c>=1; c--)
				//그 이후 왼쪽으로 가면서 왼쪽으로 이동하는 값과 그 위의 값중 큰 값을 map[r][c]와 더함
				goLeft[c] = Math.max(goLeft[c+1], dp[r-1][c]) + map[r][c];
			
			//goRight와 goLeft중 더 큰 값을 dp[r][c]에 저장
			for(int c=1; c<m+1; c++)
				dp[r][c] = Math.max(goRight[c], goLeft[c]);
			
		}
		//dp[n][m]에는 가장 큰 값이 저장되어있음
		System.out.println(dp[n][m]);
	}
	

	
}