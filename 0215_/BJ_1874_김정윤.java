package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//////////////
public class BJ_1874_김정윤 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack stack = new Stack();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());	// 1 ~ n
		int[] Arr = new int[n+1];	// 순열, 0을 사용하지 않기 때문에 +1
		int m = 1;
		
		// 순열 입력
		for(int i=1; i<=n; i++) {
			Arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=n; i++) {
			stack.push(i);
			sb.append("+" + "\n");
			while(!stack.isEmpty() && (int)stack.peek()==Arr[m]) {	// 순열과 같은 경우 pop
				stack.pop();
				sb.append("-" + "\n");
				m++;
			}
		}
		
		if(stack.isEmpty()) {
			System.out.print(sb);
		}else {
			System.out.println("NO");
		}
	}

}
