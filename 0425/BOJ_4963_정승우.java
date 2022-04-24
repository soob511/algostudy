package com.ssafy.day0425;

import java.util.Scanner;

public class BOJ_4963_정승우 {

	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	
	static int x,y,cnt;
	static int[][] map;
	static boolean[][] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			y = sc.nextInt();
			x = sc.nextInt();
			//섬의 개수 카운트
			cnt=0;
			
			//x,y값으로 둘다 0이 들어오면 종료
			if(y==0 && x==0) System.exit(0);
			
			map = new int[x][y];
			check = new boolean[x][y];
			for(int i=0; i<x; i++) {
				for (int j=0; j<y; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<x; i++) {
				for(int j=0; j<y; j++) {
					//섬이고, 방문체크 안됐을때만 dfs하고 cnt값 증가시켜줌
					if(map[i][j]==1&&check[i][j]==false) {
						dfs(i,j);
						cnt++;
						
					}
				}
			}
			System.out.println(cnt);
		}
	}
	private static void dfs(int r, int c) {
	
		//방문체크
		check[r][c]=true;
		
		
		for(int i=0; i<8; i++) {
			int nr= r+dr[i];
			int nc= c+dc[i];
			//경계값확인, 방문체크, 육지인지 확인
			if(nr>=0&&nr<x&&nc>=0&&nc<y&&check[nr][nc]!=true&&map[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
		
		
	}

}
