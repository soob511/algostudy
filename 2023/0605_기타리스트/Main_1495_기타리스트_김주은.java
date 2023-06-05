import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1495_기타리스트_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] vol = new int[N+1];
		boolean[][] dp = new boolean[N+1][M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			vol[i]=Integer.parseInt(st.nextToken());
		}
		
		dp[0][S]=true;

		for(int i=1;i<=N;i++) {
			for(int j=0;j<M+1;j++) {
				if(dp[i-1][j]==true) {
					if(j+vol[i]<=M) {
						dp[i][j+vol[i]]=true;
					}
					if(j-vol[i]>=0) {
						dp[i][j-vol[i]]=true;
					}
				}
			}
		}
		
		for(int i=M;i>=0;i--) {
			if(dp[N][i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
		
 	}



}
