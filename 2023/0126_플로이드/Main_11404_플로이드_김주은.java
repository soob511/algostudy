import java.io.*;
import java.util.*;

public class Main_BJ_11404_플로이드_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = 1000000001;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j]=INF;
			}
			map[i][i]=0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			if (map[a][b] == INF) {
				map[a][b] = c;
			} else if ( c < map[a][b]) {
				map[a][b] = c;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if(k==i) continue;
				for (int j = 0; j < n; j++) {
					if(i==j) continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print((map[i][j]>=INF?0:map[i][j])+" ");
			}
			System.out.println();
		}

	}

}
