import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14503_로봇청소기_김주은2 {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	static int cnt=0;

	public static void main(String[] args) throws Exception{

		BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(brr.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		st = new StringTokenizer(brr.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(brr.readLine());
			for(int j=0;j<M;j++) {
				room[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(!visited[r][c]) {
				visited[r][c]=true;
				cnt+=1;
			}
			
			
			boolean dirty=false;
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(room[nr][nc]==0 && !visited[nr][nc]) {
					dirty=true;
					break;
				}
			}
			
			//주변 4칸 중 청소되지 않은 빈칸이 있는 경우
			if(dirty) {
				dir = (dir+3)%4;
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				
				if(!visited[nr][nc] && room[nr][nc]==0) {
					r=nr;
					c=nc;
				}
			} 
			//주변 4칸 중 청소되지 않은 빈칸이 없는 경우
			else {
				int back = (dir+2)%4;
				int br=r+dr[back];
				int bc=c+dc[back];
				if(room[br][bc]==1) {
					System.out.println(cnt);
					return;
				}
				r=br;
				c=bc;
			}
			
		}
		
	}

}
