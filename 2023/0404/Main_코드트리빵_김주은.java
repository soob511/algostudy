// 삼성코테 2022 하반기 오후 1번

import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] map;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[][] conv;
	
	static Queue<int[]> q = new ArrayDeque<>();
	static boolean[][] visited1;
	
	static ArrayDeque<int[]>[] move;
	static boolean[][][] visited;
	
	static int arrived = 0;
 
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		move = new ArrayDeque[M+1];
		for(int i=1;i<=M;i++) {
			move[i] = new ArrayDeque<int[]>();
		}
		visited = new boolean[M+1][N][N];
		
		conv = new int[M+1][2];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			conv[i][0]=x;
			conv[i][1]=y;
		}
		
		int time=0;
		
		for(int m=1;m<=M;m++) {
			++time;
			move();
			selectBaseCamp(m);
		}
		
		while(arrived<M) {
			++time;
			move();
		}
		
		System.out.println(time);
	}

	private static void move() {
		for(int i=1;i<=M;i++) {
			if(!move[i].isEmpty()) {
				int s = move[i].size();
				A : while(s-->0) {
					int[] v = move[i].poll();
					
					for(int d=0;d<4;d++) {
						int nr = v[0]+dr[d];
						int nc = v[1]+dc[d];
						
						if(nr<0 || nr>=N || nc<0 || nc>=N || visited[i][nr][nc] || map[nr][nc]<0 ) {
							continue;
						}
						
						if(nr==conv[i][0] && nc==conv[i][1]) {
							arrived+=1;
							map[nr][nc]=-1;
							move[i].clear();
							break A;
						}
						
						visited[i][nr][nc]=true;
						move[i].add(new int[] {nr,nc});
					}
				}
			}
		}
	}

	private static void selectBaseCamp(int m) {
		
		q.clear();
		q.add(new int[] {conv[m][0],conv[m][1]});
		visited1 = new boolean[N][N];
		visited1[conv[m][0]][conv[m][1]]=true;
		
		int x = N-1;
		int y = N-1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			boolean isBase = false;
			while(size-->0) {
				int[] v = q.poll();
				
				for(int d=0;d<4;d++) {
					int nr = v[0]+dr[d];
					int nc = v[1]+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited1[nr][nc] || map[nr][nc]<0 ) {
						continue;
					}
					
					if(map[nr][nc]==1) {
						isBase=true;
						if(nr<x) {
							x = nr;
							y = nc;
						}else if(nr==x && nc<y) {
							y=nc;
						}
						continue;
					}
					
					visited1[nr][nc]=true;
					q.add(new int[] {nr,nc});
				}
			}
			if(isBase) {
				break;
			}
		}
		
		//선택한 베이스캠프 방문처리, move 큐에 넣기
		map[x][y]=-1;
		move[m].add(new int[] {x,y});
		visited[m][x][y]=true;
	}

}
