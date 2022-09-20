package com.bj;

import java.io.*;
import java.util.*;

public class Main_BJ_14499_주사위굴리기_김주은 {

	// 동, 서, 북, 남
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	
	static int bottom = 6;
	static int east = 3;
	static int north = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[] dice = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시작 위치에서 값 이동
		if (map[X][Y] == 0) {
			map[X][Y] = dice[bottom];
		} else {
			dice[bottom] = map[X][Y];
			map[X][Y] = 0;
		}

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int dir = Integer.parseInt(st.nextToken());

			int nX = X + dr[dir - 1];
			int nY = Y + dc[dir - 1];

			if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
				sb.append(7-bottom);
				continue;
			}
				

			findNextBottom(dir); //주사위 방향대로 굴리기

			sb.append(7 - bottom).append("\n"); // 굴린 후 top 구하기

			if (map[nX][nY] == 0) {
				map[nX][nY] = dice[bottom];
			} else {
				dice[bottom] = map[nX][nY];
				map[nX][nY] = 0;
			}

		}

		System.out.println(sb.toString());
	}

	private static void findNextBottom(int dir) {
		
		int prevBottom = bottom;
		int prevTop = 7-bottom;
		int prevNorth = north;
		int prevSouth = 7-north;
		int prevEast = east;
		int prevWest = 7-east;
		
		if(dir==1) {
			bottom = prevEast;
			east = prevTop;
		} else if(dir==2) {
			bottom = prevWest;
			east = prevBottom;
		} else if(dir==3) {
			bottom = prevNorth;
			north = prevTop;
		} else if(dir==4) {
			bottom = prevSouth;
			north = prevBottom;
		}
		
	}

}
