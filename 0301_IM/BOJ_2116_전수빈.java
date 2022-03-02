package IM;

import java.io.*;
import java.util.*;

public class Main_2116_주사위쌓기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 주사위 갯수

		int[][] dice = new int[n + 1][7];

		// 입력
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int top = 0; //맨위
		int sum = 0; 
		int max = 0; 
		int result =0;
		
		for (int t = 1; t <= 6; t++) {//첫번째주사위 윗면 정하기
			top = dice[1][t];
			sum=0;
			max = 0;
			if (t == 1 || t == 6) {//윗면이 1,6이면
				for (int i = 1; i <= 6; i++) { 
					if (i != 1 && i != 6) { // 나머지면들 중에 최댓값 구하기
						max = Math.max(max, dice[1][i]);
					}
				}
			} else if (t == 2 || t == 4) {
				for (int i = 1; i <= 6; i++) {
					if (i != 2 && i != 4) {
						max = Math.max(max, dice[1][i]);

					}
				}
			} else if (t == 3 || t == 5) {
				for (int i = 1; i <= 6; i++) {
					if (i != 3 && i != 5) {
						max = Math.max(max, dice[1][i]);

					}
				}
			}
			sum += max;
			
			for (int i = 2; i <= n; i++) {//2번째 주사위부터
				max = 0;
				for (int j = 1; j <= 6; j++) {
					
					if (top == dice[i][j]) {//똑같은 숫자 겹치기
						
						if (j == 1) { // 겹친면이 1이면
							for (int k = 1; k <= 6; k++) {
								if (k != 1 && k != 6) {
									max = Math.max(max, dice[i][k]);
									top = dice[i][6]; //반대쪽면 윗면으로 바꿔주기 
								}

							}
						} else if (j == 6) {
							for (int k = 1; k <= 6; k++) {
								if (k != 1 && k != 6) {
									max = Math.max(max, dice[i][k]);
									top = dice[i][1];
								}

							}
						} else if (j == 2) {
							for (int k = 1; k <= 6; k++) {
								if (k != 2 && k != 4) {
									max = Math.max(max, dice[i][k]);
									top = dice[i][4];
								}

							}
						} else if (j == 4) {
							for (int k = 1; k <= 6; k++) {
								if (k != 2 && k != 4) {
									max = Math.max(max, dice[i][k]);
									top = dice[i][2];
								}

							}
						} else if (j == 3) {
							for (int k = 1; k <= 6; k++) {
								if (k != 3 && k != 5) {
									max = Math.max(max, dice[i][k]);
									top = dice[i][5];
								}

							}
						} else if (j == 5) {
							for (int k = 1; k <= 6; k++) {
								if (k != 3 && k != 5) {
									max = Math.max(max, dice[i][k]);
									top = dice[i][3];
								}

							}
						}
					}
				}
				
				sum += max;
			}

			result = Math.max(result,sum);
		

		}
		System.out.println(result);

	}
}
