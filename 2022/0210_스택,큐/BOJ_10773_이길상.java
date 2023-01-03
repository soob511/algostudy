package day0210;

import java.util.*;

public class BOJ_10773_이길상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>();
		int K = sc.nextInt();
		
		while(K-->0) {
			int input = sc.nextInt();
			
			if(input == 0) stack.pop();
			else stack.push(input);
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}

}
