import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_1245_농장관리_김주은 {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static LinkedList<int[]> lvl;
	
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]) {
					lvl = new LinkedList<>();
					//1. 같은 높이를 가지는 층을 모두 파악하여 lvl에 담기
					visited[i][j]=true;
					dfs(i,j);
					//2. 이 층이 봉우리인지 파악
					if(isPeak()) {
						++cnt;
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}

	private static boolean isPeak() {
		while(!lvl.isEmpty()) {
			int[] v = lvl.poll();
			
			for(int d=0;d<8;d++) {
				int nr = v[0] + dr[d];
				int nc = v[1] + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) {
					continue;
				}
				
				if(map[v[0]][v[1]]<map[nr][nc]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void dfs(int i, int j) {
		
		lvl.add(new int[] {i,j});

		for(int d=0;d<8;d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || map[i][j]!=map[nr][nc]) {
				continue;
			}
			
			visited[nr][nc] =true;
			dfs(nr,nc);
		}
		
	}

}
