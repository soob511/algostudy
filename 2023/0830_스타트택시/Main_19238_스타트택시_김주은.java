import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_BJ_19238_스타트택시_김주은3 {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static int N,M;
	static int[][] map;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int F = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=-Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken())-1;
		int sy = Integer.parseInt(st.nextToken())-1;
		
		int[][] start = new int[M][2];
		int[][] end = new int[M][2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			start[i][0]=Integer.parseInt(st.nextToken())-1;
			start[i][1]=Integer.parseInt(st.nextToken())-1;
			map[start[i][0]][start[i][1]]=i+1;
			end[i][0]=Integer.parseInt(st.nextToken())-1;
			end[i][1]=Integer.parseInt(st.nextToken())-1;
		}
		
		while(move()) {
			
			//1. 가장 가까운 사람 찾기
			int closest_person = 0;
			int closest_dist = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>0) {
						int dist = calc_dist(sx,sy,i,j);
						if(dist>=0) {
							if(dist<closest_dist) {
								closest_dist = dist;
								closest_person = map[i][j];
							}
						}
					}
				}
			}
			
			//2. 사람은 있으나, 도달 불가
			if(closest_person==0) {
				System.out.println(-1);
				return;
			}
			
			//3. 연료 체크 및 승객에게 이동
			if(F>=closest_dist) {
				F-=closest_dist;
				sx = start[closest_person-1][0];
				sy = start[closest_person-1][1];
				map[sx][sy]=0;
			}else {
				System.out.println(-1);
				return;
			}
			
			//4. 연료 체크 및 승객의 목적지로 이동
			int dist = calc_dist(sx,sy,end[closest_person-1][0],end[closest_person-1][1]);
			if(dist<0 || F<dist) {
				System.out.println(-1);
				return;
			} else {
				F+=dist;
				sx = end[closest_person-1][0];
				sy = end[closest_person-1][1];
			}

		}
		
		System.out.println(F);
	}

	private static boolean move() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>0) {
					return true;
				}
			}
		}
		return false;
	}

	private static int calc_dist(int sx, int sy, int ex, int ey) {

			ArrayDeque<int[]> q = new ArrayDeque<int[]>();
			boolean[][] visited = new boolean[N][N];
			q.add(new int[] {sx,sy});
			visited[sx][sy]=true;
			
			int time = 0;
			while(!q.isEmpty()) {
				
				int s = q.size();
				while(s-->0) {
					int[] v = q.poll();
					
					if(v[0]==ex && v[1]==ey) {
						return time;
					}
					
					for(int d=0;d<4;d++) {
						int nx = v[0]+dr[d];
						int ny = v[1]+dc[d];
						
						if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]<0) {
							continue;
						}
						
						q.add(new int[] {nx,ny});
						visited[nx][ny]=true;
					}
				}
				
				time+=1;
				
			}
			
			return -1;
			
	}

}
