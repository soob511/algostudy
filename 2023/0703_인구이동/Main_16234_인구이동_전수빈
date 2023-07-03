
import java.util.*;
import java.io.*;

public class Main{
	static int n, L, R;
	static int[][] map;
	static boolean visit[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean people = false;
	static int day;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			people = false;
			visit = new boolean[n][n]; 

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						bfs(i, j);
					}
				}
			}

			if (!people) {
				break;
			} else {
				day++;
			}
		}

		System.out.println(day);
	}

	private static void bfs(int a, int b) {

		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		q.add(new int[] { a, b });
		visit[a][b] = true;
		list.add(new int[] { a, b });

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
					if (Math.abs(map[nx][ny] - map[x][y]) >= L && Math.abs(map[nx][ny] - map[x][y]) <= R) {
															
						people = true;
						visit[nx][ny] = true;
						q.add(new int[] { nx, ny });
						list.add(new int[] { nx, ny });
					}
				}
			}

		}
		
		int sum=0;
		int size = list.size();
		for(int i=0;i<size;i++) {
			int[] p = list.get(i);
			int x = p[0];
			int y = p[1];
			sum+=map[x][y];
		}
		
		for(int i=0;i<size;i++) {
			int[] p = list.get(i);
			int x = p[0];
			int y = p[1];
			map[x][y] = sum/size;
		}
		list.removeAll(list);
		

	}

}
