import java.io.*;
import java.util.*;

public class Main_BJ_11403_경로찾기_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int INF = 100000;

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i != j && map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= INF) {
					sb.append(0).append(" ");
				} else {
					sb.append(1).append(" ");
				}
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
