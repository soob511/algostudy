package com.ssafy.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_정승우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//각 계단의 점수 배열
		int[] stair = new int[n+1];
		for(int i=1; i<n+1; i++) {
			stair[i]  = Integer.parseInt(br.readLine());
		}
	
		//n번째 개단의 최대값을 저장할 배열
		int[] d = new int[n+1];
		//1계단의 경우의수는 1이므로 1번째 계단 점수 d[1]에 저장
		if(n==1) d[1] = stair[1];
		//2계단은 1,2계단 더한 점수가 최대값이므로 더한점수 d[2]배열에 저장
		else if(n==2) d[2] = stair[2] + stair[1];
		//3인경우
		else {
			d[1] = stair[1];
			d[2] = stair[2] + stair[1];
			//1,3과 2,3의 계단 점수를 더한 값중 최대값을 d[3]에 저장
			d[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
			
			for(int i=4; i<n+1; i++) {
				// 두 계단 + 한 계단 오른 경우와 한 번에 두 계단 오른 경우를 비교하여 최대값을 d[i]번째 저장 
				d[i] = Math.max(d[i-3] + stair[i] + stair[i-1], d[i-2] + stair[i]);
			}
		}
		System.out.println(d[n]);
		System.out.println(Arrays.toString(d));
	}
}