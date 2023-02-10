package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14921_용액합성하기_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] liquid = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			liquid[i]=Integer.parseInt(st.nextToken());
		}
		
		int start=0;
		int end=N-1;
		
		int min = 100000000;
		
		while(start<end) {
			int val = liquid[start]+liquid[end];
			if(Math.abs(val)<Math.abs(min)) {
				min = val;
			}
			if(val<0) {
				start++;
			}else if(val>0) {
				end--;
			}else {
				break;
			}
		}
		
		System.out.println(min);
		
	}

}
