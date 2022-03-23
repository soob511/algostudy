package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int n,h;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int rain;
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());//배열수
		map = new int[n][n];
		//입력
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				h = Math.max(map[i][j], h);//높이 최댓값
			}
		}
		
		
		int rain=0;
		int result=0;
		//비의양 1부터 최대높이까지 반복
		while(rain<=h) {
			
			visit = new boolean[n][n];//배열 초기화
			int count = 0;
			
			//안전한 영역 탐색
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]>rain&&!visit[i][j]) {
						dfs(i,j,rain);
						count++;
					}
				}
			}
			result = Math.max(result, count);//안전한구역 최대값
			rain++;//비의양 ++
		}
			
			System.out.println(result);
		
	}

	private static void dfs(int x,int y,int b) {
		visit[x][y]= true;
		for(int i=0;i<4;i++) {//상하좌우 탐색
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] > b && !visit[nx][ny]) {//안전한구역만 탐색
					dfs(nx, ny,b);
				}

			}
			
		}
		
	}

}
