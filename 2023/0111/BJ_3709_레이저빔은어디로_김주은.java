import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3709_레이저빔은어디로_김주은 {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static int lx,ly,d;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			map = new int[n+2][n+2];
			
			for(int i=0;i<r;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			st = new StringTokenizer(br.readLine());
			lx = Integer.parseInt(st.nextToken());
			ly = Integer.parseInt(st.nextToken());
			
			//북동남서 = 0123
			d=-1;
			if(lx==0) d=2;
			else if(ly==n+1) d=3;
			else if(lx==n+1) d=0;
			else if(ly==0) d=1;
			
			while(true) {
				move();
				if(lx==0 || lx==n+1 || ly==0 || ly==n+1) {
					break;
				}
			}
			
			sb.append(lx).append(" ").append(ly).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void move() {

		lx += dr[d];
		ly += dc[d];
		
		if(map[lx][ly]==1) {
			d = (d+1)%4;
		}
	}

}
