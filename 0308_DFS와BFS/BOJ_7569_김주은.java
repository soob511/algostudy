package com.ssafy.add.d0308;

import java.util.*;
import java.io.*;

public class Main_BJ_7569_토마토_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 행
		int N = Integer.parseInt(st.nextToken()); // 열
		int H = Integer.parseInt(st.nextToken()); // 높이

		int[][][] box = new int[H][N][M];
		// 입력받기
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		int zero = 0; // 0의 갯수
		int cnt = 1; //토마토 모두 익을때까지 걸리는 일 수 

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[h][i][j] == 1) {
						queue.add(new int[] { h, i, j });
					}
					else if (box[h][i][j] == 0) {
						++zero;
					}

				}
			}
		}

		int[] dh = new int[] { 1, -1, 0, 0, 0, 0 };
		int[] dx = new int[] { 0, 0, -1, 0, 1, 0 };
		int[] dy = new int[] { 0, 0, 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			
			int[] val = queue.poll();

			for (int d = 0; d < 6; d++) {

				int newh = val[0] + dh[d];
				int newx = val[1] + dx[d];
				int newy = val[2] + dy[d];

				if (newh >= 0 && newh < H && newx >= 0 && newx < N && newy >= 0 && newy < M && box[newh][newx][newy] == 0) {
					box[newh][newx][newy] = box[val[0]][val[1]][val[2]] + 1;
					cnt=box[newh][newx][newy];
					queue.add(new int[] { newh, newx, newy });
					--zero;
				}

			}
		}

		System.out.println(zero > 0 ? -1 : cnt-1);

	}

}
