package study;

import java.io.*;
import java.util.*;

public class Main_4963_섬의개수 {
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	static boolean[][] visit;
	static int h,w;
	static int[][] map;

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 w = Integer.parseInt(st.nextToken());//넓이
			 h = Integer.parseInt(st.nextToken());//높이
			
			if(w==0&&h==0) {//0 0 두개입력시 종료
				break;
			}
			
			 map = new int[h][w];
			 visit = new boolean[h][w];
			//맵입력
			for(int i=0;i<h;i++) {
				 st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			//섬의 갯수 세기
			int count=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]==1&&!visit[i][j]) {//땅이고 방문하지않은곳만 탐색
						bfs(i,j);
						count++;
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,b});
		visit[a][b] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			
			for(int i=0;i<8;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0&&nx<h&&ny>=0&&ny<w&&map[nx][ny]==1&&!visit[nx][ny]) {
					q.add(new int[] {nx,ny});
					visit[nx][ny] = true;
				}
			}
				
		}
		
	}

}
