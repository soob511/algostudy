package com.ssafy.day0407;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ_1389_정승우 {
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());	// 유저 수
		int M = Integer.parseInt(st.nextToken());	// 관계 수.
		int INF = 987654321;
		int res = INF;
		int ans = -1;
		
		int[][] arr = new int[N+1][N+1];
		
		// 초기값 설정
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = INF;
				
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}
		
		// 양방향 처리
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = arr[y][x] = 1;
		}
	
		
		// 플로이드 와샬 
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 최단경로 초기화
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		// 가장 작은 사람 ans에 저장
		for (int i = 1; i <= N; i++) {
			int total = 0;
			
			for (int j = 1; j <= N; j++) {
				total += arr[i][j];
			}
			
			if (res > total) {
				res = total;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}
}
