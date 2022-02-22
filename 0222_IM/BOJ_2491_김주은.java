package com.ssafy.add.d0222;

import java.util.*;
import java.io.*;

public class Main_BJ_2491_수열_김주은 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		st = new StringTokenizer(br.readLine());
		//list에 모든 수열 저장
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int max=1; //최대 길이 저장
		
		//1. 오름차순으로 길이 확인
		int uplen=1; // 하나의 연속길이를 저장
		for(int i=1;i<N;i++) {
			if(list[i-1] <= list[i]) {
				++uplen;
				if(max<uplen) max=uplen; // 최대길이 보다 클 경우 저장
			}
			else {
				uplen=1;
			}
		}
		//1. 내림차순으로 길이 확인
		int downlen=1;
		for(int i=1;i<N;i++) {
			if(list[i-1] >= list[i]) {
				++downlen;
				if(max<downlen) max=downlen; // 최대길이 보다 클 경우 저장
			}
			else {
				downlen=1;
			}
		}
		
		System.out.println(max);
	}

}
