package study;

import java.io.*;
import java.util.*;

public class Main_2169_로봇조종하기 {
	static int n,m;
	static int[][] map;
	static int[][] dp;
	static int dx[] = {-1,1,0};
	static int dy[] = {0,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		//첫번째줄 초기화
		for(int i=1;i<m;i++) {
			dp[0][i] = map[0][i]+dp[0][i-1];
		}
	
		//두번째줄부터
		for(int i=1;i<n;i++) {
			int [] left = new int[m]; //왼쪽에서 오는것과 위에서오는것 비교
			
			left[0]=dp[i-1][0]+map[i][0];//제일 왼쪽칸 
			for(int j=1;j<m;j++) {
				left[j] = Math.max(dp[i-1][j], left[j-1])+map[i][j];
			}
			
			int [] right = new int[m]; //오른쪽에서오는것과 위에서오는것 비교

			right[m-1]=dp[i-1][m-1]+map[i][m-1];//제일 오른쪽칸
			for(int j=m-2;j>=0;j--) {
				right[j] = Math.max(dp[i-1][j], right[j+1])+map[i][j];
				
			}
			
			for(int j=0;j<m;j++) {//왼쪽에서오는것과 오른쪽에서 오는거 비교
				dp[i][j] = Math.max(left[j], right[j]);
			}
		}
		
		//for(int[] b: dp)System.out.println(Arrays.toString(b));System.out.println();
		System.out.println(dp[n-1][m-1]);
	}



}
