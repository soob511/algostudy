package com.ssafy.add.d0308;

import java.util.*;
import java.io.*;

public class Main_BJ_7562_나이트의이동_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			//시작 좌표
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			//도착 좌표
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			
			///////// bfs 탐색 ///////////
			
			int cnt=0; //최소 이동 횟수
			
			if(x==p && y==q) {
				System.out.println(cnt);
				continue;
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[][] visited = new boolean[N][N];
			
			int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
			int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
			
			
			//시작 좌표 queue에 넣고 탐색횟수 증가
			queue.add(x);
			queue.add(y);
			visited[x][y]=true;
			++cnt;
			

			outer: while(!queue.isEmpty()) {
				
				//queue size만큼 레벨별 탐색
				int size = queue.size()/2;
				while(size-->0){
					
					int nextx = queue.poll();
					int nexty = queue.poll();
					
					for(int d=0;d<8;d++) {  //8방 탐색
						int tempx = nextx + dx[d];
						int tempy = nexty + dy[d];
						
						//목표 지점 도착
						if(tempx == p && tempy == q) {
							System.out.println(cnt);
							break outer;
						}
						
						//이동 가능 지점 탐색
						if(tempx>=0 && tempx<N && tempy>=0 && tempy<N && visited[tempx][tempy]==false) {
							queue.add(tempx);
							queue.add(tempy);
							visited[tempx][tempy] = true;
						}
					}
				}
				
				++cnt; //한 레벨 모두 탐색 후 탐색횟수 증가
			}
			
			
		}
		
	}

}
