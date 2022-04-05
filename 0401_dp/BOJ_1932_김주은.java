package com.ssafy.add.d0405;

import java.io.*;
import java.util.*;

public class Main_BJ_1932_정수삼각형_김주은 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] samgak = new int[N][N];
		int[][] DP = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				samgak[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max=samgak[0][0];
		
		DP[0][0]=samgak[0][0];
		for(int i=1;i<N;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) { //삼각현 왼쪽 변
					DP[i][j]=DP[i-1][j];
				}
				else if(j==i) { //삼각형 오른쪽 변
					DP[i][j]=DP[i-1][j-1];
				} else { //중간
					DP[i][j]=Math.max(DP[i-1][j-1], DP[i-1][j]);
				}
				
				DP[i][j]+=samgak[i][j];
				
				if(max<DP[i][j]) max=DP[i][j];
			}
		}
		
		System.out.println(max);
	}

}
