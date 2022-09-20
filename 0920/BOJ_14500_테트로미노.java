package com.bj;

import java.io.*;
import java.util.*;

public class Main_BJ_14500_테트로미노_김주은 {
	
	static int N, M;
	static int[][] paper;
	static boolean[][] passed;
	static boolean[][] visited;
	static int maxVal=0;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		passed = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//4가지는 dfs, 1가지 pink색 예시
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited = new boolean[N][M];
				visited[i][j]=true;
				dfs(i,j,0,0);
				passed[i][j]=true;
				pink(i,j);
			}
		}
		
		System.out.println(maxVal);
	
	}
	
	private static void dfs(int i, int j, int val, int cnt) {
		if(cnt==4) {
			if(maxVal<val) {
				maxVal=val;
			}
			return;
		}
		
		for(int d=0;d<4;d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || passed[nr][nc]) {
				continue;
			}
			
			visited[nr][nc]=true;
			dfs(nr,nc,val+paper[i][j],cnt+1);
			
		}
	}

	private static void pink(int i, int j) {
		
		for(int k=0;k<4;k++) {
			int val = paper[i][j];
			int cnt = 3;
			for(int d=0;d<4;d++) {
				int nr = i+dr[d];
				int nc = j+dc[d];
				if(d!=k && nr>=0 && nr<N && nc>=0 && nc<M) { //k번째 방향은 제외
					--cnt;
					val+=paper[nr][nc];
				}
			}
			
			if(cnt==0 && maxVal<val) {
				maxVal=val;
			}
		}
		
		
	}

}
