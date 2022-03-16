package com.ssafy.day0308;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_정승우 {
	
	static class Tomato{
		int r,c,h;
		
		public Tomato(int h, int r, int c) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
	//가로,세로,높이 방향값 설정
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	
	//가로, 세로, 높이
	static int M, N, H; 
	//토마토 배열
	static int[][][] map;	
	
	//익지 않은 토마토 수
	static int cnt;	
	
	//토마토를 담을 q생성
	static Queue<Tomato> q = new LinkedList<>();	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		//3차원 배열 담음
		map = new int[H][N][M];
		for (int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					
					//익은 토마토 정보를 bfs 탐색의 시작점으로 저장
					if(map[i][j][k] == 1) q.offer(new Tomato(i,j,k));
					//익지 않은 토마토의 개수 cnt
					else if(map[i][j][k]==0) cnt++;
				}
			}
			
		}
		//익지 않은 토마토가 0이면 바로 0출력
		if(cnt==0) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
	}


	private static void bfs() {
		
		int day = 0;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			while(size-- > 0) {
				
				// q에 담긴 토마토 정보 t에 저장
				Tomato t = q.poll();	
				
				//토마토 방향 6개 설정
				for(int d = 0; d<6; d++) {
					int nh = t.h + dh[d];
					int nr = t.r + dr[d];
					int nc = t.c + dc[d];
					
					//경계 안에 있고, 익지 않은 토마토라면
					if(nh>=0 && nh<H &&nr>=0 && nr<N && nc>=0 && nc<M && map[nh][nr][nc] == 0 ) {
						// 값에 1 넣어줘서 익은 토마토로 바꿔줌
						map[nh][nr][nc] = 1;	
						//현재 익은 토마토를 기준으로 주변의 토마토를 q에 담아둠
						q.offer(new Tomato(nh,nr,nc));	
	
						//익지 않은 토마토 개수 반영
						cnt--;	
					}
				}
			}
			//해당 날짜에 대한 탐색이 끝났다면 날짜 추가
			day++;	
			
			//탐색 후 익지 않은 토마토의 개수가 0이면 day출력
			if(cnt==0) {
				System.out.println(day);
				return;
			}
		}
		
		//익지 않은 토마토가 존재하기 때문에 -1 출력
		System.out.println(-1);
	}
}
