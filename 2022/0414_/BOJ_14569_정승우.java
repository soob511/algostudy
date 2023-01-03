package com.ssafy.day0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14569_정승우 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//총 과목 수
		int n  = Integer.parseInt(br.readLine());
		
		//과목 배열
		long[] subject = new long[n];
		for(int i=0; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//수업시간 수
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				//각 수업시간
				int t = Integer.parseInt(st.nextToken());
				subject[i] |= (1L << t);
			}
		}
		
		//학생 수
		int m = Integer.parseInt(br.readLine());
		
		//학생 배열
		long[] student = new long[m];
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//비어있는 교시 수
			int p = Integer.parseInt(st.nextToken());
			for(int j=0; j<p; j++) {
				//각 비어있는 교시
				int q = Integer.parseInt(st.nextToken());
				student[i] |= (1L<< q);
			}
		}
		
		for(int i=0; i<m; i++) {
			int cnt = 0;
			for (int j=0; j<n; j++) {
				//학생이 들을수 있는 과목이 있을때마다 cnt를 +해줌
				if((student[i]|subject[j]) == student[i]) cnt++;
			}
			System.out.println(cnt);
		}
		
	
	}

}
