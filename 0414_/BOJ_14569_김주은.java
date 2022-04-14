package com.ssafy.add.d0414;

import java.io.*;
import java.util.*;

public class Main_BJ_14569_시간표짜기_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[] classes = new long[N]; //수업 시간표
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++) {
				int val = Integer.parseInt(st.nextToken());
				//class[i]에 수업 시간표 저장
				classes[i] |= (1<<(val-1));
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		long[] student = new long[M]; //학생 시간표
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j=0;j<m;j++) {
				int val = Integer.parseInt(st.nextToken());
				//student[i]에 학생이 가능한 시간표 저장
				student[i] |= (1<<(val-1));
			}
		}
		
		
		//i번째 학생이 들을 수 있는 수업 갯수 세기
		for(int i=0;i<M;i++) {
			int count=0;
			for(int j=0;j<N;j++) {
				//학생 시간표
				if((student[i] & classes[j]) == classes[j]) ++count;
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
