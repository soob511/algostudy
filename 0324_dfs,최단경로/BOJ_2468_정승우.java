package com.ssafy.day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2468_정승우 {

	//방향값 상하좌우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	//지역
	static int[][] map;
	//물에 잠겼는지 체크해주는 2차원 배열
	static boolean[][] checked;
	static int N;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 지역 NxN
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		checked = new boolean[N][N];
		
		
		//입력받은 값중 가장 큰 값을 저장하기 위한 변수
		int max=0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
			
				map[i][j] = Integer.parseInt(st.nextToken());
				//해당 지역이 max보다 크면 max값 갱신해서 가장 높은 지역 찾음
				if(max<map[i][j]) max=map[i][j];
			}
		}

		
		//비가 온 후 물높이 1씩 증가
		// 물의 깊이
		int depth = 0;
		// 안전구역중 가장 큰 값이 저장될 변수
		int sum=0;
		//현재 물의 깊이가 가장 높은 지역과 같아지면
		while(depth<=max) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// 물에 잠긴 지역이라면
					if(map[i][j] - depth <= 0) {
						//잠긴 지역 체크
						checked[i][j] = true;
					}
				}
			}
			// 물의 깊이가 1씩 증가할때마다 그때에 해당하는 안전지역 개수 체크할 변수
			int cnt=0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// 잠기지 않은 부분부터 dfs돌리기 위해 잠긴 부분은 넘김
					if(checked[i][j] == true) {
						continue;
					} 
					//잠기지 않은 부분 DFS탐색
					else {
						DFS(i,j);
						cnt++;
					}
				}
			}
			//System.out.println(cnt);
			//sum에 각 깊이마다 안전구역 개수 중 가장 큰 값을 저장
			if (sum<cnt) sum=cnt;
			//1번 탐색이 끝날때마다 1씩 증가
			depth++;
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					//checked 2차원 배열 값 전부 false로 초기화
					checked[i][j]=false;
				}
			}
			
		}
		System.out.println(sum);
	}
	
	
	static void DFS(int i, int j) {

		//방문한 배열 체크
		checked[i][j]=true;
		//상,우,좌,하 방향
		for (int k=0; k<4; k++) {
			// 다음으로 이동할 방향 nr,nc에 위치 값 저장
			int nr = i+dr[k];
			int nc = j+dc[k];
			//경계를 벗어나지 않고, 체크배열이 false일 경우
			if (0<=nr&&0<=nc&&nr<N&&nc<N&&checked[nr][nc]==false) {
				DFS(nr, nc);
			}
		}
		//더이상 갈 방향이 없다면 return
		return;
		
	}
}
