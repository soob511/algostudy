package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1874_정승우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//스택
		Stack<Integer> stack = new Stack<>();
		//연산자를 저장하기 위한 ArrayList
		ArrayList<Character> oper = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int []arr = new int[N+1];
		int m=1;
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		
		for (int i=1; i<=N; i++) {
			//stack이 push가 되면 연산자를 추가해야함
			stack.push(i);
			oper.add('+');
			//스택이 비어있지 않고 stack.peek()값이 arr[m]이라면
			while(!stack.empty()&&stack.peek()==arr[m]) {
				//스택이 pop되면 -연산자를 oper리스트에 추가
				stack.pop();
				oper.add('-');			
				m++;
			}			
		
		}
		// for문을 다 돌리고 스택이 비어있다면 oper리스트를 출력
		if (stack.empty()) {			
			System.out.println(oper);
		} else {
			//비어있지 않다면 불가능한 경우로 NO출력
			System.out.println("NO");
		}
	}

}
