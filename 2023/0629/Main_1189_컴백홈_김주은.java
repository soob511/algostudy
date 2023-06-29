import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1189_컴백홈_김주은 {
	
	static int R,C,K;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,1,-1,0};
	
	static int cnt=0;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				if(s.charAt(j) =='T') {
					map[i][j]=-1;
				}
			}
		}
		
		visited = new boolean[R][C];
		
		if(map[R-1][0]==0) {
			visited[R-1][0]=true;
			dfs(R-1,0,1);
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int dist) {
		
		if(dist>K) {
			return;
		}
		
		if(x==0 && y==C-1 && dist==K) {
			cnt+=1;
			return;
		}
		
		for(int d=0;d<4;d++) {
			int nr = x+dr[d];
			int nc = y+dc[d];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]==-1 || visited[nr][nc]) {
				continue;
			}

			visited[nr][nc]=true;
			dfs(nr,nc,dist+1);
			visited[nr][nc]=false;
		}
	}

}
