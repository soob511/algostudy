package stack;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = sc.nextInt();
		
		int cnt=0;
		while(n-->0) {
			
			int num = sc.nextInt();
			
			if(cnt<num) {
				for(int i=cnt+1;i<=num;i++) {
					stack.push(i);
					sb.append('+');
				}
				cnt = num;
				
			}
			
			else if(stack.peek() != num) {
				System.out.println("No");
				return;
			}
			
			stack.pop();
			sb.append('-');
		}
		
		
		System.out.println(sb.toString());
		
	}

}
