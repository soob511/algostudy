import java.io.*;
import java.util.*;

public class Main_14391_종이조각_김주은 {
	
	static int N,M;
	
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	
	static int[][] map;
	
	static boolean[][] visited;
	
	static int max=0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		dfs(0,0);
		
		System.out.println(max);
		
	}

	private static void dfs(int num, int sum) {
		
		if(num==N*M) {
			if(max<sum) {
				max=sum;
			}
			return;
		}
		
		int i = num/M;
		int j = num%M;
		
		if(visited[i][j]) {
			dfs(num+1,sum);
		} else {
			
			int v, nx, ny;
			
			v = map[i][j];
			visited[i][j]=true;
			dfs(num+1,sum+v);
			visited[i][j]=false;
			
			//아래로 늘릴 수 있는 경우
			for(int c=1;c<N-i;c++) {
				nx = i+c;
				ny = j;
				v*=10;
				v+=map[nx][ny];
				for(int d=1;d<=c;d++) {
					visited[i+d][j]=true;
				}
				dfs(num+1,sum+v);
				for(int d=1;d<=c;d++) {
					visited[i+d][j]=false;
				}
			}
			
			//오른쪽으로 늘릴 수 있는 경우
			v = map[i][j];
			for(int c=1;c<M-j;c++) {
				nx=i;
				ny=j+c;
				if(visited[nx][ny]) {
					return;
				}
				v*=10;
				v+=map[nx][ny];
				for(int d=1;d<=c;d++) {
					visited[i][j+d]=true;
				}
				dfs(num+1,sum+v);
				for(int d=0;d<=c;d++) {
					visited[i][j+d]=false;
				}
			}
			
			
		}

	}


}
