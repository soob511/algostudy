import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1743_음식물피하기_김주은 {
	
	static int N,M;
	static boolean[][] map, visited;
	static int cnt,max=0;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y]=true;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(visited[i][j] || !map[i][j]) {
					continue;
				}
				cnt=0;
				visited[i][j]=true;
				++cnt;
				dfs(i,j);
				max = Math.max(cnt, max);
			}
		}
		
		System.out.println(max);
	}

	private static void dfs(int i, int j) {

		for(int d=0;d<4;d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || !map[nr][nc] || visited[nr][nc]) {
				continue;
			}
			
			++cnt;
			visited[nr][nc]=true;
			dfs(nr,nc);
		}
		
	}

}
