import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1103_게임_김주은 {

	static int N, M;
	static int max_time = 0;
	static int[][] map, dp;
	static boolean isCycle = false;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0' > 10 ? -1 : s.charAt(j) - '0';
			}
		}

		dp = new int[N][M];
		visited = new boolean[N][M];
		visited[0][0]=true;
		dfs(0, 0, 1);

		System.out.println(isCycle ? -1 : max_time);
	}

	private static void dfs(int i, int j, int k) {
		
		dp[i][j]=k;
		max_time = Math.max(max_time, k);

		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d] * map[i][j];
			int nc = j + dc[d] * map[i][j];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] < 0)
				continue;

			if (dp[nr][nc] <= k) {
				if (visited[nr][nc]) {
					isCycle = true;
					return;
				} else {
					visited[nr][nc]=true;
					dfs(nr, nc, k + 1);
					visited[nr][nc]=false;
				}

			}

		}

	}

}
