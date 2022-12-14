package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9012_김정윤 {

	static String result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// Stack에 읽어오기
		for(int tc=0; tc<T; tc++) {
			
			Stack<Character> PS = new Stack<Character>();
			String ps = br.readLine();
			char[] st  = ps.toCharArray();
			
			for(int i=0; i<ps.length(); i++) {
				char ps2 = st[i];
				if(ps2=='(') {				// "(" 인 경우
					PS.push('(');			// stack에 저장
				}
				else if(ps2 == ')'){						// ")" 인 경우
					if(PS.size() == 0) {
						PS.push(')');
						break;
					}
					else if(PS.peek() == '(')
						PS.pop();				// stack에서 얖의 '(' 제거
					else { // 스택 맨 위가 여는 괄호가 아닐때
						break;
					}
				}
			}	
			
			// VPS인지 결과 출력
			if(PS.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

}
