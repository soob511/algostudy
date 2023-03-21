import java.io.*;
import java.util.*;

public class Main_BJ_23290_마법사상어와복제_김주은 {

	static int[] fr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] fc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static int[] sr = { -1, 0, 1, 0 };
	static int[] sc = { 0, -1, 0, 1 };

	static ArrayList<Integer>[][] map;
	static ArrayList<int[]> initial;
	static int[][] smell = new int[4][4];

	static int sx, sy, nsx, nsy, fsx, fsy;
	
	static boolean first;
	static int max_fish;
	static int[] max_fish_path;
	static boolean[] visited;
	

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		map = setNewMap();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			map[x][y].add(dir);
		}

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;

		while(S-->0){
			// 0. 복제 마법
			copyMap();
			// 1. 물고기 한칸 이동
			moveFish();
			// 2. 상어 3칸 이동
			first=true;
			nsx=fsx=sx;
			nsy=fsy=sy;
			max_fish=0;
			max_fish_path = new int[3];
			moveShark(sx, sy, 0, new int[3]);// 상어 x, 상어 y, 이동 칸 수, 물고기 수
			if(max_fish == 0) {
				sx=fsx;
				sy=fsy;
			} else {
				sx=nsx;
				sy=nsy;
				for(int i=0;i<3;i++) {
					int x = max_fish_path[i]/4;
					int y = max_fish_path[i]%4;
					
					if(map[x][y].size()>0) {
						smell[x][y]=3;
						map[x][y].clear();
					}
				}
			}
			// 3. 물고기 냄새 제거
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(smell[i][j]>0) {
						smell[i][j]-=1;
					}
				}
			}

			// 4. 복제 마법
			for(int i=0;i<initial.size();i++) {
				int[] v = initial.get(i);
				int x = v[0];
				int y = v[1];
				int dir = v[2];
				map[x][y].add(dir);
			}
			
		}

		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cnt += map[i][j].size();
			}
		}
		System.out.println(cnt);

	}

	private static ArrayList<Integer>[][] setNewMap() {
		ArrayList<Integer>[][] map = new ArrayList[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		return map;
	}

	//1. 맵 복제 후 저장
	private static void copyMap() {
		initial = new ArrayList<int[]>();
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<map[i][j].size();k++) {
					initial.add(new int[] {i,j,map[i][j].get(k)});
				}
			}
		}
	}
	
	//2. 물고기 한 칸 움직이기
	private static void moveFish() {
		
		ArrayList<Integer>[][] newmap = setNewMap();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				
				for(int k=0;k<map[i][j].size();k++) {
					
					int dir = map[i][j].get(k);
					boolean move = false;
					for(int d=dir+8;d>dir;d--) {
						int ndir = d%8;
						int nr = i + fr[ndir];
						int nc = j + fc[ndir];
						
						if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || smell[nr][nc] > 0 || ((nr == sx) && (nc == sy))) {
							continue;
						}
						
						newmap[nr][nc].add(ndir);
						move=true;
						break;
					}
					
					if (!move) {
						newmap[i][j].add(dir);
					}
				}
			}
		}
		
		map=newmap;
	}

	private static void moveShark(int x, int y, int move_cnt, int[] path) {

		if(move_cnt==3) {
			if(first) {
				first=false;
				fsx=x;
				fsy=y;
			}
			
			int fish_cnt=0;
			visited = new boolean[16];
			for(int i=0;i<3;i++) {
				if(!visited[path[i]]) {
					visited[path[i]]=true;
					fish_cnt+=map[path[i]/4][path[i]%4].size();
				}
			}
			
			if(max_fish<fish_cnt) {
				max_fish=fish_cnt;
				for(int i=0;i<3;i++) {
					max_fish_path[i]=path[i];
				}
				nsx=x;
				nsy=y;
			}
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + sr[d];
			int ny = y + sc[d];

			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
				continue;
			}

			path[move_cnt] = nx * 4 + ny;
			moveShark(nx, ny, move_cnt + 1, path);
		}
	}


}
