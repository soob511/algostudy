package com.ssafy.day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_정승우 {

	static int N, cnt;
	static int col[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt =0;
		col = new int[N+1];
		setQueen(1);
		System.out.println(cnt);
	}
	
	//rowNu : 퀸을 두어야하는 현재 행
	public static void setQueen(int roNum) {
		
		//직전까지의 상황이 유망하지 않다면 리턴
		if(!isAvailable(roNum-1)) return; 

		// 기본파트 : 퀸을 모두 놓았다면
		if(roNum>N) {
			cnt++;
			return;
		}
		
		//1열부터 - n 열까지 퀸을 놓는 시도
		for (int i=1; i<=N; i++) {
			col[roNum] =i;
			setQueen(roNum+1);
		}
	}
	// rowNo : 놓아진 마지막 퀸
	public static boolean isAvailable(int rowNo) { 
		
		for (int i=1; i<rowNo; i++) {
			if(col[rowNo]== col[i] || rowNo -i == Math.abs(col[rowNo]-col[i])) return false;
		}
		return true;
	}
}
