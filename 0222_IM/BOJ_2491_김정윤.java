package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491_김정윤 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 수열의 길이
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] Array = new int[N];
		for(int i=0; i<N; i++) {	// 수열 입력
			Array[i] = Integer.parseInt(st.nextToken());
		}
		
		int cntIn = 1, cntDe = 1;
		int maxLength = 0;
		for(int i=0; i<N-1; i++) {	// 수열을 순서대로 읽으면서
			// 연속해서 커지는 경우 (같은 것 포함)
			if(Array[i]<=Array[i+1]) cntIn++;
			else cntIn = 1;
			maxLength = Math.max(maxLength, cntIn);	// 수열 중 조건 만족하는 최대 길이 수열 찾기	
		}
		
		for(int i=0; i<N-1; i++) {	// 수열을 순서대로 읽으면서
			// 연속해서 작아지는 경우 (같은 것 포함)
			if(Array[i]>=Array[i+1]) cntDe++;
			else cntDe = 1;
			maxLength = Math.max(maxLength, cntDe);	// 수열 중 조건 만족하는 최대 길이 수열 찾기
		}
		
		// 결과 출력
		System.out.print(maxLength);
	}
}
