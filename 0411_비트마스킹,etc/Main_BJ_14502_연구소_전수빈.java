package webex0408;

import java.io.*;
import java.util.*;

public class Main_BJ_14502_연구소_전수빈 {
	static int n, m;
	static int[][] map;
	static int[][] virus;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		virus = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		wall(0);

		System.out.println(max);
		//for (int[] b : virus)System.out.println(Arrays.toString(b));System.out.println();
	}

	private static void wall(int cnt) {
		if (cnt == 3) {//벽세우면
			bfs();//바이러스 퍼트리기
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (virus[i][j] == 0) {
						count++;//안전구역 세기
					}
				}
			}
			max = Math.max(max, count);//최대값

			return;
		}

		//벽세우기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				virus[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (virus[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] a = q.poll();
			int x = a[0];
			int y = a[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && virus[nx][ny] == 0) {
					virus[nx][ny] = 2;
					q.add(new int[] { nx, ny });

				}

			}

		}

	}

}
