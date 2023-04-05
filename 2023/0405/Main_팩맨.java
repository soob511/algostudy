import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[][] map = new ArrayList[4][4];
	static Queue<int[]> mq = new ArrayDeque<>();
	
	static int[][] deads = new int[4][4];
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	static int[] pr = {-1,0,1,0};
	static int[] pc = {0,-1,0,1};
	
	static int M,T;
	static int mx, my;
	
	static int maxCnt;
	static int[] maxPath;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		mx = Integer.parseInt(st.nextToken())-1;
		my = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				map[i][j]=new ArrayList<>();
			}
		}
		
		//몬스터 맵 입력
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			map[x][y].add(dir);
		}
		
		for(int t=0;t<T;t++) {
			
			//1. 몬스터 복제 시도
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					for(int k=0;k<map[i][j].size();k++) {
						int v = map[i][j].get(k);
						mq.add(new int[] {i,j,v});
					}
				}
			}
			
			//2. 몬스터 이동
			ArrayList<Integer>[][] map2 = new ArrayList[4][4];
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					map2[i][j]=new ArrayList<>();
				}
			}
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					for(int k=0;k<map[i][j].size();k++) {
						int v = map[i][j].get(k);
						
						boolean noMove=true;
						for(int d=v;d<v+8;d++) {
							int nr = i+dr[d%8];
							int nc = j+dc[d%8];
							
							if(nr<0 || nr>=4 || nc<0 || nc>=4 || (mx==nr && my==nc) || deads[nr][nc]>0) {
								continue;
							}
							
							noMove=false;
							map2[nr][nc].add(d%8);
							break;
						}
						
						if(noMove) {
							map2[i][j].add(v);
						}
					}
				}
			}
			map = map2;
			
			//3. 팩맨이동 && 시체 생성
			maxCnt = -1;
			maxPath = new int[3];
			dfs(0, mx, my, new int[3]);
			for(int i=0;i<3;i++) {
				if(map[maxPath[i]/4][maxPath[i]%4].size()>0) {
					map[maxPath[i]/4][maxPath[i]%4].clear();
					deads[maxPath[i]/4][maxPath[i]%4]=3;
				}
			}
			mx = maxPath[2]/4;
			my = maxPath[2]%4;
			
			//4. 시체 소멸
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(deads[i][j]>0) {
						deads[i][j]-=1;
					}
				}
			}
			
			//5. 몬스터 복제 완성
			while(!mq.isEmpty()) {
				int[] v = mq.poll();
				map[v[0]][v[1]].add(v[2]);
			}
			
		}
		
		int answer = 0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				answer+=map[i][j].size();
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int cnt,int x, int y, int[] path) {
		
		if(cnt==3) {
			
			int sum = 0;
			boolean[] visited = new boolean[16];
			for(int i=0;i<3;i++) {
				if(!visited[path[i]]) {
					visited[path[i]]=true;
					sum += map[path[i]/4][path[i]%4].size();
				}
			}
			
			if(maxCnt<sum) {
				maxCnt=sum;
				for(int i=0;i<3;i++) {
					maxPath[i]=path[i];
				}
			}
			return;
		}
		
		for(int d=0;d<4;d++) {
			int nr = x+pr[d];
			int nc = y+pc[d];
			
			if(nr<0 || nr>=4 || nc<0 || nc>=4) {
				continue;
			}
			
			path[cnt]=nr*4+nc;
			dfs(cnt+1, nr,nc,path);
		}
	}

}
