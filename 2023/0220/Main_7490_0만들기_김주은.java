import java.util.Scanner;

public class Main_BJ_7490_0만들기_김주은 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int tc = 0; tc < N; tc++) {

			int n = sc.nextInt();

			dfs(0, "", n);

			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int cnt, String line, int n) {

		if (cnt == n - 1) {
			line += (cnt + 1);
			String s = line.replaceAll(" ", "");
			if (isSumZero(s)) {
				sb.append(line + "\n");
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				dfs(cnt + 1, line + (cnt + 1) + ' ', n);
			} else if (i == 1) {
				dfs(cnt + 1, line + (cnt + 1) + '+', n);
			} else if (i == 2) {
				dfs(cnt + 1, line + (cnt + 1) + '-', n);
			}
		}

	}

	private static boolean isSumZero(String line) {

		int idx = 0;
		int sum = 0;
		int num = 0;
		int op = 1;// 1:덧셈, 2:뺄셈

		while (idx < line.length()) {
			if (line.charAt(idx) == '+') {
				if (op == 1) {
					sum += num;
				} else if (op == 2) {
					sum -= num;
				}
				num = 0;
				op = 1;
			} else if (line.charAt(idx) == '-') {
				if (op == 1) {
					sum += num;
				} else if (op == 2) {
					sum -= num;
				}
				num = 0;
				op = 2;
			} else {
				num *= 10;
				num += line.charAt(idx) - '0';
			}

			++idx;
		}

		if (op == 1) {
			sum += num;
		} else if (op == 2) {
			sum -= num;
		}

		return sum == 0 ? true : false;
	}

}
