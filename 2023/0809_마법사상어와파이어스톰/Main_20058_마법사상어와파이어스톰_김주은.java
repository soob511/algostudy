import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static int N;
	static int[][] map;
	static int group;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		N = 1<<n;
		int Q = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			int l = Integer.parseInt(st.nextToken());
			int L = 1<<l;
			
			//1. 회전
			int[][] map2 = new int[N][N];
			for(int x=0;x<N;x+=L) {
				for(int y=0;y<N;y+=L) {
					//내부 사각형 회전
					for(int c=y,a=x;c<y+L&&a<x+L;c++,a++) {
						for(int r=x+L-1,b=y;r>=x&&b<y+L;r--,b++) {
							map2[a][b]=map[r][c];
						}
					}
					
				}
			}
			map = map2;
			
			//2. 얼음 감소
			int[][] map3 = new int[N][N];
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					
					if(map2[x][y]==0) {
						continue;
					}
					
					int cnt = 0;
					for(int d=0;d<4;d++) {
						int nx = x+dr[d];
						int ny = y+dc[d];
						
						if(nx<0 || nx>=N || ny<0 || ny>=N || map2[nx][ny]==0) {
							continue;
						}
						cnt+=1;
					}
					
					map3[x][y]=cnt<=2?map[x][y]-1:map[x][y];
				}
			}
			map = map3;
			
		}
		
		//1. 남아있는 얼음 합
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum+=map[i][j];
			}
		}
		
		//2. 가장 큰 덩어리의 칸
		int max = 0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] || map[i][j]==0) {
					continue;
				}
				group = 1;
				visited[i][j]=true;
				dfs(i,j);
				max = Math.max(max, group);
			}
		}
		
		System.out.println(sum);
		System.out.println(max);
		
	}

	private static void dfs(int x, int y) {

		for(int d=0;d<4;d++) {
			int nx = x+dr[d];
			int ny = y+dc[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]==0) {
				continue;
			}
			
			visited[nx][ny]=true;
			group+=1;
			dfs(nx,ny);
		}
	}

}
