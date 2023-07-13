import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map;
	static ArrayList<Integer> virus = new ArrayList<>();
	static int virusCnt;
	static int zeroCnt=0;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static int answer = -1;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					virus.add(i*N+j);
				}else if(map[i][j]==0) {
					zeroCnt+=1;
				}
			}
		}
		virusCnt = virus.size();
		
		if(zeroCnt==0) {
			System.out.println(0);
			return;
		}
		
		//바이러스 선택
		selectVirus(0,0,new int[M]);
		
		System.out.println(answer);
		
	}

	private static void selectVirus(int cnt, int idx, int[] v) {

		if(cnt==M) {
			//선택된 바이러스 전파하기
			spread(v);
			return;
		}
		
		for(int i=idx;i<virusCnt;i++) {
			v[cnt]=i;
			selectVirus(cnt+1,i+1,v);
		}
	}

	private static void spread(int[] v) {
		
		int zeros = zeroCnt;

		//지도 복사
		boolean[][] visited = new boolean[N][N];

		//선택된 바이러스 표기 및 큐 넣기
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for(int i=0;i<M;i++) {
			int sel = virus.get(v[i]);
			visited[sel/N][sel%N]=true;
			q.add(sel);
		}
		
		int time = 0;
		while(!q.isEmpty()) {
			
			int s = q.size();
			
			while(s-->0) {

				int vertex = q.poll();
				
				for(int d=0;d<4;d++) {
					int nr = vertex/N+dr[d];
					int nc = vertex%N+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]==1) {
						continue;
					}
					
					visited[nr][nc]=true;
					q.add(nr*N+nc);
					if(map[nr][nc]==0) {
						zeros-=1;
					}
					
					if(zeros==0) {
						if(answer<0) {
							answer = time+1;
						} else {
							answer = Math.min(answer, time+1);
						}
						return;
					}
					
				}
				
			}
			
			time+=1;
		}
		
	}

}
