package com.bj;

import java.io.*;
import java.util.*;

public class Main_BJ_2589_보물섬_김주은 {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int maxDistance=0;
		
		boolean[][] map = new boolean[R][C];
		//map 입력
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				if(s.charAt(j)=='L') {
					map[i][j]=true; //땅이라면 true
				}
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]) {
					//bfs로 가장 먼 거리 길이 탐색
					
					int distance=0; //(i,j)에서 시작하여 최대 탐색 거리
					
					boolean[][] visited = new boolean[R][C];//bfs탐색시 방문 체크
					
					LinkedList<int[]> queue = new LinkedList<int[]>();					
					queue.add(new int[] {i,j});
					visited[i][j]=true;
					
					while(!queue.isEmpty()) {
						
						int s = queue.size();
						
						while(s-->0){
							
							int[] val = queue.poll();
							
							for(int d=0; d<4; d++) {
								int nr = val[0]+dr[d];
								int nc = val[1]+dc[d];
								
								//범위 벗어나거나 or 이미 방문했거나 or 바다일 경우 제외
								if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc] || !map[nr][nc]) {
									continue;
								}
								
								visited[nr][nc]=true;
								queue.add(new int[] {nr,nc});
								
							}
						}
						++distance;
					}
					
					//최대 탐색 거리 갱신
					maxDistance = Math.max(maxDistance, distance-1);
				}
			}
		}
		
		System.out.println(maxDistance);
		
	}

}
