import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] map;

	static Queue<int[]> q = new ArrayDeque<>();
	static ArrayList<int[]> blist = new ArrayList<>();

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int scores = 0;

		while (true) {
			int cnt = deletedBombs();
			if (cnt == 0) {
				break;
			}

			scores += cnt * cnt;

			pushDown();
			turn90();
			pushDown();
		}

		System.out.println(scores);
	}

	private static void turn90() {
		int[][] map2 = new int[N][N];
		for (int x = 0, j = 0; j < N && x < N; j++, x++) {
			for (int y = 0, i = N - 1; i >= 0 && y < N; i--, y++) {
				map2[i][j] = map[x][y];
			}
		}
		map = map2;
	}

	private static void pushDown() {
		for (int j = 0; j < N; j++) {
			A: for (int i = N - 1; i >= 0; i--) {
				// 빈공간을 발견했다면 가장 위에 있는 폭탄 찾으러가기
				if (map[i][j] == -2) {
					for (int k = i - 1; k >= 0; k--) {
						// 총이 있다면 총으로 이동하기
						if (map[k][j] == -1) {
							i = k;
							break;
						}
						// 폭탄 발견시 폭탄 내리기
						else if (map[k][j] >= 0) {
							int temp = map[i][j];
							map[i][j] = map[k][j];
							map[k][j] = temp;
							break;
						}

						else if (k == 0) {
							break A;
						}
					}
				}
			}
		}
	}

	private static int deletedBombs() {
		
		boolean[][] bvisited  = new boolean[N][N];
		
		blist.clear();
		int bsize = 0;
		int rsize = 0;
		int bx = 0;
		int by = N-1;

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!bvisited[i][j] && map[i][j]>=1) {
					
					boolean[][] rvisited  = new boolean[N][N];
					ArrayList<int[]> path = new ArrayList<int[]>();
					
					q.clear();
					bvisited[i][j]=true;
					q.add(new int[] {i,j});
					path.add(new int[] {i,j});
					
					int bcnt=1;
					int rcnt=0;
					
					int c = map[i][j];
					
					int mx = i;
					int my = j;
					
					while(!q.isEmpty()) {
						
						int[] v = q.poll();
						
						for(int d=0;d<4;d++) {
							int nr = v[0]+dr[d];
							int nc = v[1]+dc[d];
							
							if(nr<0 || nr>=N || nc<0 || nc>=N) {
								continue;
							}
							
							int co = map[nr][nc];
							
							if(co==0) {//빨간 폭탄
								if(rvisited[nr][nc]) {
									continue;
								}
								rvisited[nr][nc]=true;
								rcnt+=1;
								q.add(new int[] {nr,nc});
								path.add(new int[] {nr,nc});
								
							}
							else if(co==c) { //c색깔 폭탄
								if(bvisited[nr][nc]){
									continue;
								}
								bvisited[nr][nc]=true;
								bcnt+=1;
								q.add(new int[] {nr,nc});
								path.add(new int[] {nr,nc});
								
								//기준점 구하기
								if(mx<nr) {
									mx=nr;
									my=nc;
								}else if(mx==nr && my>nc) {
									my=nc;
								}
							}
						}
					}
					
					if(path.size()<2) {
						continue;
					}
					
					//더 많은 폭탄 선택
					if(bsize+rsize<path.size()) {
						blist = path;
						bsize = bcnt;
						rsize = rcnt;
						bx = mx;
						by = my;
					}else if(bsize+rsize==path.size()){
						//빨강 폭탄 적은 것 선택
						if(rsize>rcnt) {
							blist = path;
							bsize = bcnt;
							rsize = rcnt;
							bx = mx;
							by = my;
						}else if(rsize==rcnt) {
							//행이 더 큰 것 선택
							if(bx<mx) {
								blist = path;
								bx=mx;
								by=my;
							}
							//열이 더 작은 것 선택
							else if(bx==mx && by>my) {
								blist = path;
								by=my;
							}
						}
					}
				}
			}
		}
		
		//터트릴 수 있는 폭탄이 없다
		if(blist.isEmpty()) {
			return 0;
		}
		
		//터트릴 수 있는 폭탄이 있는 경우
		for(int i=0;i<blist.size();i++) {
			int[] v = blist.get(i);
			map[v[0]][v[1]]=-2;
		}
		return blist.size();
	}
}
