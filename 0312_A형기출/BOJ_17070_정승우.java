package com.ssafy.day0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_정승우 {

	//방향 - 우,우하,하
	static int[] dr = {0,1,1};
	static int[] dc = {1,1,0};
	static int N,cnt=0;
	static boolean[][] visited;
	static int[][] map; 

 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//map의 크기 - N x N
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N]; 
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		dfs(0,1,0);
	
		System.out.println(cnt);
		
	}

 	static void dfs( int r, int c, int move) {
 	
 		//조건이 끝날떄? -> r,c값이 N-1값과 같을때 (목적지에 도착)
 		
 		if  (r==N-1&&c==N-1) {
 			cnt++;
 			return;
 		} else {
 			//파이프가 옆으로 이어질때
 			if (move==0) {
 				//옆으로 이동할떄의 경계값 체크
 				if(c+1<N && map[r][c+1]==0) {
 					dfs(r, c+1, 0);
 				}
 				//우측 대각선 방향으로 이동할때 경계값 체크
 				if(r+1<N&&c+1<N&&map[r+1][c+1]==0&&map[r][c+1]==0&&map[r+1][c]==0) {
 					dfs(r+1, c+1, 1);
 				}
 			}
 			if (move==1) {
 				//옆으로 이동할떄의 경계값 체크
 				if(c+1<N && map[r][c+1]==0) {
 					dfs(r, c+1, 0);
 				}
 				//우측 대각선 방향으로 이동할때 경계값 체크
 				if(r+1<N&&c+1<N&&map[r+1][c+1]==0&&map[r][c+1]==0&&map[r+1][c]==0) {
 					dfs(r+1, c+1, 1);
 				}
 				// 밑으로 이동할때 경계값 체크
 				if(r+1<N&&map[r+1][c]==0) {
 					dfs(r+1, c, 2);
 				}
 			}
 			if (move==2) {
 				//우측 대각선 방향으로 이동할때 경계값 체크
 				if(r+1<N&&c+1<N&&map[r+1][c+1]==0&&map[r][c+1]==0&&map[r+1][c]==0) {
 					dfs(r+1, c+1, 1);
 				}
 				// 밑으로 이동할때 경계값 체크
 				if(r+1<N&&map[r+1][c]==0) {
 					dfs(r+1, c, 2);
 				}
 			}
 		}
 		
 		
 	}
}
