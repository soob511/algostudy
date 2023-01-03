package com.ssafy.day0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_정승우 {

	static class Pos {
		
		int r;
		int c;

		
		public Pos(int r, int c) {
			r = this.r;
			c = this.c;

		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] section;
	static int level = 1;
	static int[][] map;
	static int N;
	static boolean[][] checked;
	static Queue<Pos> q;
	static int min;
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		section = new int[N][N];
		checked = new boolean[N][N];
		int total_min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for(int[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (map[i][j]==0) {
					continue;
				} else {
					dfs(i,j);
					level++;
				}
				
			}
		}
		
		//체크배열 재사용
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(section[i][j]!=0) {
					for(boolean[] a: checked) {
						Arrays.fill(a, false);
					}
					min=0;
					bfs(i,j);
					total_min = Math.min(total_min, min);
				}
			}
		}
		
		System.out.println(total_min);
		
		
	
	}
	
	//섬마다 값을 다르게 주기 위함
	static void dfs(int i, int j) {
		if (checked[i][j]==false) {
			checked[i][j]=true;
			section[i][j] = level;
		}
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]!=0&&checked[nr][nc]==false) {
				dfs(nr, nc);
			}
		}
	}
	
	static void bfs(int i, int j) {
		q.add(new Pos(i,j));
		
		while(!q.isEmpty()) {
			int len = q.size();
			
			for(int k=0; k<len; k++) {
				Pos cur = q.poll();
				int r = cur.r;
				int c = cur.c;
				
				checked[r][c]=true;
				for(int d=0; d<N; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<N&&checked[nr][nc]==false) {
						q.add(new Pos(nr,nc));
						if(section[r][c]!=0&&section[r][c]!=section[nr][nc]) {
							min++;
							System.exit(0);
						}
					}
				}
			}
			min++;
		}
	
	}

}
