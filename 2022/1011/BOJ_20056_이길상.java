import java.util.*;
import java.io.*;


public class Main {
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static int[][] newD = {{0,2,4,6},{1,3,5,7}};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int K = Integer.parseInt(line[2]);
		
		// 좌표, 중복, 보드
		Queue<int[]> info = new LinkedList<>();
		Queue<int[]> duplicate = new LinkedList<>();
		int[][] count = new int[N][N];
		LinkedList<int[]>[][] board = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = new LinkedList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			int r = Integer.parseInt(line[0])-1;
			int c = Integer.parseInt(line[1])-1;
			int m = Integer.parseInt(line[2]);
			int s = Integer.parseInt(line[3]);
			int d = Integer.parseInt(line[4]);
			board[r][c].add(new int[] {m, s, d});
			info.add(new int[]{r, c});
			count[r][c]++;
		}
		
		while(K-->0) {
			//move
			int S = info.size();
			int[][] temp = new int[N][N];
			
			while(S-->0) {
				// get (r,c)
				int[] e = info.poll();
				int r = e[0], c = e[1];
				
				// pop fireballs
				while(count[r][c]-->0) {
					int[] f = board[r][c].poll();
					int m = f[0], s = f[1], d = f[2];
					
					// new (r,c)
					int nr = r + dr[d]*s;
					int nc = c + dc[d]*s;
					while (nr< 0)nr+=N;
					while (nr>=N)nr-=N;
					while (nc< 0)nc+=N;
					while (nc>=N)nc-=N;
					
					// move
					board[nr][nc].add(new int[] {m, s, d});
					temp[nr][nc]++;
					if (temp[nr][nc] == 1) {
						info.add(new int[] {nr, nc});
					}
					else if (temp[nr][nc] == 2) {
						duplicate.add(new int[] {nr, nc});
					}
				}
			} // end S while
			
			// split
			while(!duplicate.isEmpty()) {
				// get (r,c)
				int[] e = duplicate.poll();
				int r = e[0], c = e[1];
				
				// sum fireballs
				int mass = 0, speed = 0, len = board[r][c].size();
				
				int dir = 0;
				int first = board[r][c].peek()[2]%2;
				
				while(!board[r][c].isEmpty()) {
					int[] f = board[r][c].poll();
					int m = f[0], s = f[1], d = f[2];
					
					// sum
					mass += m;
					speed += s;
					
					//
					if (dir==0 && first!=d%2)
						dir = 1;
				}
				mass/=5;
				speed/=len;
				
				// 질량이 0보다 클 경우
				if (mass>0) {
					for (int nd : newD[dir]) {
						board[r][c].add(new int[] {mass, speed, nd});
					}
					temp[r][c] = 4;
				}
				else {
					temp[r][c] = 0;
				}
			}
			count = temp;
		}// end K while
		
		int total_mass = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int[] e: board[i][j]) {
					total_mass += e[0];
				}
			}
		}
		System.out.println(total_mass);
	}

}
