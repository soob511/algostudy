package com.ssafy.day0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;



public class BOJ_17144_정승우 {

	
	//아래방향 공기청정기
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	//윗방향 공기청정기
	static int[] dr2 = {0,-1,0,1};
	static int[] dc2 = {1,0,-1,0};
	
	static boolean[][] check;
	static int r,c,t;
	static int ar1, ac1, ar2, ac2;
	static int[][] map;
	static int[][] map2;
	static int[] aircleaner = new int[4];
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		t= Integer.parseInt(st.nextToken());
		
		
		map= new int[r][c];
		map2 = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int tc=0; tc<t; tc++) {
			for(int i=0; i<r; i++) {
				for (int j=0; j<c; j++) {
					if(map[i][j]==-1) {
						int count=0;
						ar1=i;
						ac1=j;
						count++;
						if(count==1) {
							ar2=i;
							ac2=j;
						}
					}
					if(map[i][j]==0) continue;
					else {
						int cnt=0;
						for(int d=0; d<4; d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
							if(nr>=0&&nr<r&&nc>=0&&nc<c&&map[nr][nc]!=-1) {
								cnt++;
							}
						}
						for(int d=0; d<4; d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
							if(nr>=0&&nr<r&&nc>=0&&nc<c&&map[nr][nc]!=-1) {
								map2[nr][nc]+=map[i][j]/5;
								
							}
						}
						map[i][j] = map[i][j]-(map[i][j]/5)*cnt;
					}
				}
			}
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(map[i][j]==-1) {
						continue;
					} else {
						map[i][j]+=map2[i][j];
					}
				}
			}

			int move_r = ar1;
			int move_c = ac1;
			int tmp=0;
			check = new boolean[r][c];
			while(true) {
				for (int d=0; d<4; d++) {
					int nr = ar1+dr[d];
					int nc = ac1+dc[d];
					if(map[nr][nc]==-1) {
						return;
					}
					if(nr>=0&&nr<r&&nc>=0&&nc<c&&check[nr][nc]==false) {
						check[move_r][move_c]=true;
						if(map[move_r][move_c]==-1) continue;
						
						ar1=nr;
						ac1=nc;
						
					}
				}
			}
			
			
		}
		
		
	}

}
