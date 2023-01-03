package com.ssafy.add.d0217;

import java.io.*;
import java.util.*;

public class boj_2605_줄세우기_김주은 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] list = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int M = Integer.parseInt(st.nextToken());
			list[i]=i;
			
			//M번만큼 앞으로 이동
			int j=i;
			while(M-->0) {
				//swap
				int temp = list[j];
				list[j] = list[j-1];
				list[j-1] = temp;
				//한칸 아랫쪽으로 j값 이동
				--j;
			}
		}
		
		for(int i=1;i<=N;i++) {
			sb.append(list[i]+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
