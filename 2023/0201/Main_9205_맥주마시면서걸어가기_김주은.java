import java.io.*;
import java.util.*;

public class Main_BJ_9205_맥주마시면서걸어가기_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());

			int[][] road = new int[N + 1][2];

			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = -1, ey = -1;

			for (int i = 0; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				road[i][0] = x;
				road[i][1] = y;
				if (i == N) {
					ex = x;
					ey = y;
				}
			}

			Queue<int[]> queue = new ArrayDeque<>();
			queue.add(new int[] { sx, sy });

			boolean[] visited = new boolean[N + 1];

			boolean canGo = false;

			while (!queue.isEmpty()) {

				int[] v = queue.poll();

				if (v[0] == ex && v[1] == ey) {
					canGo = true;
					break;
				}

				for (int i = 0; i <= N; i++) {
					if (!visited[i]) {

						int dist = Math.abs(v[0] - road[i][0]) + Math.abs(v[1] - road[i][1]);
						if (dist <= 1000) {
							visited[i] = true;
							queue.add(new int[] { road[i][0], road[i][1]});
						}

					}
				}
			}

			sb.append(canGo ? "happy\n" : "sad\n");
		}

		System.out.println(sb);

	}

}
