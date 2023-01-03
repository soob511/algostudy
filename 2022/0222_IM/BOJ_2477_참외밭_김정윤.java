package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭_김정윤 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());	// 1m2의 넓이에서 자라는 참외의 개수
		StringTokenizer st;
		
		// 입력
		int[][] map = new int[6][2];	 // 참외밭
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 참외밭의 넓이 구하기
		// 큰 직사각형 넓이 구하기
		int max = 0, max2 = 0;
		for(int i=0; i<6; i++) {
			// 가로와 세로 최대 길이 구하기
			if(map[i][0]==1 || map[i][0]==2) {
				max = Math.max(map[i][1], max);
			}
			if(map[i][0]==3 || map[i][0]==4) {
				max2 = Math.max(map[i][1], max2);
			}
		}
		int bigSq = max * max2;
		
		// 작은 직사각형 넓이 구하기
		int smallSq = 0;
		for(int i=1; i<6; i++) {	
			if((map[i-1][0]==1&&map[i][0]==3) || (map[i-1][0]==3&&map[i][0]==2)	// 꺾이는 부분인지 확인
					|| (map[i-1][0]==2&&map[i-1][0]==4) || (map[i-1][0]==4&&map[i-1][0]==1)) {
				smallSq = map[i-1][1] * map[i][1];
			}
		}
		if((map[5][0]==1&&map[0][0]==3) || (map[5][0]==3&&map[0][0]==2) 
				|| (map[5][0]==2&&map[0][0]==4) || (map[5][0]==4&&map[0][0]==1)) {
			smallSq = map[5][1] * map[0][1];
		}
		
		// 결과 출력
		System.out.print((bigSq-smallSq)*K);
	}
}
