package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2589_보물섬 {
	static int m,n,result;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 m = Integer.parseInt(st.nextToken());//세로
		 n = Integer.parseInt(st.nextToken());//가로
		
		 map = new char[m][n];
		
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j);
			}
			
		}
		
		//for(char[] b:map)System.out.println(b);System.out.println();
		
		for(int i =0;i<m;i++) {//육지 탐색
			for(int j=0;j<n;j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int a, int b) {
		
		visit = new int[m][n]; //거리계산맵
		for(int i = 0 ; i< m ; i++) {//초기화
			for(int j=0 ; j < n ; j++) {
				visit[i][j] = -1;
			}
		}
		
		visit[a][b]=0;
		q.add(new int[] {a,b});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0||nx>=m||ny<0||ny>=n) {//경계값 벗어나면
					continue;
				}
				
				
				if(map[nx][ny]=='L'&& visit[nx][ny]==-1) {//육지이고 아직 가지않았으면
					visit[nx][ny]= visit[x][y]+1;
					q.add(new int[] {nx,ny});
					result = Math.max(result, visit[nx][ny]);
				}
			}
			
			
		}

		
		
		
	}

}
