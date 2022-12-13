import java.io.*;
import java.util.*;

public class Main_BJ_7576_토마토_김주은 {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[N][M];
		
		int unripen = 0;
		int time = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==0) {
					++unripen;
				} else if(box[i][j]==1) {
					queue.add(new int[] {i,j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			
			int s = queue.size();
			while(s-->0) {
				
				int[] v = queue.poll();
				
				for(int d=0;d<4;d++) {
					
					int nr = v[0]+dr[d];
					int nc = v[1]+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || box[nr][nc]!=0) {
						continue;
					}
					
					box[nr][nc]=1;
					--unripen;
					queue.add(new int[] {nr,nc});
				}
			}
			++time;
		}
		
		if(unripen>0) {
			System.out.println(-1);
		} else {
			System.out.println(time-1);
		}
		
	}

}
