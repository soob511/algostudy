package com.ssafy.day0222;

import java.util.Scanner;

public class BOJ_2477_정승우 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int length[] = new int[6];
		
		for (int i=0; i<6; i++) {
			sc.nextInt();
			length[i] = sc.nextInt();
			
		}
		
		int max =0;
		int idx =0;
		for (int i=0; i<6; i++) {
			//연속하는 두 수중 가장 큰 값이 전체의 가로,세로
			if (max<length[i]*length[(i+1)%6]) {
				max = length[i]*length[((i+1)%6)];
				idx=i;
			}
		}
		// 160, 30, 60, 20, 100, 50     i = 2, 3

		//전체 가로세로에서 3,4번째 뒤 인덱스는 작은 가로세로(작은 가로세로는 면적에 포함
		//되지 않기때문에 전체 면적에서 작은 면적을 뺌)
		max = max - length[(idx+3)%6]*length[(idx+4)%6];
		System.out.println(max*K);
	}

}
