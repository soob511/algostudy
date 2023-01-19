import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_2573_빙산_김주은 {
	
	static int N,M;
	static int[][] berg;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		berg = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				berg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		LinkedList<int[]> melts;
		int time=0;
		while(true) {
			//녹은 후 빙하값 저장
			melts = new LinkedList<int[]>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(berg[i][j]>0) {
						int melt=0;
						for(int d=0;d<4;d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
							if(nr<0 || nr>=N ||nc<0 || nc>=M || berg[nr][nc]>0) {
								continue;
							}
							++melt;
						}
						melts.add(new int[] {i,j,berg[i][j]-melt<0?0:berg[i][j]-melt});
					}
				}
			}
			//녹은 후 빙하값 반영
			while(!melts.isEmpty()) {
				int[] v = melts.poll();
				int i = v[0];
				int j = v[1];
				int val = v[2];
				
				berg[i][j]=val;
			}
			
			++time;
			
			int berg_cnt = bergs_count();
			
			if(berg_cnt==0) {
				time=0;
				break;
			} else if(berg_cnt>=2) {
				break;
			}
			
		}
		
		System.out.println(time);
	}

	//빙하 갯수 세기
	private static int bergs_count() {
		int cnt=0;
		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(berg[i][j]>0 && !visited[i][j]) {
					dfs(i,j,visited);
					++cnt;
				}
			}
		}
		return cnt;
	}

	private static void dfs(int i, int j, boolean[][] visited) {
		visited[i][j]=true;
		for(int d=0;d<4;d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			if(nr<0 || nr>=N ||nc<0 || nc>=M || visited[nr][nc] || berg[nr][nc]==0) {
				continue;
			}
			dfs(nr,nc,visited);
		}
	}

}
