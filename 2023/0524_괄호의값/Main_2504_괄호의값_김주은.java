package com.bj;

import java.util.Scanner;
import java.util.Stack;

public class Main_BJ_2504_괄호의값_김주은 {
	
	static String s;
	static int idx=0;
	static Stack<Character> stack;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		s = sc.next();
		stack = new Stack();
		
		int answer=0;
		int depth=0;
		int[] val = new int[s.length()+1];
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(stack.isEmpty()) {
				if(c=='(' || c=='[') {
					depth+=1;
					stack.push(c);
				}else {
					System.out.println(0);
					return;
				}
				continue;
			}
			
			if(c=='(' || c=='[') {
				depth+=1;
				stack.push(c);
				continue;
			}
			
			if(c==')') {
				if(stack.peek()=='(') {
					if(val[depth+1]>0) {
						val[depth]+=(val[depth+1]*2);
						val[depth+1]=0;
					} else {
						val[depth]+=2;
					}
					stack.pop();
					depth-=1;
				} else {
					System.out.println(0);
					return;
				}
			}else if(c==']') {
				if(stack.peek()=='[') {
					if(val[depth+1]>0) {
						val[depth]+=(val[depth+1]*3);
						val[depth+1]=0;
					} else {
						val[depth]+=3;
					}
					stack.pop();
					depth-=1;
				}else {
					System.out.println(0);
					return;
				}
			}
			
		}
		
		System.out.println(val[1]);
	}

}
