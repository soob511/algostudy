package com.ssafy.day0427;
import java.io.*;
import java.util.*;


public class BOJ_16234_정승우 {

	static class pos{
		int r;
		int c;
		
		pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {0,0,1,-1};
	static int dc[] = {1,-1,0,0};
	
	static ArrayList<pos> list = new ArrayList<>();
	static Queue<pos> q;
	static boolean visit[][];
	static int map[][];
	static int N,L,R,cnt;
	static boolean isMove = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			isMove = false;
			//while문 반복할때마다 visit 초기화
			visit = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					if(!visit[i][j]){
						//visit[i][j]가 방문하지 않았다면 bfs
						bfs(i,j);    
					}				
				}
			}
			
			//isMove가 false라면 국경이동이 일어나지 않았으므로 break
			if(!isMove) break; 
			//이동이 있었으면 cnt값 증가
			else cnt++; 
		}
		
		System.out.println(cnt);
        
	}

	
	static void bfs(int r, int c) {
		q = new LinkedList<>();
		q.add(new pos(r,c));
		visit[r][c] = true;
		list.add(new pos(r,c));
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			r = p.r;
			c = p.c;
			
			for(int k=0; k<4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				//경계를 벗어나지 않은 경우
				if(0<=nr && nr<N && 0<=nc && nc<N) {
					//방문하지 않았고 인접한 두구역의 차이가 L보다 크거나 같고 R보다 작은 경우
					if(!visit[nr][nc] && L <= Math.abs(map[r][c] - map[nr][nc]) &&  Math.abs(map[r][c] - map[nr][nc]) <= R) {
						isMove = true;
						visit[nr][nc] = true;
						list.add(new pos(nr,nc));
						q.add(new pos(nr,nc));
					}
				}	
			}				
		}	
		
		//인구이동이 일어난곳들의 인구의 총합을 sum에 저장
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			pos p = list.get(i);
			 sum += map[p.r][p.c];
		}
		
		//저장된 값을 인구이동이 일어난 나라의 수만큼 나누고, 해당하는 나라에 나눈 값을 저장
		for(int i=0; i<list.size(); i++) {
			pos p = list.get(i);
			map[p.r][p.c] = sum / list.size();
		}
		//list초기화
		list.clear();
	}
}