import java.io.*;
import java.util.*;

public class Main_BJ_14502_연구소_김주은 {
	
	static int N,M;
	static int[][] map,map2;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static ArrayList<Integer> viruses = new ArrayList<>();
	static ArrayDeque<Integer> virus;
	static int safe=0;
	
	static int answer = 0;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					viruses.add(i*M+j);
				}else if(map[i][j]==0) {
					safe+=1;
				}
			}
		}
		
		//1. 벽을 세울 곳 탐색
		wall(0,0);
		
		System.out.println(answer-3);
	}

	private static void wall(int cnt, int idx) {
		
		if(cnt==3) {
			//2. 세워진 벽을 기준으로 바이러스 확산
			answer = Math.max(answer,spread());
			return;
		}
	
		for(int i=idx;i<N*M;i++) {
			if(map[i/M][i%M]==0) {
				map[i/M][i%M]=1;
				wall(cnt+1,i+1);
				map[i/M][i%M]=0;
			}
		}
		
	}

	private static int spread() {
		
		int safeCnt = safe;
		
		map2 = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map2[i][j]=map[i][j];
			}
		}
		
		virus = new ArrayDeque<>();
		for(int i=0;i<viruses.size();i++) {
			virus.add(viruses.get(i));
		}

		while(!virus.isEmpty()) {
			
			int v = virus.poll();
			
			for(int d=0;d<4;d++) {
				int nr = v/M+dr[d];
				int nc = v%M+dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=M || map2[nr][nc]!=0) {
					continue;
				}
				
				map2[nr][nc]=2;
				safeCnt-=1;
				virus.add(nr*M+nc);
			}
		}
		
		return safeCnt;
	}

}
