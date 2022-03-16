package com.ssafy.add.d0303;

import java.io.*;
import java.util.*;

public class Main_BJ_2304_창고다각형_김주은 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] data = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//위치 순서대로 정렬
		Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		});
		
		//가장 높은 기둥 탐색
		int maxIdx = 0;
		for(int i=1;i<N;i++) {
			if(data[maxIdx][1] < data[i][1]) maxIdx=i;
		}
		
		int ans = data[maxIdx][1]; //가장 높은 기둥 높이 더하기
		
		//높은 기둥 왼쪽 탄생
		int n=maxIdx-1;
		int lmax=0;
		while(n>=0) {
			for(int i=0;i<=n;i++) {
				if(data[lmax][1]<data[i][1]) lmax = i;
			}
			ans += (data[n+1][0]-data[lmax][0])*data[lmax][1];
			n=lmax-1;
			lmax=0;
		}
		//높은 기둥 오른쪽 탄생
		n=maxIdx+1;
		int rmax=N-1;
		while(n<=N-1) {
			for(int i=n;i<=N-1;i++) {
				if(data[rmax][1]<data[i][1]) rmax = i;
			}
			ans += (data[rmax][0]-data[n-1][0])*data[rmax][1];
			n=rmax+1;
			rmax=N-1;
		}
		
		
		System.out.println(ans);
	}

}
