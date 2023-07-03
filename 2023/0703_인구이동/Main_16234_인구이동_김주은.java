import java.io.*;
import java.util.*;

public class Main_BJ_16234_인구이동_김주은 {
	
	static int N,L,R;
	static int[][] map;
	
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static ArrayList<Integer> path = new ArrayList<>();
	static boolean[][] visited;
	
	static int time=0;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			
			boolean move = false;
			
			visited= new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && merge(i,j)) {
						move=true;
					}
				}
			}
			
			if(!move) {
				break;
			}
			
			time+=1;
			
		}
		
		System.out.println(time);
	}

	private static boolean merge(int i, int j) {

		q.clear();
		path.clear();
		
		q.add(i*N+j);
		path.add(i*N+j);
		visited[i][j]=true;
		
		int sum = map[i][j];
		int cnt = 1;
		
		while(!q.isEmpty()) {
			
			int v = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = v/N+dr[d];
				int nc = v%N+dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) {
					continue;
				}
				
				int diff = Math.abs(map[v/N][v%N]-map[nr][nc]);
				if(L<=diff && diff<=R) {
					sum+=map[nr][nc];
					cnt+=1;
					visited[nr][nc]=true;
					q.add(nr*N+nc);
					path.add(nr*N+nc);
				}
			}
		}
		
		if(cnt==1) {
			return false;
		}
		
		sum/=cnt;
		for(int idx=0;idx<path.size();idx++) {
			int v = path.get(idx);
			map[v/N][v%N]=sum;
		}
		
		return true;
	
	}

}
