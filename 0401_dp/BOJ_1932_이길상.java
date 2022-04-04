package day0405;
import java.io.*;
import java.util.*;

public class BOJ_1932_이길상 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 삼각형 크기
		int N = Integer.parseInt(br.readLine());
		
		// 삼각형
		int[][] triangle = new int[N][];
		// 첫번째 층 입력
		triangle[0] = new int[] {Integer.parseInt(br.readLine())};

		// 두번째 층부터 반복문
		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			// 층 초기 설정
			st = new StringTokenizer(br.readLine());
			triangle[i] = new int[i+1];
			
			//첫번째 수 - 중간 - 마지막 수로 구분하여 처리
			triangle[i][0] = triangle[i-1][0] + Integer.parseInt(st.nextToken());
			for (int j = 1; j < i; j++) {
				triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + Integer.parseInt(st.nextToken());
			}
			triangle[i][i] = triangle[i-1][i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 최대 합 구하기
		int maxsum = 0;
		for (int i = 0; i < N; i++) {
			maxsum = Math.max(triangle[N-1][i], maxsum);
		}
		
		System.out.println(maxsum);
    }

}
