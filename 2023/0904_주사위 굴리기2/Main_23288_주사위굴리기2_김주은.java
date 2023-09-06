import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_BJ_23288_주사위굴리기2_김주은 {
	
	static int N,M,K;
	
	//동, 남, 서, 북
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		//1. 점수 계산
		int[][] scores = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j]) {
					continue;
				}
				ArrayDeque<Integer> path = new ArrayDeque<>();
				ArrayDeque<Integer> q = new ArrayDeque<>();
				path.add(i*M+j);
				q.add(i*M+j);
				visited[i][j]=true;
				int cnt=1;
				
				while(!q.isEmpty()) {
					
					int v = q.poll();
					
					for(int d=0;d<4;d++) {
						int nx = v/M +dr[d];
						int ny = v%M +dc[d];
						if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny] || map[nx][ny]!=map[i][j]) {
							continue;
						}
						path.add(nx*M+ny);
						q.add(nx*M+ny);
						visited[nx][ny]=true;
						cnt+=1;
					}
				}
				cnt*=map[i][j];
				
				while(!path.isEmpty()) {
					int v = path.poll();
					scores[v/M][v%M]=cnt;
				}
				
			}
		}
		
		//2. 주사위 k번 굴리기
		
		int x=0,y=0;
		int top=1,bottom=6;
		int[] side = {3,5,4,2};//동, 남, 서, 북
		int dir = 0;
		
		int answer = 0;
		for(int k=0;k<K;k++) {
			
			int nx = x+dr[dir];
			int ny = y+dc[dir];
			
			//칸 밖일 경우 반대 방향
			if(nx<0 || nx>=N || ny<0 || ny>=M) {
				dir=(dir+2)%4;
				nx = x+dr[dir];
				ny = y+dc[dir];
			}
			
			int temp_bottom = bottom;
			bottom = side[dir];
			
			int temp_top = top;
			top = side[(dir+2)%4];
			
			side[(dir+2)%4]=temp_bottom;
			side[dir]=temp_top;
			
			//1. 점수 획득
			answer+=scores[nx][ny];
			
			//2. 이동 방향 결정
			
			x = nx;
			y = ny;
			
			int A = bottom;
			int B = map[nx][ny];
			if(A>B) {
				dir=(dir+1)%4;
			} else if(A<B) {
				dir=(dir+3)%4;
			}
			

		}
		
		System.out.println(answer);
		
	}

}
