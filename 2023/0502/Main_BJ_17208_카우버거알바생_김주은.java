import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17208_카우버거알바생_김주은 {
	
	static int N,M,K;
	static int[][] list;
	static int[][][] dp;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0]=Integer.parseInt(st.nextToken());
			list[i][1]=Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][M+1][K+1];
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=M;j++) {
				for(int k=0;k<=K;k++) {
					dp[i][j][k]=-1;
				}
			}
		}
		
		System.out.println(knapsack(0,M,K));
		
	}
	
	public static int knapsack(int idx, int cb, int ff) {
		
		if(idx==N) {
			return 0;
		}
		if(dp[idx][cb][ff]>=0) {
			return dp[idx][cb][ff];
		}
		if(list[idx][0]<=cb && list[idx][1]<=ff) {
			dp[idx][cb][ff] = knapsack(idx+1,cb-list[idx][0], ff-list[idx][1])+1;
		}
		dp[idx][cb][ff] = Math.max(dp[idx][cb][ff], knapsack(idx+1,cb,ff));
		
		
		return dp[idx][cb][ff];
		
		
		
		
	}

}
