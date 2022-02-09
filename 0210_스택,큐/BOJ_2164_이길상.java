package day0210;

import java.util.*;

public class BOJ_2164_이길상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 짝수번째와 홀수번째 중 어느 쪽을 남길 것인가
		int mode = 0;
		
		// 홀짝 스택
		Stack<Integer> stack = new Stack<>();
		
		while(N>1) {
			// 짝수번째와 홀수번째 중 어느 쪽을 남기는지 기록
			stack.push(mode);
			
			if(N%2 == 1) {
				N /= 2;
				
				// 홀수번째만 남겼다면 절반보다 하나 많이 남는다.
				if(mode == 1) N++;
				
				// 숫자가 홀수개였다면 다음에 남길 쪽을 바꾼다.
				mode ^= 1;
			}
			else {
				N /= 2;
			}
		}
		
		// 인덱스 역추적
		int idx = 1;
		while(!stack.isEmpty()) {
			idx = idx*2  - stack.pop();
		}
		
		System.out.println(idx);
	}

}
