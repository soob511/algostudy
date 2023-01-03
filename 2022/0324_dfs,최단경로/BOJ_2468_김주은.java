package com.ssafy.add.d0324;

import java.io.*;
import java.util.*;

public class Main_BJ_2468_안전영역_김주은 {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	//우, 하, 좌, 상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int maxResult = 1; //최대안전영역 갯수
		
		int min = 100;
		int max = 1;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]<min) min=map[i][j];
				if(map[i][j]>max) max=map[i][j];
			}
		}
		
		
		for(int n=min;n<max;n++) {
			visited = new boolean[N][N];
			int areacnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visited[i][j]==false && map[i][j]>n) {
						dfs(i,j,n);
						++areacnt;
					}
				}
			}
			maxResult = Math.max(maxResult, areacnt);
		}
		
		System.out.println(maxResult);
	}

	static void dfs(int r, int c, int n) {
		
		visited[r][c]=true;
			
		for(int i=0;i<4;i++) {
			int nextr=r+dr[i];
			int nextc=c+dc[i];
			
			if(nextr<0 || nextr>=N || nextc<0 || nextc>=N || map[nextr][nextc]<=n || visited[nextr][nextc]) continue;
			
			dfs(nextr,nextc,n);
		}
	}
}
