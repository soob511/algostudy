import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {1,1,0,-1,-1,-1,0,1};

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
		
		ArrayList<int[]> booster = new ArrayList<>();
		booster.add(new int[]{N-2,0});
		booster.add(new int[]{N-2,1});
		booster.add(new int[]{N-1,0});
		booster.add(new int[]{N-1,1});
		
		boolean[][] visited;
		int[][] map2;

		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken())-1;
			int P = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N][N];
			map2 = new int[N][N];
			
			for(int i=0;i<booster.size();i++) {
				int[] v = booster.get(i);
				
				//이동규칙에 따라 특수 영양제 이동
				int nr = (v[0]+dr[D]*P+N*P)%N;
				int nc = (v[1]+dc[D]*P+N*P)%N;
				
				booster.set(i, new int[] {nr,nc});
				
				//땅에 특수 영양제 투입
				map[nr][nc]+=1;
			}
			
			for(int i=0;i<booster.size();i++) {
				int[] v = booster.get(i);
				for(int d=1;d<=7;d+=2) {
					int xr = v[0]+dr[d];
					int xc = v[1]+dc[d];
					
					if(xr>=0 && xr<N && xc>=0 && xc<N && map[xr][xc]>0) {
						map2[v[0]][v[1]]+=1;
					}
				}
				
				visited[v[0]][v[1]]=true;
			}
			
			//영양제 맞은 땅 제외하고 높이 2인 나무 2만큼 자르고 영양제 올리기
			booster.clear();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]+=map2[i][j];
					if(!visited[i][j] && map[i][j]>=2) {
						map[i][j]-=2;
						booster.add(new int[] {i,j});
					}
				}
			}
		}
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum+=map[i][j];
			}
		}
		
		System.out.println(sum);
	}

}
