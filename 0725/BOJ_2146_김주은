package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_2146_다리만들기_김주은 {

	static int N;
	static boolean[][] map;
	static int[][] land;
	static int cntLand;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int minLength=200;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		land = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken())>0?true:false;
			}
		}
		

		//1. 각 섬에 대해 번호를 매긴다
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] && land[i][j]==0) {
					++cntLand;
					countLand(i,j);
				}
			}
		}
		
		//2. 가장 짧은 다리 길이 찾기
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(land[i][j]>0) {
					//bfs탐색
					int length=0;
					boolean[][] visited = new boolean[N][N];
					LinkedList<int[]> queue = new LinkedList<int[]>();
					
					visited[i][j]=true;
					queue.add(new int[] {i,j});
					
					int iland=i;
					int jland=j;
					
					L: while(!queue.isEmpty()) {
						int s = queue.size();
						while(s-->0) {
							int[] val = queue.poll();
							
							int x=val[0];
							int y=val[1];
							
							for(int d=0;d<4;d++) {
								int nx=x+dr[d];
								int ny=y+dc[d];
								
								if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || land[iland][jland]==land[nx][ny]) {
									continue;
								}
								
								if(land[nx][ny]==0) { //새로운 바다로 이동 추가
									visited[nx][ny]=true;
									queue.add(new int[] {nx,ny});
								} else { //다른 대륙~
									minLength = Math.min(minLength, length);
									break L;
								}
							}
						}
						++length;
					}
			
				}
			}
		}
		
		System.out.println(minLength);
	}

	private static void countLand(int i, int j) {
		
		land[i][j]=cntLand;
		
		for(int d=0;d<4;d++) {
			int ni=i+dr[d];
			int nj=j+dc[d];
			
			if(ni<0 || ni>=N || nj<0 || nj>=N || !map[ni][nj] || land[ni][nj]>0) {
				continue;
			}
			
			countLand(ni,nj);
		}
	}

}
