package com.ssafy.add.d0425;

import java.io.*;
import java.util.*;

public class Main_BJ_2169_로봇조종하기_김주은 {
	
	
	static int INF = -100000000;
	static int N,M;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		//맵 입력
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][M][3];
		//dp배열 초기화
		for(int h=0;h<3;h++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					dp[i][j][h]=INF;
				}
			}
		}
		dp[0][0][0]=dp[0][0][1]=dp[0][0][2]=map[0][0];
		
		//h:0(왼쪽에서 옴), h:1(위에서 옴), h:2(오른쪽에서 옴)
		System.out.println(Math.max(f(N-1,M-1,0), f(N-1,M-1,1)));
		
	}
	
	static int f(int i, int j, int h) {
		
		if(dp[i][j][h]!=INF) {
			return dp[i][j][h];
		}
		
		if(h==0 && dp[i][j][h]==INF) {//왼쪽에서 오는 경우
			if(j-1>=0) {
				dp[i][j][h]=Math.max(f(i,j-1,1),f(i,j-1,0))+map[i][j];
			} else {
				dp[i][j][h]=INF-1;
			}
		}
		
		if(h==1 && dp[i][j][1]==INF) {//윗쪽에서 오는 경우
			if(i-1>=0) {
				dp[i][j][h]=Math.max(Math.max(f(i-1,j,0),f(i-1,j,1)),f(i-1,j,2))+map[i][j];
			} else {
				dp[i][j][h]=INF-1;
			}
		}
		
		if(h==2 && dp[i][j][2]==INF ) {//오른쪽에서 오는 경우
			if(j+1<=M-1) {
				dp[i][j][h]=Math.max(f(i,j+1,1),f(i,j+1,2))+map[i][j];
			} else {
				dp[i][j][h]=INF-1;
			}
		}
		
		return dp[i][j][h];
	}
}
