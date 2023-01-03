package com.ssafy.add.d0224;

import java.util.*;
import java.io.*;

public class Main_BJ_10157_자리배정_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//우, 하, 좌, 상
		int[] dr = { 0, 1, 0, -1};
		int[] dc = { 1, 0, -1, 0};

		int C = Integer.parseInt(st.nextToken()); //가로 수
		int R = Integer.parseInt(st.nextToken()); //세로 수
		int S = Integer.parseInt(br.readLine());

		boolean[][] map = new boolean[R+1][C+1];
		
		if(S<=R*C) {
			// 시작 초기위치 좌표
			int x = 1;
			int y = 1;
			int cnt = 1; // S까지 증가할 숫자
			int d = 0; //방향 전환용 변수

			map[x][y]=true; // 첫칸(1,1)은 먼저 방문
			while (cnt < S) {

				//다음 값 방문해본다
				int tempx = x + dr[d];
				int tempy = y + dc[d];
				//다음 방문값이 코너라면 방향 전환
				if (tempx < 1 || tempx > R || tempy < 1 || tempy > C || map[tempx][tempy]) {
					d = (++d) % 4;
				}
				//좌표 이동
				x += dr[d];
				y += dc[d];
				map[x][y]=true;
				
				++cnt;
			}
			
			System.out.println(x+" "+y);
			
		}else {
			System.out.println(0);
		}

		

	}

}
