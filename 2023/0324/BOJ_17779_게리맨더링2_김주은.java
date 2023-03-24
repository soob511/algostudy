import java.io.*;
import java.util.*;

public class Main_BJ_17779_게리맨더링2_김주은 {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new ArrayDeque<>();
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min_diff = N*N*100;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int d1=1;j-d1>=0 && i+d1<N;d1++) {
					for(int d2=1;j+d2<N && i+d1+d2<N;d2++) {
						min_diff = Math.min(min_diff,countDistrict(i,j,d1,d2));
					}
				}
			}
		}
		
		System.out.println(min_diff);
	}

	private static int countDistrict(int x, int y, int d1, int d2) {

		int min = N*N*100;
		int max = 0;
		
		visited = new boolean[N][N];
		
		//5번 구역
		visited[x][y]=true;
		int c5=map[x][y];
		//다이아몬드 왼쪽 탐색
		for(int i=1;i<=d1;i++) {
			visited[x+i][y-i]=true;
			c5+=map[x+i][y-i];
			if(i==d1) {
				for(int j=1;j<=d2;j++) {
					visited[x+i+j][y-i+j]=true;
					c5+=map[x+i+j][y-i+j];
				}
			}
		}
		//다이아몬드 오른쪽 탐색
		for(int i=1;i<=d2;i++) {
			visited[x+i][y+i]=true;
			c5+=map[x+i][y+i];
			if(i==d2) {
				for(int j=1;j<=d1;j++) {
					if(!visited[x+i+j][y+i-j]) {
						visited[x+i+j][y+i-j]=true;
						c5+=map[x+i+j][y+i-j];
					}
				}
			}
		}
		//다이아몬드 내부 탐색
		for(int i=x+1;i<x+d1+d2;i++) {
			boolean count=false;
			for(int j=0;j<N;j++) {
				if(visited[i][j] && !count) {
					count=true;
					continue;
				} else if(visited[i][j] && count){
					count=false;
					continue;
				}
				if(count) {
					visited[i][j]=true;
					c5+=map[i][j];
				}
				
			}
		}
		max = Math.max(max, c5);
		min = Math.min(min, c5);

		//1번 구역
		int c1 = count(0,0,0,x+d1-1,0,y);
		max = Math.max(max, c1);
		min = Math.min(min, c1);
		//2번 구역
		int c2 = count(0,N-1,0,x+d2,y+1,N-1);
		max = Math.max(max, c2);
		min = Math.min(min, c2);
		//3번 구역
		int c3 = count(N-1,0,x+d1,N-1,0,y-d1+d2-1);
		max = Math.max(max, c3);
		min = Math.min(min, c3);
		//4번 구역
		int c4 = count(N-1,N-1,x+d2+1,N-1,y-d1+d2,N-1);
		max = Math.max(max, c4);
		min = Math.min(min, c4);
		
		return max-min;
	}

	private static int count(int sx, int sy, int r1, int r2, int c1, int c2) {
		
		q.clear();
		
		int c=0;
		visited[sx][sy]=true;
		q.add(new int[] {sx,sy});
		
		while(!q.isEmpty()) {
			
			int[] v = q.poll();
			c+=map[v[0]][v[1]];
			
			for(int d=0;d<4;d++) {
				
				int nr = v[0]+dr[d];
				int nc = v[1]+dc[d];
				
				if(nr>=r1 && nr<=r2 && nc>=c1 && nc<=c2 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					q.add(new int[] {nr,nc});
				}
			}
		}
		
		return c;
	}

}
