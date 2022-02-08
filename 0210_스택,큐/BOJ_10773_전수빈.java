package stack;

import java.util.Scanner;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //testcase
		Stack<Integer> stack = new Stack<>(); // 스택 생성

		for(int i=0;i<n;i++) {
			int num= sc.nextInt();
//			if(stack.empty()) {
//				stack.push(num);// 스택이 비어있을때 넣어줌 
//				
//			}
			if(num==0) {
				stack.pop();// 0 입력하면 최근 숫자 삭제				
			}
			else {
				stack.push(num);// 숫자입력
			}
			
		}
		int sum=0;
		for(int i : stack) {
			sum+=i;
		}
	
	System.out.println(sum);
	}

}
