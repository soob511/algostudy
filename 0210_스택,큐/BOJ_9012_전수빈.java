package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main_9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n= Integer.parseInt(br.readLine()); //정수받기
		
		for(int i=0;i<n;i++) {	//받은만큼 포문돌리기
		
			String s = br.readLine(); //괄호 받기
			Stack<Character> stack = new Stack<>();//스택
			
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				
					if(c=='(') { //  '('일때 넣어주기
						stack.push(c);
					}
					else if(c==')') {   //')' 일때
						 if(stack.empty()) { //비어있으면
							stack.push(c);	// 삽입 비어있을때 yes 프린트해주기때문에
							break;
						}
						 else { // 비어있지않을때
							 if(stack.peek()=='(') { // '(' 라면 짝맞춰서 삭제
								 stack.pop();
							 }
							 else break; //짝이 안맞으면 나가기
						 }
					
					}
				}
			if(stack.empty()) {//stack 이 짝이맞아 비었을때 yes
				sb.append("YES"+"\n");
			}
			else sb.append("NO"+"\n");	
		}
		System.out.println(sb.toString());

	}

}
