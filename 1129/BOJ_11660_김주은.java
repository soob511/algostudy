import java.io.*;
import java.util.*;

public class Main_BJ_11660_구간합구하기5_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		int[][] map = new int[N+1][N+1];
//		
//		for(int i=1;i<=N;i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=1;j<=N;j++) {
//				int val = Integer.parseInt(st.nextToken());
//				if(j==1) {
//					map[i][j]=val;
//				} else {
//					map[i][j]=map[i][j-1]+val;
//				}
//			}
//		}	
//		
//		for(int m=0;m<M;m++) {
//			st = new StringTokenizer(br.readLine());
//			int x1 = Integer.parseInt(st.nextToken());
//			int y1 = Integer.parseInt(st.nextToken());
//			int x2 = Integer.parseInt(st.nextToken());
//			int y2 = Integer.parseInt(st.nextToken());
//			
//			int ans = 0;
//			
//			for(int i=x1;i<=x2;i++) {
//				ans += map[i][y2] - map[i][y1-1];
//			}
//			sb.append(ans).append("\n");
//		}
		
		int[][] dp = new int[N+1][N+1];
		int[] arr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int val = Integer.parseInt(st.nextToken());
				if(j==1) {
					arr[j]=val;
				} else {
					arr[j]=arr[j-1]+val;
				}
				dp[i][j]=dp[i-1][j]+arr[j];
			}
		}
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int ans = dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];

			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

}
