package day0210;

import java.util.*;

public class BOJ_9012_이길상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		while(T-->0) {
			char[] line = sc.next().toCharArray();
			
			// 스택을 대신할 숫자
			int stack = 0;
			for (char c : line) {
				if(c =='(') stack++;
				else stack --;
				
				// 숫자가 음수로 떨어지면 중지
				if(stack<0) break;
			}
			
			// 스택 숫자가 0이 아니면 문제가 있었다는 뜻
			System.out.println((stack == 0) ? "YES" : "NO");
		}

	}

}
