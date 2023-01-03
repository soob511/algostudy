package com.ssafy.add.d0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_16234_인구이동_김주은 {
	
	static class Country {
		int x;
		int y;
		
		public Country(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N, L, R;
	static boolean[][] visited;
	static int[][] map;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0 ,-1, 0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		boolean hasMoved;
		
		do{
			hasMoved=false;
			visited = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//아직 미방문 && 방문시 변경이 있을 때 hasMoved=true;
					if(!visited[i][j] && union(i,j)) {
						hasMoved=true;
					}
				}
			}
			
			if(hasMoved) {
				++count;
			}
			
		} while(hasMoved);
		
		System.out.println(count);
		
	}

	private static boolean union(int i, int j) {
		
		LinkedList<Country> unionQueue = new LinkedList<Country>(); //연합할 나라 저장 Queue
		
		int popSum = 0;
		
		LinkedList<Country> queue = new LinkedList<Country>(); //연합할 나라 탐색 Queue
		queue.add(new Country(i,j));
		
		visited[i][j]=true;
		
		while(!queue.isEmpty()) {
			Country c = queue.poll();
			
			unionQueue.add(new Country(c.x,c.y)); //방문한 나라를 저장
			popSum+=map[c.x][c.y]; //나라 인구수 누적 저장
			
			for(int d=0;d<4;d++) {
				int nx = c.x + dr[d];
				int ny = c.y + dc[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;
				
				int diff = Math.abs(map[c.x][c.y] - map[nx][ny]);
				if(diff>=L && diff<=R) {
					visited[nx][ny]=true;
					queue.add(new Country(nx,ny));
				}
			}
		}
		
		if(unionQueue.size()==1) { //인구이동 발생X
			return false;
		} 
		else { //인구이동 발생
			
			int size = unionQueue.size();
			int popUpdate = popSum/size;
			
			while(!unionQueue.isEmpty()) {
				Country co = unionQueue.poll();
				map[co.x][co.y]=popUpdate; //각 나라 변동된 인구로 update
			}
			
			return true;
		}
	}


}
