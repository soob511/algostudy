package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_김정윤 {
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int K = Integer.parseInt(br.readLine());	// 정수 개수
		int sum = 0;	// 최종적으로 적어 낸 수의 합
		int num;
		
		// 1. 수 적기
		for(int i=0; i<K; i++) {
			num = Integer.parseInt(br.readLine());
			if(num==0) {			// 0인 경우,
				stack.pop();		// 가장 최근에 쓴 수 지우기
			}else {					// 0이 아닌 경우, 
				stack.push(num);	// 해당 수를 씀
			}
		}

		// 2. 최종적으로 적어낸 수의 합 구하기
		while(!stack.isEmpty()) {
			sum += stack.peek();
			stack.pop();
		}
		
		// 3. 결과 출력
		System.out.println(sum);
	}

}
