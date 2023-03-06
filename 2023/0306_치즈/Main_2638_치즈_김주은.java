import java.util.*;
import java.io.*;

public class Main_BJ_2638_치즈_김주은 {

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		boolean[][] visited;
		int[][] air;
		int cheeze=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					++cheeze;
				}
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		int time=0;
		
		while(cheeze>0) {

			air = new int[N][M];
			visited = new boolean[N][M];
			
			queue.add(new int[] {0,0});
			visited[0][0]=true;
			
			while(!queue.isEmpty()) {
				int[] v = queue.poll();
				
				for(int d=0;d<4;d++) {
					int nr = v[0]+dr[d];
					int nc = v[1]+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) {
						continue;
					}
					
					if(map[nr][nc]==0) {
						visited[nr][nc]=true;
						queue.add(new int[] {nr,nc});
					} else {//치즈
						air[nr][nc]+=1;
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(air[i][j]>=2) {
						map[i][j]=0;
						--cheeze;
					}
				}
			}
			
			++time;
		}
		
		System.out.println(time);
		
	}

}
