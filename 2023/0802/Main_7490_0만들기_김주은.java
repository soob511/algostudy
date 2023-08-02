import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_7490_0만들기_김주은 {

	static int N;
	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			sb = new StringBuilder();
			dfs(1, 1, 0, 1, "1");
			System.out.println(sb);
		}

	}

	private static void dfs(int cnt, int num, int sum, int op, String line) {
		
		if(cnt==N) {
			sum+= (num*op);
			if(sum==0) {
				sb.append(line+"\n");
			}
			return;
		}
		
		dfs(cnt+1, num*10+(cnt+1),sum,op,line+" "+(cnt+1));
		dfs(cnt+1, cnt+1, sum+(num*op), 1, line+"+"+(cnt+1));
		dfs(cnt+1, cnt+1, sum+(num*op), -1, line+"-"+(cnt+1));
	}

	
}
