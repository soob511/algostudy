package com.ssafy.add.d0210;

import java.io.*;
import java.util.*;

public class boj_9012_괄호_김주은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		boolean isNo;
		
		int T = Integer.parseInt(br.readLine()); //tc 수
		
		for(int tc=0;tc<T;tc++) {
			stack.clear();
			isNo = false;
			
			//하나의 vps 문자열 입력받기
			char[] string = br.readLine().toCharArray(); 
			
			for(int i=0;i<string.length;i++) {
				//왼쪽 괄호라면 stack에 push
				if(string[i]=='(') {
					stack.push('(');
				}
				//오른쪽 괄호라면 pop하여 짝을 생성
				else if(string[i]==')') {
					//stack에 왼쪽 괄호가 남아있는지 확인
					//남아있으면 pop 없다면 NO
					if(stack.isEmpty()) {
						isNo = true;
						break;
					}
					else{
						stack.pop();
					}
				}
			}
			
			//입력 종료 후 stack에 괄호가 남아있다면 NO
			if(!stack.isEmpty() | isNo) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
		}
		System.out.println(sb.toString());
		
		
	}

}