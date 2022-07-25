package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2146_다리만들기 {
	static int n;
	static int[][] map;
	static int[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int result = 100;
	static int count=1;
	static int ic;
	static Queue<int[]> q = new LinkedList<int[]>();
	static Queue<int[]> q2 = new LinkedList<int[]>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		//맵 입력
		map = new int[n][n];
		visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		
		 visit = map;//맵 복사

		 
		 //섬 번호 매기기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visit[i][j]==1) {
					
					island(i, j);
				}
			}
		}
		for (int[] b : visit)
			System.out.println(Arrays.toString(b));
		System.out.println();

		
		//거리 탐색
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if(visit[i][j]!=0) {
					ic=visit[i][j];
					bfs(i, j,ic);
				}
			}
		}
		System.out.println(result);

	}

	
	private static void bfs(int a, int b,int c) {

		q2.add(new int[] { a, b ,c});

		while (!q2.isEmpty()) {
			int[] p = q2.poll();
			int x = p[0];
			int y = p[1];
			int z = p[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				
				if(map[nx][ny]==0&&visit[nx][ny]==0) {
					visit[nx][ny]= visit[x][y]+1;
					q2.add(new int[] {nx,ny,z});
					if(map[nx][ny]==1&&visit[nx][ny]!=z) {
						result = Math.min(result, visit[x][y]);
					}
					
				}
				
				
				

			}

		}
		
	}


	//섬 구분하기
	private static void island(int a, int b) {
		 
		count++;
		visit[a][b]=count;

		q.add(new int[] { a, b });

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				
				if(map[nx][ny]==1) {
					visit[nx][ny]=count;
					q.add(new int[] {nx,ny});
				}
				
				

			}

		}

	}
	
	
	
}
