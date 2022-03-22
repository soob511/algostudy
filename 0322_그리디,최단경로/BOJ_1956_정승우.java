package com.ssafy.day0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1956_정승우 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 마을 수
		int v = Integer.parseInt(st.nextToken()); 
		// 도로 수
		int e = Integer.parseInt(st.nextToken());  
		// 마을 개수만큼 가중치 그래프 생성
		int[][] graph = new int[v][v]; 
		for (int i = 0; i < v; i++)
			for (int j=0; j<v; j++) {
				//가중치 초기화
				graph[i][j]=5000000;
			}
		
		// 그래프,가중치 입력
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()); 
			int v2 = Integer.parseInt(st.nextToken()); 
			graph[v1 - 1][v2 - 1] = Integer.parseInt(st.nextToken());
		}

		//  최단경로 구하기
		for (int k = 0; k < v; k++)
			for (int i = 0; i < v; i++)
				for (int j = 0; j < v; j++)
					graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);

		// 최단경로 사이클 찾기
		int small = 5000000;
		for (int i = 0; i < v; i++)
			for (int j = 0; j < v; j++)
				small = Math.min(graph[i][j] + graph[j][i], small);

		if (small<5000000) System.out.println(small);
		else System.out.println(-1);
		
	}

}