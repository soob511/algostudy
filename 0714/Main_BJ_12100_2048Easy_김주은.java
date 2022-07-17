package com.bj;

import java.util.*;
import java.io.*;

public class Main_BJ_12100_2048Easy_김주은 {

	static int max = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());// N칸

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		search(0, N, map);

		System.out.println(max);

	}

	private static void search(int i, int N, int[][] map) {

		if (i == 5) {
			// 가장 큰 블록 찾기
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (map[x][y] > max) {
						max = map[x][y];
					}
				}
			}
			return;
		}

		for (int m = 0; m < 4; m++) {
			//기존 map 복사
			int[][] newmap = new int[N][N];
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					newmap[x][y]=map[x][y];
				}
			}
			search(i + 1, N, move(m, i, N, newmap));
		}
	}

	private static int[][] move(int m, int g, int N, int[][] map) {
		
		if (m == 0) {// 위쪽으로 이동
			// 1. 숫자 더하기
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] > 0) {
						int val = map[i][j];
						int tmp = i + 1;
						while (tmp < N) {
							if (map[tmp][j] > 0) {
								if (map[tmp][j] == val) {
									map[tmp][j] = 0;
									map[i][j] = val * 2;
									i = tmp;
									break;
								} else {
									i = tmp - 1; // 다음 숫자부터 검색
									break;
								}
							}
							++tmp;
						}
					}
				}
			}
			// 2. 위로 밀기
			for (int j = 0; j < N; j++) {
				int mvpoint = 0;
				for (int i = 0; i < N; i++) {
					if (map[i][j] > 0) {
						int val = map[i][j];
						map[i][j] = 0;
						map[mvpoint++][j] = val;
					}
				}
			}
		} else if (m == 1) {// 왼쪽으로 이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0) {
						int val = map[i][j];
						int tmp = j + 1;
						while (tmp < N) {
							if (map[i][tmp] > 0) {
								if (map[i][tmp] == val) {
									map[i][tmp] = 0;
									map[i][j] = val * 2;
									j = tmp;
									break;
								} else {
									j = tmp - 1;
									break;
								}
							}
							++tmp;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				int mvpoint = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0) {
						int val = map[i][j];
						map[i][j] = 0;
						map[i][mvpoint++] = val;
					}
				}
			}
		} else if (m == 2) {// 아래쪽으로 이동
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] > 0) {
						int val = map[i][j];
						int tmp = i - 1;
						while (tmp >= 0) {
							if (map[tmp][j] > 0) {
								if (map[tmp][j] == val) {
									map[tmp][j] = 0;
									map[i][j] = val * 2;
									i = tmp;
									break;
								} else {
									i = tmp + 1;
									break;
								}
							}
							--tmp;
						}
					}
				}
			}
			for (int j = 0; j < N; j++) {
				int mvpoint = N - 1;
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] > 0) {
						int val = map[i][j];
						map[i][j] = 0;
						map[mvpoint--][j] = val;
					}
				}
			}
		} else {// 오른쪽으로 이동
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] > 0) {
						int val = map[i][j];
						int tmp = j - 1;
						while (tmp >= 0) {
							if (map[i][tmp] > 0) {
								if (map[i][tmp] == val) {
									map[i][tmp] = 0;
									map[i][j] = val * 2;
									j = tmp;
									break;
								} else {
									j = tmp + 1;
									break;
								}
							}
							--tmp;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				int mvpoint = N-1;
				for (int j = N - 1; j >= 0; j--) {
					if(map[i][j]>0) {
						int val = map[i][j];
						map[i][j]=0;
						map[i][mvpoint--]=val;
					}
				}
			}
		}
		
		return map;
	}

}
