package com.ssafy.add.d0215;

import java.io.*;
import java.util.*;

public class boj_2606_바이러스_김주은 {
	static int[][] network;
	static boolean[] visited;
	static int M;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수		
		M = Integer.parseInt(br.readLine()); //연결된 컴퓨터 쌍 수 
		
		network = new int[M][2];
		visited = new boolean[N+1];
		int cnt=0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			network[i][0] = Integer.parseInt(st.nextToken()); //문서의 개수
			network[i][1] = Integer.parseInt(st.nextToken()); //몇번째로 인쇄되었는지 궁금한 문서가 현재 큐에서 몇번째에 놓여있는지
		}
		visited[1]=true;
		dfs(1); //시작 숫자
		
		for(int i=2;i<=N;i++) {
			if(visited[i]) ++cnt;
		}
		System.out.println(cnt);
	}
	
	static void dfs (int n) {	
		for(int i=0;i<M;i++) {
			//0번째 열 값이 n일 경우
			if(network[i][0]==n) {
				//옆 값을 이미 방문했을 때 continue
				if(visited[network[i][1]]) continue;
				//아직 방문 전이면 true로 바꾸고 재귀 호출
				visited[network[i][1]]=true;
				dfs(network[i][1]);
			}
			//1번째 열값이 n일 경우
			else if(network[i][1]==n) {
				//옆 값을 이미 방문했을 때 continue
				if(visited[network[i][0]]) continue;
				//아직 방문 전이면 true로 바꾸고 재귀 호출
				visited[network[i][0]]=true;
				dfs(network[i][0]);
			}
		}
	}

}
