package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_김정윤 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 1 ~ n
		int[] Array = new int[n];	// 순열
		
		// 순열 입력
		for(int i=0; i<n; i++) {
			Array[i] = Integer.parseInt(br.readLine());
		}
		
		// 1 ~ n까지 숫자 stack에 넣으면서, 순열과 같은 숫자 있는지 여부 탐색
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int arrayCnt = 0;
		
		for(int i=0; i<n; i++) {
			stack.add(i+1);
			sb.append("+" + "\n");
			if(Array[arrayCnt]==(i+1)) {	// 순열과 같은 숫자 발견
				stack.pop();
				sb.append("-" + "\n");
				arrayCnt++;
				if(arrayCnt<n && !stack.isEmpty() && Array[arrayCnt]==stack.peek()) {
					do {	// stack에서 제거한 바로 앞 숫자와 다음 순열 숫자 비교
						stack.pop();
						sb.append("-" + "\n");
						arrayCnt++;
					}while(arrayCnt<n && !stack.isEmpty() &&  Array[arrayCnt]==stack.peek());
				}
			}
		}
		
		// n까지 stack에 다 넣었으니, pop하면서 다음 순열 숫자랑 비교
		boolean flag = true;
		if(!stack.isEmpty()) {	// stack에 남아있으면
			if(stack.peek()==Array[arrayCnt]) {
				do {	// stack에서 제거한 바로 앞 숫자와 다음 순열 숫자 비교
					stack.pop();
					sb.append("-" + "\n");
					arrayCnt++;
				}while(!stack.isEmpty() && Array[arrayCnt]==stack.peek());
			}else {	// 불가능한 순열
				flag = false;
			}
		}
		
		// 출력
		if(!flag) {
			System.out.println("NO");
		}else {
			System.out.print(sb);
		}
		
	}

}
