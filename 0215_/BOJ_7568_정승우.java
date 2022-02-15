package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568_정승우 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 2;
		int [][] arr = new int[N][M];
		int [] score = new int[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				//몸무게끼리, 키끼리 비교하며 둘다 J가 크다면 점수[i]에 1을 추가
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					score[i]++;
				}
			}
		}
		for (int i=0; i<N; i++) {
			//출력할때 점수를 1씩 증가시켜서 출력
			System.out.print(score[i]+1+" ");
		}
		
	}

}
