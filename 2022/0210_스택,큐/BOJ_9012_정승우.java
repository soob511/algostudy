package com.ssafy.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_정승우 {

	public static void main(String[] args) throws IOException {
	
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();

			for(int i=0; i<N; i++) {
				String str = br.readLine();
				
				for(int j=0; j<str.length(); j++) {
					
					//str.charAt(j) 값이 '('라면 stack에 push
					if(str.charAt(j) == '(') {
						stack.push(str.charAt(j));
					}
					//스택 값이 비었을경우 스택에 추가
					else if(stack.isEmpty()) {
						stack.push(str.charAt(j));
						break;
						
						//str.charAt(j) 값이 ')'라면 stack에서 pop
					} else {
						stack.pop();
					}	

				}

				//스택이 비어있을 경우 YES 아닌경우 NO를 출력
				if(stack.isEmpty()) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}

				//stack 비움
				stack.clear();
			}
		

	}

}
