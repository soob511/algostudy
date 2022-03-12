package study;

import java.io.*;
import java.util.*;

public class Main_17070_파이프옮기기 {
	static int[][] map;
	static int n;
	static int[] dx = { 0, 1, 1 }; //오른쪽 ,아래 ,대각선
	static int[] dy = { 1, 0, 1 };
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];

		//입력
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		//처음 파이프 칸
		map[1][1] = 1;
		map[1][2] = 1;

		//파이프놓기
		dfs(1, 2, 0);

		System.out.println(count);
	}

	private static void dfs(int x, int y, int d) {
		if (x == n && y == n) {//도착하면 경우의수 카운트
			count++;
		}
		
		for (int i = 0; i < 3; i++) {//0.오른쪽 1.아래 2. 대각선
			if (d == 0 && i == 1) {//오른쪽일때 아래로 못가게
				continue;
			}
			if (d == 1 && i == 0) {//아래일때 오른쪽으로 못가게
				continue;
			}
			if (i == 2) { // 대각선으로 이동해야하는데 빈칸이 아닌 경우
				if (y + 1 <= n && x + 1 <= n) {
					if (map[x][y + 1] != 0 || map[x + 1][y] != 0) {
						continue;
					}
				}
			}
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
				if (map[nx][ny] != 1) {//벽이 아니면
					dfs(nx, ny, i);
				}
			}
		}

	}
}
