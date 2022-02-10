package com.ssafy.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10773_정승우 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int sum =0;
		int K = Integer.parseInt(br.readLine());
	
		for (int i=0; i<K; i++) {
			int N = Integer.parseInt(br.readLine());
			//입력받은 N값이 0이면 pop 
			if (N==0) {
				stack.pop();
			} else {
				stack.push(N);
			}
		
		}

		
		//stack이 비어있지 않으면 stack.pop()으로 stack값 전부 꺼내서 sum에 저장
		while (!stack.isEmpty() ) {
			sum+= stack.pop();
		}
		sb.append(sum);
		System.out.println(sb);
	}

}
