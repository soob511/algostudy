package study;

import java.io.*;
import java.util.*;

public class Main_17144_미세먼지안녕 {
	static int r, c, t;
	static int[][] map;
	static int[][] dust;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<int[]> q;
	static int u, d ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());// 시간초

		map = new int[r][c];
		
		// 맵 입력
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (t-- > 0) {//t초 후
			dust = new int[r][c];
			q = new LinkedList<>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] >= 5) {//미세먼지가 있는 칸만 큐에 저장
						q.add(new int[] { i, j });
					}
				}
			}
			bfs();//확산하기
			wind();//바람순회
			
			
		}
		//출력
		int sum=0; 
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j]!=-1) {//공기청정기가 아닌칸 
					
					sum+=map[i][j];	//미세먼지 합구하기
				}
			}
		}
		System.out.println(sum);
		
	}

	private static void wind() {
		for(int i=0;i<r;i++) {//공기청정기 찾기
			if(map[i][0] ==-1) {
				u=i;//윗행
				break;
			}
		}
		
		//|
		//v 아래로 
		for(int i=u-1;i>0;i--) {
			map[i][0] = map[i-1][0];
		}
		//<-- 왼쪽으로
		for(int i=0;i<c-1;i++) {
			map[0][i]= map[0][i+1];
		}
		// ^
		// | 위로
		for(int i=0;i<u;i++) {
			map[i][c-1] = map[i+1][c-1];
		}
		//--> 오른쪽으로
		for(int i=c-1;i>1;i--) {
			map[u][i] = map[u][i-1];
		
		}
		map[u][1]=0;//공기청정기에서 나오는 바람
		
		d=u+1;//공기청정기아랫행
		// ^
		// | 위로
		for(int i=d+1;i<r-1;i++) {
			map[i][0]= map[i+1][0];
		}
		//<-- 왼쪽으로
		for(int i=0;i<c-1;i++) {
			map[r-1][i] = map[r-1][i+1];
		}
		//|
		//v 아래로 
		for(int i=r-1;i>d;i--) {
			map[i][c-1] = map[i-1][c-1];
		}
		//--> 오른쪽으로
		for(int i=c-1;i>1;i--) {
			map[d][i] = map[d][i-1];
		
		}
		map[d][1] = 0;//공기청정기에서 나오는 바람
	}

	private static void bfs() {
		while (!q.isEmpty()) {

			int go = 0;
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] >= 0) {
					
					dust[nx][ny] += map[x][y] / 5;//미세먼지 확산
					go++;
				}
			}
			map[x][y] = (map[x][y] - ((map[x][y] / 5) * go));//남은 미세먼지양
		}
		
		for (int i = 0; i < r; i++) {//확산된미세먼지와 남은 미세먼지양 더하기
			for (int j = 0; j < c; j++) {
				map[i][j]+=dust[i][j];
			}
		}
	}

}
