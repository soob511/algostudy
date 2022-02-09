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
			StringTokenizer st = new StringTokenizer(ps);
			
			for(int i=0; i<ps.length(); i++) {
				String ps2 = st.nextToken();
				if(ps2=="(") {				// "(" 인 경우
					PS.push('(');			// stack에 저장
				}else {						// ")" 인 경우
					if(PS.isEmpty()) {
						break;
					}else {
						PS.pop();				// stack에서 얖의 '(' 제거
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
