import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17836_공주님을구해라_김주은 {

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken())+1;
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][][] visited = new boolean[2][N][M];
		
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {0,0,0});//칼없는 상태
		visited[0][0][0]=true;
		
		int time=0;
		
		while(!q.isEmpty() && ++time<=T) {
			
			int s = q.size();
			
			while(s-->0) {
				
				int[] v = q.poll();
				
				if(v[0]==N-1 && v[1]==M-1) {
					System.out.println(time-1);
					return;
				}
				
				for(int d=0;d<4;d++) {
					int nr = v[0]+dr[d];
					int nc = v[1]+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) {
						continue;
					}
					
					if(v[2]==0) { //칼 못만남
						
						if(map[nr][nc]==1 || visited[0][nr][nc]) { //이미 방문
							continue;
						}
						
						if(map[nr][nc]==0) {
							visited[0][nr][nc]=true;
							q.add(new int[] {nr,nc,0});
						} else if(map[nr][nc]==2) {
							visited[0][nr][nc]=true;
							visited[1][nr][nc]=true;
							q.add(new int[] {nr,nc,1});
						}
						
						
					} else {//칼 만남
						
						if(visited[1][nr][nc]) { //이미 방문
							continue;
						}
						
						visited[1][nr][nc]=true;
						q.add(new int[] {nr,nc,1});
						
					}
				}
			}
			
		}
		
		System.out.println("Fail");
		
	}

}
