package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_김정윤 {
	
	static int[][] Chulsu = new int[5][5];
	static int[][] Host = new int[5][5];
	static StringTokenizer st;
	static int lineCnt = 0;
	static int speak = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 철수 빙고판 입력
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				Chulsu[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		// 사회자 빙고판 입력
		A :for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				Host[i][j] = Integer.parseInt(st.nextToken());
				speak++;	// 사회자가 부른 숫자가 몇 번째 수인지 
				// 사회자가 부른 숫자 찾아서 '0'입력
				find(Host[i][j]);	// 사회자가 부른 숫자 찾아서 '0' 입력
				if(lineCnt>=3) break A;	// '선' 3개 이상, 빙고인 경우
			}
		}
		
		// '선' 3개 이상이면 빙고 외치고 종료
		System.out.print(speak);
	}


	private static void find(int host) {
		
		for(int x=0; x<5; x++) {
			for(int y=0; y<5; y++) {
				if(Chulsu[x][y]==host) {
					Chulsu[x][y] = 0;
					// '0' 입력할 때마다 '선' 확인
					checkBingo();
				}
			}
		}
	}


	private static void checkBingo() {	

		int r = 0;
		int c = 0;
		int r2 = 0;
		int c2 = 4;
		int cnt3 = 0;	// 대각선 - 우하
		int cnt4 = 0;	// 대각선 - 좌하
		for(int i=0; i<5; i++) {
			if(Chulsu[r][c]==0) {	// 대각선 - 우하
				cnt3++;
				r += 1;
				c += 1;
			}
			if(Chulsu[r2][c2]==0) {	// 대각선 - 좌하
				cnt4++;
				r2 += 1;
				c2 -= 1;
			}
			
			int cnt = 0;	// 가로
			int cnt2 = 0;	// 세로
			
			for(int j=0; j<5; j++) {
				if(Chulsu[i][j]==0) {	// 가로
					cnt++;
				}
				if(Chulsu[j][i]==0) {	// 세로
					cnt2++;
				}
			}
			if(cnt==5) lineCnt++;	// 가로
			if(cnt2==5) lineCnt++;	// 세로
		}
		if(cnt3==5) lineCnt++;	// 대각선 - 우하
		if(cnt4==5) lineCnt++;	// 대각선 - 좌하
	}

}
