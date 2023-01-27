import java.io.*;
import java.util.*;

public class Main_BJ_2206_벽부수고이동하기_김주은 {

	public static class Pos {
		int x;
		int y;
		boolean broken;
		int time;

		public Pos(int x, int y, boolean broken, int time) {
			super();
			this.x = x;
			this.y = y;
			this.broken = broken;
			this.time = time;
		}
	}

	static int N, M;
	static int[][] map;
	static int min = 1000000;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		ArrayList<Integer> list = new ArrayList<>();

		int zero = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
				if (map[i][j] == 0) {
					++zero;
				}
			}
		}

		if (zero < N + M - 2) {
			System.out.println(-1);
			return;
		}

		bfs();

		System.out.println(min == 1000000 ? -1 : min);
	}

	private static void bfs() {

		boolean[][][] visited = new boolean[N][M][2]; // 0:안뿌순, 1:뿌순
		LinkedList<Pos> queue = new LinkedList<>();

		visited[0][0][0] = true;
		queue.add(new Pos(0, 0, false, 1));

		while (!queue.isEmpty()) {

			Pos v = queue.poll();

			if (v.x == N - 1 && v.y == M - 1) {
				min = Math.min(v.time, min);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = v.x + dr[d];
				int nc = v.y + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M ) {
					continue;
				}
				
				if(v.broken) { //이미 벽 깸
					if(map[nr][nc]==0 && visited[nr][nc][1]==false) {
						visited[nr][nc][1]=true;
						queue.add(new Pos(nr,nc,true,v.time+1));
					}
				} else { //아직 벽 안깸
					if(map[nr][nc]==0 && visited[nr][nc][0]==false) {
						visited[nr][nc][0]=true;
						queue.add(new Pos(nr,nc,false,v.time+1));
					}
					if(map[nr][nc]==1 && visited[nr][nc][1]==false) {
						visited[nr][nc][1]=true;
						queue.add(new Pos(nr,nc,true,v.time+1));
					}
				}
				
			}

		}
	}

}
