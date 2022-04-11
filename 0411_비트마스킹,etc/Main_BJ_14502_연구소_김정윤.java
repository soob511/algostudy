package algorithmn2_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14502_연구소_김정윤 {
	
	static class Virus {
		int x, y;
		
		Virus(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static int result = Integer.MIN_VALUE;
	static int N, M;

	public static void main(String[] args) throws IOException {
		/*
		 * 연구소의 크기 : N*M, 빈칸 or 벽으로 이루어져있음
		 * 바이러스 : 상하좌우 인접한 빈칸으로 퍼져나감
		 * 새로 세울 수 있는 벽의 개수 = 3개
		 * 0:빈칸 / 1:벽 / 2:바이러스
		 * 
		 * * output : 안전영역 크기의 최댓값
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 3<=N, M<=8
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0);	// 벽 세우면서 바이러스 뿌리기 시작
		
		System.out.println(result);
	}

	private static void DFS(int wall) {
		// 벽 3개를 다 세웠으면 바이러스 뿌리기
		if(wall==3) {
			BFS();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					// 벽 세우고
					map[i][j] = 1;
					DFS(wall+1);
					// 다시 돌려놓기
					map[i][j] = 0;
				}
			}
		}
		
	}

	private static void BFS() {
		
		int[][] virus_map = new int[N][M];
		Queue<Virus> q = new LinkedList<Virus>();
		
		// Virus map 복제
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				virus_map[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus_map[i][j]==2) {	// 바이러스라면 queue에 넣음
					q.add(new Virus(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			Virus v= q.poll();
			
			for(int d=0; d<4; d++) {
				int r = v.x + dr[d];	// 바이러스 상하좌우 이동
				int c = v.y + dc[d];
				
				// map내에 있으면
				if(r>=0 && r<N && c>=0 && c<M) {
					// 빈칸이라면 바이러스 퍼뜨기
					if(virus_map[r][c]==0) {
						virus_map[r][c] = 2;
						q.add(new Virus(r, c));
					}
				}
			}
		}
		safeCheck(virus_map);
		
	}

	private static void safeCheck(int[][] virus_map) {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus_map[i][j]==0) cnt++;
			}
		}
		result = Math.max(cnt, result);
	}

}
