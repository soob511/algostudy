import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_21610_마법사상어와비바라기_김주은2 {
	
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	static int answer = 0;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<int[]> cloud = new ArrayList<>();
		cloud.add(new int[] {N-2,0});
		cloud.add(new int[] {N-2,1});
		cloud.add(new int[] {N-1,0});
		cloud.add(new int[] {N-1,1});
		
		boolean[][] passed;
		int[][] water;
		
		for(int k=0;k<M;k++) {
			
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			
			passed = new boolean[N][N];
			for(int i=0;i<cloud.size();i++) {
				int[] v = cloud.get(i);
				
				int nr = (v[0]+(dr[d]+N)*s)%N;
				int nc = (v[1]+(dc[d]+N)*s)%N;
				
				map[nr][nc]+=1;
				passed[nr][nc]=true;
				cloud.set(i, new int[] {nr,nc});
			}
			
			water = new int[N][N];
			
			for(int i=0;i<cloud.size();i++) {
				int[] v = cloud.get(i);
				
				int cnt=0;
				for(int dir=1;dir<8;dir+=2) {
					int nr = v[0]+dr[dir];
					int nc = v[1]+dc[dir];
					if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==0) {
						continue;
					}
					cnt+=1;
				}
				water[v[0]][v[1]]+=cnt;
			}
			
			cloud.clear();
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]+=water[i][j];
					
					if(!passed[i][j] && map[i][j]>=2) {
						map[i][j]-=2;
						cloud.add(new int[] {i,j});
					}
					
					if(k==M-1) {
						answer+=map[i][j];
					}
				}
			}
		}

		System.out.println(answer);
	
	}

}
