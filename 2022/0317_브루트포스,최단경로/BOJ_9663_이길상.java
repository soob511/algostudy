package day0317;
import java.io.*;

public class BOJ_9663_이길상 {
	// 열과 두 대각선에 퀸이 있는지 저장
	static boolean[] col, left, right;
	// 체스판 크기 N과 경우의 수
	static int N, count = 0;
	
	// r번째 행에 퀸 놓기
	static void queen(int r) {
		// N개를 모두 놓았을 경우
		if(r==N) {
			count++;
			return;
		}
		
		// 비어있는 열이 있는지 순회
		for (int c = 0; c < N; c++) {
			if(col[c])continue;
			// 대각선 확인
			if(left[r-c+N-1] || right[r+c])continue;
			
			// 백트래킹 재귀
			col[c] = left[r-c+N-1] = right[r+c] = true;
			queen(r+1);
			col[c] = left[r-c+N-1] = right[r+c] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        N = Integer.parseInt(br.readLine());
		col = new boolean[N]; 
		left = new boolean[N*2-1]; 
		right = new boolean[N*2-1];

        queen(0);
        
        // 출력
        System.out.println(count);
        
    }

}
