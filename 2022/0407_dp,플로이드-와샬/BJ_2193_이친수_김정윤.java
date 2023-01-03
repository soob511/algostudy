package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2193_이친수_김정윤 {

	public static void main(String[] args) throws IOException {
		/*
		 * <이친수>
		 * 1. 0으로 시작하지 않음
		 * 2. 1이 두 번 연속으로 나타나지 않음
		 * 
		 * * output : N자리 이친수의 개수 (1<=N<=90)
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 	// N자리 이친수의 개수
		
		// d[n] = n자리 이진수
		long d[] = new long[N+1];
		
		d[0] = 0;
		d[1] = 1;
		for(int i=2; i<=N; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		System.out.println(d[N]);
	}

}
