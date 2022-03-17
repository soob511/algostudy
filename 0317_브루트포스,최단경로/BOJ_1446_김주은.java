package com.ssafy.add.d0317;

import java.io.*;
import java.util.*;

public class Main_BJ_1446_지름길_김주은 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[D][D+1]; 
		//i->j로 가는 거리 저장하는 인접행렬
		for(int i=0;i<D;i++) { 
			for(int j=i+1;j<=D;j++) {
				map[i][j] = j-i;
			}
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			if(start<D && end<=D && map[start][end]>dist) {				
				map[start][end]=dist;
			}
		}
		
		//dijkstra
		
		for(int i=1;i<=D;i++) {
			for(int j=1;j<i;j++) {
				if(map[0][j]+map[j][i]<map[0][i]) {
					map[0][i]=map[0][j]+map[j][i];
				}
			}
		}
		System.out.println(map[0][D]);
		
	
	}

}
