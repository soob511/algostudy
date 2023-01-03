package com.ssafy.day0222;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2578_정승우 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//철수 빙고
		int[][] player = new int[5][5];
		
		//불러줄 번호
		int[] answer = new int [25];
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				player[i][j]=sc.nextInt();
			}
		}
		
		for (int i=0; i<25; i++) {
			answer[i] = sc.nextInt();
		}

		int cnt=0;
		//cnt : answer[]에 있는 값들을 불러주기 위한 인덱스 값
		outer : while(cnt!=25) {
			for (int i=0; i<5; i++) {
				for (int j=0; j<5; j++) {
					//불러줄 번호가 철수의 빙고판에 있다면 해당 번호를 0으로 바꿈
					if (answer[cnt]==player[i][j]) {
						player[i][j] =0;
					}
					int total =0;
					if(player[i][0]==0&&player[i][1]==0&&player[i][2]==0&&player[i][3]==0&&player[i][4]==0) {
						total++;
					}
					if(player[0][j]==0&&player[1][j]==0&&player[2][j]==0&&player[3][j]==0&&player[4][j]==0) {
						total++;
					}
					if(player[0][0]==0&&player[1][1]==0&&player[2][2]==0&&player[3][3]==0&&player[4][4]==0) {
						total++;
					}
					if(player[4][0]==0&&player[3][1]==0&&player[2][2]==0&&player[1][3]==0&&player[0][4]==0) {
						total++;
					}
					if(total >=3) {
						System.out.println(cnt);
						break outer;
					}
					for (int k=0; k<5; k++) {
						//가로,세로,대각선
					}
				}	
			}
			cnt++;
		}
	}
}
