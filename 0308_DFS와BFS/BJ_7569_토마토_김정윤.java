package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토_김정윤 {
	
	static class tomato {
		int x, y, z;

		public tomato(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static int M;	// 상자 가로 칸 수
	static int N;	// 상자 세로 칸 수
	static int H;	// 쌓아올려지는 상자 수
	static int[][][] map;	// 토마토 저장 창고
	static Queue<tomato> q = new LinkedList<tomato>();
	static int[] dx = {0, 0, -1, 1, 0, 0};	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static int[] dy = {0, 0, 0, 0, 1, -1};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	static int unRipeCnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());	// 상자 가로 칸 수
		N = Integer.parseInt(st.nextToken());	// 상자 세로 칸 수
		H = Integer.parseInt(st.nextToken());	// 쌓아올려지는 상자 수
		// 토마토 상태 입력
		map = new int[N][M][H];
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int z=0; z<M; z++) {
					map[j][z][i] = Integer.parseInt(st.nextToken());
					if(map[j][z][i]==1) {	// 익은 토마토인 경우 모든 위치를 queue에 저장, bfs 탐색 시작점으로 함
						q.add(new tomato(j, z, i));
					} else if(map[j][z][i]==0) unRipeCnt++;	// 익지 않은 토마토의 개수 cnt
				}
			}
		}
		// 익지 않은 토마토의 개수가 0이라면(모든 토마토가 익어있는 상태), bfs 탐색없이 0 출력 후 종료
		if(unRipeCnt==0) {
			System.out.println(0);
			return;
		}
		
		bfs();

	}

	private static void bfs() {
		
		int day = 0;	// level별 탐색 위함
		
		while(!q.isEmpty()) {
				// depth별 탐색
				int size = q.size();
				while(size-- > 0) {
					tomato current = q.poll();	// 익은 토마토 정보 가져오기
					
					for(int i=0; i<6; i++) {	// 익은 토마토(current)의 위치 기준으로 인접한 6방향의 토마토 익히기
						// 6방향의 인접 토마토 위치(인접 정점) 받아오기
						int nextX = current.x + dx[i];
						int nextY = current.y + dy[i];
						int nextZ = current.z + dz[i];
						
						// 경계 내에 있고 익지 않은 토마토라면
						if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && nextZ>=0 && nextZ<H && map[nextX][nextY][nextZ]==0) {
							map[nextX][nextY][nextZ] = 1;	// 토마토 익히기
							q.offer(new tomato(nextX, nextY, nextZ));	// 지금 익힌 토마토를 기준으로 다음 날 인접한 토마토를 익히기 위해 queue에 저장
							unRipeCnt--;	// 익지 않은 토마토 개수 반영
						}
					}
				}
			day++;	// 해당 depth(날짜) 탐색 끝나면 depth(날짜) 증가
			
			// depth별 탐색을 마쳤을 때, 익지 않은 토마토의 개수가 0이라면 day 출력 후 종료
			if(unRipeCnt==0) {
				System.out.println(day);
				return;
			}
		}
		// 여기까지 왔다는 것은 익지 않은 토마토가 존재한다는 것이므로 -1 출력
		System.out.println(-1);
	}

}
