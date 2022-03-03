package com.ssafy.add.d0303;

import java.io.*;
import java.util.*;

public class Main_BJ_2116_주사위쌓기_김주은 {
	static int N, max=0;
	static int[][] dice;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<6;i++) {
			search(0, dice[0][findTop(i)], 0);
		}
		
		System.out.println(max);
		
	}
	
	//주사위 바닥에 놓일 인덱스를 입력했을 때 옆면 중 최댓값을 구하기
	static int findMax(int row, int bottomIdx) {
		if(bottomIdx==0 || bottomIdx==5) return Math.max(dice[row][1], Math.max(dice[row][2], Math.max(dice[row][3], dice[row][4])));
		else if(bottomIdx==1 || bottomIdx==3) return Math.max(dice[row][0], Math.max(dice[row][2], Math.max(dice[row][4], dice[row][5])));
		else return Math.max(dice[row][0], Math.max(dice[row][1], Math.max(dice[row][3], dice[row][5])));
	}
	
	//주사위 바닥에 놓일 주사위 면 인덱스를 입력했을 때 맨 위에 놓일 주사위 면 인덱스
	static int findTop(int idx) {	
		if(idx==0) return 5;
		else if(idx==1) return 3;
		else if(idx==2) return 4;
		else if(idx==3) return 1;
		else if(idx==4) return 2;
		else return 0;
	}
	
	static void search(int cnt, int bottomValue, int sum) {
		if(cnt==N) {
			if(sum>max) max=sum;
			return;
		}		
		int idx=-1;
		for(int i=0;i<6;i++) {
			if(dice[cnt][i]==bottomValue) {
				idx=i;
				break;
			}
		}		
		search(cnt+1, dice[cnt][findTop(idx)], sum+findMax(cnt, idx));
	}


}
