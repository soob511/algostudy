package com.ssafy.add.d0322;

import java.io.*;
import java.util.*;

public class Main_BJ_1956_운동_김주은 {
	
	static int[][] adjm;
	static int V;
	static int result = -1;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjm = new int[V][V];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjm[from-1][to-1] = weight;
		}
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(adjm[i][j]!=0) {
					//해당 노드 방향으로 탐색 시작
					boolean[] visited = new boolean[V];
					visited[i]=true;
					int sum = adjm[i][j];
					search(visited, i, j, sum); //방문 관리 배열, 시작한 노드값, 다음 탐색 노드값, 거리 합
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	static void search(boolean[] visited, int start, int j, int sum) {
	
		for(int t=0;t<V;t++) {
			if(adjm[j][t]!=0) {
				
				//시작 노드에 도착 시 종료
				if(start==t) {
					sum +=adjm[j][t];
					if(result==-1) result = sum;
					else {				
						result = Math.min(result, sum);
					}
					return;
				}
				
				//이미 방문한 적이 있는 노드 재방문시 종료
				else if(visited[j]==true) {
					return;
				}
				//새로운 노드 방문
				else {
					visited[j]=true;
					sum += adjm[j][t];
					
					search(visited, start, t, sum);
				}
			}
		}
	}

}
