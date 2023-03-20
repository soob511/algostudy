import java.io.*;
import java.util.*;

public class Main_BJ_1799_비숍_김주은 {
	
	static int N;
	static int[] res;
	static int[][] map;
	static boolean[][] visited, isBlack;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		res = new int[2];
		map = new int[N][N];
		visited = new boolean[N][N];
		isBlack = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				isBlack[i][j]=(i%2==0 && j%2==0) || (i%2==1 && j%2==1);
			}
		}

		dfs(0,true,0);
		dfs(0,false,0);
		
		System.out.println(res[0]+res[1]);
		
	}

	private static void dfs(int idx, boolean black, int cnt) {

		for(int i=idx;i<N*N;i++) {
			int x = i/N;
			int y = i%N;
			
			if(map[x][y]==0 || isBlack[x][y]!=black || !check(x,y)) {
				continue;
			}
			
			visited[x][y]=true;
			dfs(i+1,black,cnt+1);
			visited[x][y]=false;
		}
		
		res[black?0:1] = Math.max(res[black?0:1],cnt);
	}

	private static boolean check(int x, int y) {
		//북서방향, 북동방향
		int[] dx = {-1,-1};
		int[] dy = {-1, 1};
		
		for(int d=0;d<2;d++) {
			int nx = x;
			int ny = y;
			while(true) {
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					break;
				}
				if(visited[nx][ny]) {
					return false;
				}
				
				nx+=dx[d];
				ny+=dy[d];
			}
		}
		return true;
	}

	

}
