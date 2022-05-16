package com.ssafy.day0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20058_정승우 {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static int size;
	static int len;
	static int sum;
	static int count;
	static int[][] map,temp,copy;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//격자판의 크기 = 2의N승X2의N승
		int N = Integer.parseInt(st.nextToken());

		//파이어스톰 시전하는 횟수
		int Q = Integer.parseInt(st.nextToken());
		
		//map의 가로,세로 크기 size*size
		size = (int)Math.pow(2, N);
		
		map = new int[size][size];
		copy = new int[size][size];
		
		
		for (int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			//map의 부분 격자별 위치 저장해서 다시 map에 저장하기 위한 배열
			temp = new int[size][size];
			// 시전 단계
			int L = Integer.parseInt(st.nextToken());
			
			//부분 격자별 좌측 상단 시작 위치를 찾음
			len = 1 << L;
			for (int i =0; i<size; i+=len) {
				for(int j=0; j<size; j+=len) {
					//시작위치 (i,j)와 부분격자 크기를 인자로 전달
					rotate(i,j,len);
				}
			}
			
			//동시에 녹아야하기 위해 만든 배열
			mapcopy();

			
			for (int i =0; i<size; i++) {
				for(int j=0; j<size; j++) {
					//i,j에 대하여 인접 얼음이 3개보다 적은지 체크
					fourSearch(i,j);
					
				}
			}
	
			
			//남아있는 얼음의 합
			sum = 0;
			//남아있는 얼음 구하기
			haveIce();
			
			
			//DFS에서 중복체크를 위한 배열
			visited = new boolean[size][size];
			//
			count=0;
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if(map[i][j]==0) continue;
					DFS(i,j);
				}
			}
			//남아있는 얼음의합
			System.out.println(sum);
			//얼음덩어리
			System.out.println(count);
		}

	}


	//동시에 녹아야하기 위해 만든 배열
	static void mapcopy() {
		for (int i =0; i<size; i+=len) {
			for(int j=0; j<size; j+=len) {			
				
				copy[i][j] = map[i][j];
				
			}
		}
	}




	static void rotate(int x, int y, int len) {
	    // 회전한 모양을 temp[][]에 저장
	    for (int i = 0; i < len; ++i) {
	        for (int j = 0; j < len; ++j) {
	            temp[j][len - 1 - i] = map[x + i][y + j];
	        }
	    }
	 
	    // 저장된 temp[][]의 값을 map[][]에 다시 저장
	    for (int i = 0; i < len; ++i) {
	        for (int j = 0; j < len; ++j) {
	            map[x + i][y + j] = temp[i][j];
	        }
	    }

	    
	}
	//인접한 지역에 남아있는 얼음이 3개 이상 있는지
	static void fourSearch(int r, int c) {
		
		int cnt =0;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0&&nr<size&&nc>=0&&nc<size&&temp[nr][nc]!=0) {
				cnt++;
			}
		}
		if(cnt<3) {
			if(map[r][c]==0) {
				map[r][c] =0;
			} else {
				map[r][c] = temp[r][c]-1;
			}
		}
	}
	
	//남은 얼음 개수 
	static void haveIce() {
		for (int i =0; i<size; i++) {
			for(int j=0; j<size; j++) {
				
				sum += map[i][j];
			}
		}
	}
	
	//가장 큰 얼음 덩어리 구하기
	static void DFS(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0&&nr<size&&nc>=0&&nc<size&&visited[nr][nc]==false) {
				
				visited[r][c] =true;
				//조건문 통과시 인접한 얼음이 있음으로 카운트 증가
				count++;
				
				DFS(nr, nc);
			}
			
			return;
		}
		
	}
	
}
