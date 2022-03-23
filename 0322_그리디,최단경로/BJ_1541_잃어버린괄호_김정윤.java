package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호_김정윤 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			// 뺄셈으로 나눈 토큰을 덧셈으로 분리
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			
			// 덧셈으로 나눈 토큰들을 모두 더함
			while(st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			
			// 첫 번째 토근인 경우 temp값이 첫 번째 수가 됨
			if(sum==Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);

	}

}
