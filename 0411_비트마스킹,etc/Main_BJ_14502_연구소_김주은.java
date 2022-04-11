package com.ssafy.d0408;

import java.io.*;
import java.util.*;

public class Main_BJ_14502_연구소_김주은 {
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N, M, zeroCnt, answer;
	static int[][] map;
	static ArrayList<Node> nodelist;
	static LinkedList<Node> virusQueue;
	static Node[] arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer=0;
		
		map = new int[N][M];
		nodelist = new ArrayList<Node>();
		zeroCnt=0;
		
		virusQueue = new LinkedList<Node>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					nodelist.add(new Node(i,j));
					++zeroCnt;
				}
			}
		}
		
		arr = new Node[3];
		combination(0,0);
		
		System.out.println(answer);
	}
	
	static void combination(int cnt, int start) {
		
		if(cnt==3) {
			int[][] copymap = new int[N][M];
			for(int i=0;i<N;i++) {
				copymap[i] = map[i].clone();
			}
			for(int i=0;i<3;i++) {
				copymap[arr[i].x][arr[i].y]=1;
			}
			checkSafeArea(copymap);
			return;
		}
		
		for(int i=start;i<zeroCnt;i++) {
			arr[cnt]=nodelist.get(i);
			combination(cnt+1, i+1);
		}
		
	}
	
	static void checkSafeArea(int[][] cmap) {
		
		int[] dr = new int[] {0, 1, 0, -1};
		int[] dc = new int[] {1, 0, -1, 0};
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
					virusQueue.add(new Node(i,j));
				}
			}
		}
		
		while(!virusQueue.isEmpty()) {
			
			Node n = virusQueue.poll();
			int r=n.x;
			int c=n.y;
			cmap[r][c]=2;
			
			for(int d=0;d<4;d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || cmap[nr][nc]!=0) continue;
				
				virusQueue.add(new Node(nr, nc));
			}
			
		}
		
		//안전영역 갯수 세기
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(cmap[i][j]==0) ++count;
			}
		}
		answer = Math.max(answer, count);
	}
	

}
