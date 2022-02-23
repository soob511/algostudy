package com.ssafy.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10157_정승우 {

	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		//배열을 90도 돌린것을 생각해서 R,C의 배열 크기를 바꿔서 넣어줘야함
		int[][] map = new int[C][R];
		int dir = 0;
		int r=0,c=0;
		boolean ischeck =false;
		
		for (int num=1; num<=(R*C); num++) {
			//값 채우기(1~)
			map[r][c] = num;
			
			//다음 위치 좌표 체크
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			
			//경계값 체크
			if (!(nr >=0 && nr<C && nc>=0 && nc<R &&map[nr][nc]==0)) {
				//방향전환
				//다시 값을 앞에서부터 받아오기 위함
				dir = ++dir%4;
			}
			
			//실질적으로 값을 바꿔줌
			r +=dr[dir];
			c +=dc[dir];
			
			
		}
		
		
		for (int i=0; i<C; i++) {
			for (int j=0; j<R; j++) {
				if (map[i][j]==k) {
					//k값이 있을경우 true
					ischeck = true;
					System.out.println((i+1)+" "+(j+1));
				} 
				
			}
		}
		//map에 k값이 없어서 ischeck가 false이고 0을 출력
		if (!ischeck) System.out.println(0);
		
		
		
	}

}
