package com.ssafy.day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_7562_정승우 {

	static class knight {
		int r,c,cnt;
		
		knight(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "knight [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	//말의 정보를 담을 q를 생성
	//static Queue<knight> q = new LinkedList<>();
	static Queue<knight> q;
	
	//시계방향으로
	static int dr[] = {-2, -1, 1, 2, 2, 1, -1, -2};  
	static int dc[] = {1, 2, 2, 1, -1, -2, -2, -1};
	
	//체스판 배열
	static int arr[][];
	//I : 체스판 크기
	static int I,r2,c2;
	//최단거리
	static int number =0;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			I = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//r1,c1 : 말의 현재 위치
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			//r2,c2 : 나이트가 이동하려는 칸
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			//체스판 배열 생성
			arr = new int[I][I];
			
			q = new LinkedList<>();
			//큐에 knight 생성자 추가(위치값,카운트값을 저장)
			q.offer(new knight(r1, c1, 0));

			bfs();
			System.out.println(number);
			
		}
		
	}
	
	public static void bfs() {
		//q의 값이 빌때까지
		while (!q.isEmpty()) {
			//temp에 q에서 빼낸 값을 저장
			knight temp = q.poll();
			//빼온 r,c값이 나이트가 이동하려는 칸이면 number에 그때의 개수를 저장
			if (temp.r==r2&&temp.c==c2) {
				number = temp.cnt;
				break;
			}
			//8방향에 대한 설정
			for (int i=0; i<8; i++) {
				
				int x1 = temp.r+dr[i];
				int y1 = temp.c+dc[i];
				int cnt = temp.cnt +1;
				//경계값을 벗어나지 않고 이동하려는 칸의 값이 0인경우
				if (x1>=0&&x1<I&&y1>=0&&y1<I&&arr[x1][y1]==0) {
					//q에 값 추가(방향값을 설정한 x1,y1과 그때의 카운트 값을 넘겨줌)
					q.offer(new knight(x1,y1,cnt));
					arr[x1][y1]=arr[temp.r][temp.c]+1;
				}
			}
		}
	}
}

