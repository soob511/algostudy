package study;

import java.util.*;
import java.io.*;

public class Main_16234_인구이동 {
	static int n, L, R;
	static int[][] map;
	static boolean visit[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean people = false;
	static int day;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());// 땅크기
		L = Integer.parseInt(st.nextToken());// L명이상
		R = Integer.parseInt(st.nextToken());// R명이하
		map = new int[n][n];

		// 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			people = false;
			visit = new boolean[n][n]; // 초기화

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						bfs(i, j);// 방문하지 않았다면 탐색 시작
					}
				}
			}

			if (!people) {// 인구이동 없었으면 종료
				break;
			} else {
				day++;// 인구이동 있었음
			}
		}

		System.out.println(day);
	}

	private static void bfs(int a, int b) {

		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		q.add(new int[] { a, b });
		visit[a][b] = true;
		list.add(new int[] { a, b });

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {// 범위안에 있고 방문하지 않았다면
					if (Math.abs(map[nx][ny] - map[x][y]) >= L && Math.abs(map[nx][ny] - map[x][y]) <= R) {// 두구역의 차이가
																											// L이상 R이하인
																											// 경우
						people = true;//인구이동체크
						visit[nx][ny] = true; // 방문체크
						q.add(new int[] { nx, ny });
						list.add(new int[] { nx, ny });//리스트 추가
					}
				}
			}

		}
		
		int sum=0;//합
		int size = list.size();//리스트 사이즈
		
		for(int i=0;i<size;i++) {//합구하기
			int[] p = list.get(i);
			int x = p[0];
			int y = p[1];
			sum+=map[x][y];
		}
		
		for(int i=0;i<size;i++) {//(연합의 인구수) / (연합을 이루고 있는 칸의 개수)
			int[] p = list.get(i);
			int x = p[0];
			int y = p[1];
			map[x][y] = sum/size;
		}
		list.removeAll(list); // 리스트 초기화
		

	}

}
