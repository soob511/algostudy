package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_7562_나이트의이동_김정윤 {
	
	static class Night{
		int x, y;

		public Night(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int I;	// 체스판 한 변의 길이
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스의 수
		StringTokenizer st;
		
		for(int tc=0; tc<T; tc++) {
			I = Integer.parseInt(br.readLine());	// 체스판 한 변의 길이
			int[][] map = new int[I][I];
			st = new StringTokenizer(br.readLine(), " ");
			int currentX = Integer.parseInt(st.nextToken());	// 나이트가 현재 있는 칸 X좌표
			int currentY = Integer.parseInt(st.nextToken());	// 나이트가 현재 있는 칸 Y좌표
			st = new StringTokenizer(br.readLine(), " ");
			int moveX = Integer.parseInt(st.nextToken());	// 나이트가 이동하려는 칸 X좌표
			int moveY = Integer.parseInt(st.nextToken());	// 나이트가 이동하려는 칸 Y좌표
			
			bfs(map, currentX, currentY, moveX, moveY);		
		}

	}
	
	private static void bfs(int[][] map, int currentX, int currentY, int moveX, int moveY) {
		
		int cnt=0; 	// 나이트가 몇 번 이동했는지
		
		Queue<Night> q = new LinkedList<Night>();
		
		q.offer(new Night(currentX, currentY));
		map[currentX][currentY] = 1;
		
		A : while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				Night night = q.poll();
				
				if(night.x==moveX && night.y==moveY) break A;
		
				for(int i=0; i<8; i++) {
					int r = night.x + dx[i];
					int c = night.y + dy[i];
					
					if(r>=0 && c>=0 && c<I && r<I && map[r][c]==0) {
						q.offer(new Night(r, c));
						map[r][c] = 1;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
