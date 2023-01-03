package com.ssafy.add.d0315;

import java.io.*;
import java.util.*;

public class Main_BJ_17070_파이프옮기기1_김주은 {
	
	static class Pipe{
		int state; //0:가로, 1:대각선, 2:세로
		int r;
		int c;
		
		public Pipe(int state, int r, int c) {
			super();
			this.state = state;
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] wall;
	static int cnt=0;
	static int[] dr, dc;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		wall = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//이동 방향{가로이동, 대각선 이동, 세로 이동}
		dr = new int[]{0, 1, 1};
		dc = new int[]{1, 1, 0};
		
		search(new Pipe(0,0,1));
		
		System.out.println(cnt==0?0:cnt);
	}
	
	static void search(Pipe p) {
		
		if(p.r == N-1 && p.c==N-1) {
			++cnt;
			return;
		}
		
		int nextr=p.r+1;
		int nextc=p.c+1;
		
		Pipe t = p;
		if(p.state==0) { //가로 상태
			if(nextc<N && wall[p.r][nextc]==0) { //가로 이동
				t.c=nextc;
				search(t);
			}
			t=p;
			if(nextr<N && nextc<N && wall[nextr][p.c]==0 && wall[p.r][nextc]==0 && wall[nextr][nextc]==0) { //대각선 이동
				t.state=1;
				t.r=nextr;
				t.c=nextc;
				search(t);
			}
		}
		t=p;
		if(p.state==1) { //대각선 상태
			if(nextc<N && wall[p.r][nextc]==0) { //가로 이동
				t.state=0;
				t.c=nextc;
				search(t);
			}
			t=p;
			if(nextr<N && nextc<N && wall[nextr][p.c]==0 && wall[p.r][nextc]==0 && wall[nextr][nextc]==0) { //대각선 이동
				t.r=nextr;
				t.c=nextc;
				search(t);
			}
			t=p;
			if(nextr<N && wall[nextr][p.c]==0) { //세로 이동
				t.state=2;
				t.r=nextr;
				search(t);
			}
		}
		t=p;
		if(p.state==2) { //세로 상태
			if(nextr<N && nextc<N && wall[nextr][p.c]==0 && wall[p.r][nextc]==0 && wall[nextr][nextc]==0) { //대각선 이동
				t.state=1;
				t.r=nextr;
				t.c=nextc;
				search(t);
			}
			t=p;
			if(nextr<N && wall[nextr][p.c]==0) { //세로 이동
				t.r=nextr;
				search(t);
			}
		}
		
	}
}
