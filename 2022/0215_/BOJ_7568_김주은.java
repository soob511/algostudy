package com.ssafy.add.d0215;

import java.io.*;
import java.util.*;

public class boj_7568_덩치_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] data = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			data[i][2] = 1;
			
			for(int j=0;j<i;j++) {
				//현재 입력 값이 이전 값보다 클 경우 이전값 +1
				if(data[j][0]<data[i][0] && data[j][1]<data[i][1]) {
					data[j][2]+=1;
				}
				//현재 입력 값이 이전 값보다 클 경우 현재값 +1
				else if(data[j][0]>data[i][0] && data[j][1]>data[i][1]) {
					data[i][2]+=1;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			sb.append(data[i][2]+" ");
		}
		System.out.println(sb);
	}
}
