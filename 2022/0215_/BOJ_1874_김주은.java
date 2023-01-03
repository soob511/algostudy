package com.ssafy.add.d0215;

import java.io.*;
import java.util.*;

public class boj_1874_수열_김주은 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		//1. 배열에 수열 입력받기
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
				
		//2. stack 생성 후 첫 값 입력
		Stack<Integer> stack = new Stack<Integer>();
		int n=1;
		
		//3. push pop하며 가능 여부 판단
		for(int i=0;i<N;i++) {
			//stack이 비었을 경우 push
			if(stack.isEmpty()) {
				stack.push(n++);
				sb.append("+\n");
			}
			//top값이 arr[i]값보다 작을 경우 push
			while(stack.peek()<arr[i]) {
				stack.push(n++);
				sb.append("+\n");
			}
			//stack의 top과 arr[i]값 같을 경우 pop
			if(stack.peek()==arr[i]) {
				stack.pop();
				sb.append("-\n");
				continue;
			}
			//stack의 top이 arr[i]보다 클 경우, 오류
			else if(stack.peek()>arr[i]) {
				sb.setLength(0);
				sb.append("NO\n");
				break;
			}
		}
		
		System.out.println(sb);
	}

}


