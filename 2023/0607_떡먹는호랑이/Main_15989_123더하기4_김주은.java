import java.util.Scanner;

public class Main_BJ_15989_123더하기4_김주은 {
	
	static int[][] dp = new int[10001][4];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		dp[1][1]=1;
		dp[2][1]=1;
		dp[2][2]=1;
		dp[3][1]=1;
		dp[3][2]=1;
		dp[3][3]=1;
		
		for(int i=4;i<=10000;i++) {
			dp[i][1]=1;
			dp[i][2]=dp[i-2][1]+dp[i-2][2];
			dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
		}
		
		
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			sb.append(dp[n][1]+dp[n][2]+dp[n][3]).append("\n");
		}
		
		System.out.println(sb);
	}

}
