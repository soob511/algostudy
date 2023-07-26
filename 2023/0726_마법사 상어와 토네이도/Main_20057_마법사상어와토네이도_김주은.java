import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_20057_마법사상어와토네이도_김주은2 {
	
	static int N;
	static int[][] map;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		int start=0,end=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				start+=map[i][j];
			}
		}
		
		ArrayDeque<int[]> path = getPath();
		int nr,nc,move;
		
		while(!path.isEmpty()) {
			
			int[] v = path.pollLast();
			int r = v[0]/N;
			int c = v[0]%N;
			int dir = v[1];
			
			//y위치
			int yr = r+dr[dir];
			int yc = c+dc[dir];
			
			//알파위치
			int ar = r+dr[dir]*2;
			int ac = c+dc[dir]*2;
			
			//y에 있던 모래 양
			int sandY = map[yr][yc];
			//y에서 날아간 모래 양
			int moved = 0;
			
			//왼쪽1%위치
			move = (int) (sandY*0.01);

			nr = r+dr[(dir+3)%4];
			nc = c+dc[(dir+3)%4];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//오른쪽1%위치
			nr = r+dr[(dir+1)%4];
			nc = c+dc[(dir+1)%4];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//왼쪽7%위치
			move = (int) (sandY*0.07);
			
			nr = yr+dr[(dir+3)%4];
			nc = yc+dc[(dir+3)%4];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//오른쪽7%위치
			nr = yr+dr[(dir+1)%4];
			nc = yc+dc[(dir+1)%4];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//왼쪽2%위치
			move = (int) (sandY*0.02);

			nr = yr+dr[(dir+3)%4]*2;
			nc = yc+dc[(dir+3)%4]*2;
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//오른쪽2%위치
			nr = yr+dr[(dir+1)%4]*2;
			nc = yc+dc[(dir+1)%4]*2;
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//왼쪽10%위치
			move = (int) (sandY*0.1);

			nr = ar+dr[(dir+3)%4];
			nc = ac+dc[(dir+3)%4];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//오른쪽10%위치
			nr = ar+dr[(dir+1)%4];
			nc = ac+dc[(dir+1)%4];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;

			//5%위치
			move = (int) (sandY*0.05);

			nr = yr+dr[dir]*2;
			nc = yc+dc[dir]*2;
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc]+=move;
			}
			moved+=move;
			
			//알파위치
			if(ar>=0 && ar<N && ac>=0 && ac<N) {
				map[ar][ac]+=(sandY-moved);
			}
			
			map[yr][yc]=0;
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				end +=map[i][j];
			}
		}
		
		System.out.println(start-end);
		
	}

	private static ArrayDeque<int[]> getPath() {

		boolean[][] visited = new boolean[N][N];
		ArrayDeque<int[]> path = new ArrayDeque<>();
		int dir = 0;
		
		path.add(new int[] {0,dir});
		visited[0][0]=true;
		
		
		for(int i=1;i<N*N;i++) {
			
			int nr = path.peekLast()[0]/N + dr[dir];
			int nc = path.peekLast()[0]%N + dc[dir];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) {
				dir=(dir+1)%4;
				nr = path.peekLast()[0]/N + dr[dir];
				nc = path.peekLast()[0]%N + dc[dir];
			}
			visited[nr][nc]=true;
			path.add(new int[] {nr*N+nc,(dir+2)%4});
		}
		
		path.pollFirst();
		
		return path;
	}

}
