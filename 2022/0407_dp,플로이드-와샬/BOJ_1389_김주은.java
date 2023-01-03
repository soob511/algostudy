package com.ssafy.add.d0407;

import java.io.*;
import java.util.*;

public class Main_BJ_1389_케빈베이컨의6단계법칙_김주은 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int INF = 5001;
		
		int[][] map	= new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) map[i][j]=0;
				else map[i][j]=INF;
			}
		}
		
		//간선 입력
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a-1][b-1]=map[b-1][a-1]=1;
		}
		
		//플로이드 와샬
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int minVal=Integer.MAX_VALUE;
		int minPerson=-1;
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<N;j++) {
				sum+=map[i][j];
			}
			if(sum<minVal) {
				minVal = sum;
				minPerson=i;
			}
		}
		
		System.out.println(minPerson+1);

	}

}
