import java.util.Scanner;

public class Main_BJ_1823_수확_김주은 {
	
	static int N;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		dp = new int[N][N];
		
		dfs(0,N-1,1);
		
		System.out.println(dp[0][N-1]);
	}

	private static int dfs(int start, int end, int cnt) {
		

		if(start==end) {
			dp[start][end]=arr[start]*cnt;
			return arr[start]*cnt;
		}
		
		if(dp[start][end]==0) {
			dp[start][end]= Math.max(dfs(start+1,end,cnt+1)+arr[start]*cnt, dfs(start,end-1,cnt+1)+arr[end]*cnt);
		}
		
		return dp[start][end];
		
	}

}
