import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_17141_연구소2_김주은 {
	
	static int[][] map;
	static int N, M;
	static ArrayList<int[]> virus;
	static int[] arr;
	static int[] temp;
	static int min_time=1111111111;
	static boolean cannot_spread = false;
	static int wall=0;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		virus = new ArrayList<int[]>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					map[i][j]=0;
					virus.add(new int[] {i,j});
				} else if(map[i][j]==1) {
					++wall;
				}
			}
		}
		
		temp = new int[M];
		
		combination(0,0);
		
		System.out.println(cannot_spread?min_time:-1);
	}

	private static void combination(int cnt, int idx) {
		
		if(cnt==M) {
			int time = spread();
			if(time!=-1) {
				min_time = Math.min(min_time, time);
				cannot_spread=true;
			}
			return;
		}
		
		for(int i=idx;i<virus.size();i++) {
			temp[cnt]=i;
			combination(cnt+1, i+1);
		}
	}

	private static int spread() {
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		
		int virus_cnt=0;
		
		for(int i=0;i<M;i++) {
			int[] v = virus.get(temp[i]);
			visited[v[0]][v[1]]=true;
			++virus_cnt;
			queue.add(new int[] {v[0], v[1]});
		}
		
		int time=0;
		while(!queue.isEmpty()) {
			
			int s = queue.size();
			while(s-->0) {
				
				int[] v = queue.poll();
				
				for(int d=0;d<4;d++) {
					int nr = v[0]+dr[d];
					int nc = v[1]+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]==1) {
						continue;
					}
					
					visited[nr][nc]=true;
					++virus_cnt;
					queue.add(new int[] {nr,nc});
				}
				
			}
			++time;
		}

		if(virus_cnt+wall<N*N) {
			return -1;
		} else {
			return time-1;
		}
		
	}

}
