import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_18428_감시피하기_김주은 {

	static int N;
	static char[][] map;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'X') {
					list.add(i * N + j);
				}
			}
		}
		
		dfs(0, 0, new int[3]);

		System.out.println("NO");
	}

	private static void dfs(int cnt, int idx, int[] sel) {

		if (cnt == 3) {
			if (check(sel)) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			sel[cnt] = list.get(i);
			dfs(cnt + 1, i + 1, sel);
		}
	}

	private static boolean check(int[] sel) {

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		boolean student=false;

		for (int i = 0; i < 3; i++) {
			map[sel[i] / N][sel[i] % N] = 'O';
		}
		A : for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'T') {
					for (int d = 0; d < 4; d++) {
						for (int k = 1; k < N; k++) {
							int nr = i + dr[d] * k;
							int nc = j + dc[d] * k;
							if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
							if(map[nr][nc]=='O'||map[nr][nc]=='T') break;
							if(map[nr][nc]=='S') {
								student=true;
								break A;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			map[sel[i] / N][sel[i] % N] = 'X';
		}
		
		return student?false:true;
	}

}
