package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

////////////////
public class BOJ_7568_김정윤 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 사람의 수
		StringBuilder sb = new StringBuilder();		// 결과 저장
		int[][] arr = new int[N][2];
		
		// 입력
		StringTokenizer st;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());	// 몸무게
			arr[n][1] = Integer.parseInt(st.nextToken());	// 키
		}
		
		// 덩치 비교
		for(int i=0; i<N; i++) {
			int rank = 1;
			for(int j=0; j<N; j++) {
				if(i==j) continue;	// 본인이므로 continue
				// 본인보다 크면 rank 증가
				else if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) rank++;
			}
			// rank 결과 저장
			sb.append(rank + " ");
		}
		
		// 결과 출력
		sb.setLength(sb.length()-1);	// 마지막 공백 제거
		System.out.print(sb);
	}

}
