package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정_김정윤 {

	public static void main(String[] args) throws IOException {

		// 상, 우, 하, 좌
		int[] dr = {-1, 0, 1, 0};	// 2차원 배열 탐색용
		int[] dc = {0, 1, 0, -1};
		int[] dx = {0, 1, 0, -1};	// (x, y) 좌표용
		int[] dy = {1, 0, -1, 0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());	// 가로
		int R = Integer.parseInt(st.nextToken());	// 세로
		int K = Integer.parseInt(br.readLine());	// 관객의 대기번호 (K번째 find)
		
		// 좌석 배정할 수 없는 경우
		if(R*C<K) {
			System.out.println(0);
			return;	// 프로그램 종료
		}
		
		// 공연장 생성
		int[][] map = new int[R][C];
		
		// K번째 좌석번호 찾기
		int r=R-1, c=0;	// 배열 시작점
		int x=1, y=1; 	// 좌표 시작점
		int in=0;	// 인덱스용
		for(int i=0; i<K; i++) {
			if(r<R && r>=0 && c>=0 && c<C && map[r][c]==0) {	// 경계를 벗어나지않고 비어있는 경우
				r += dr[in%4];	// 그대로 계속 이동
				c += dc[in%4];
				x += dx[in%4];	// 좌석좌표 증가
				y += dy[in%4];
				map[r][c] = 1;	// 지나간 곳 표시
			}else {
				in++;	// 방향, 좌표 index 증가
			}
		}
		// 좌석 배정할 수 있는 경우
		System.out.printf(x + " " + y);
	}

}
