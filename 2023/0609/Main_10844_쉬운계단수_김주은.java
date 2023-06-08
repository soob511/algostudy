import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_10844_쉬운계단수_김주은 {
	
	static int N;
	static long[][] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new long[N+1][10];
		
		Arrays.fill(dp[1], 1);
		dp[1][0]=0;
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					dp[i][j]+=dp[i-1][j+1];
				} else if(1<=j && j<=8) {
					dp[i][j]+=dp[i-1][j-1];
					dp[i][j]+=dp[i-1][j+1];
				} else if(j==9) {
					dp[i][j]+=dp[i-1][j-1];
				}
				dp[i][j]%=1000000000;
			}
		}
		
		long answer = 0;
		for(int i=0;i<10;i++) {
			answer+=dp[N][i];
		}
		
		System.out.println(answer%1000000000);
	}


}
