import java.io.*;
import java.util.*;


public class Main_BJ_2583_영역구하기_김주은 {
	
	static int M,N;
	static boolean[][] map;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int area_cnt;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int i=a;i<c;i++) {
				for(int j=b;j<d;j++) {
					map[i][j]=true;
				}
			}
			
		}

		int count = 0;
		ArrayList<Integer> area = new ArrayList();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==false) {
					++count;
					area_cnt = 0;
					dfs(i,j);
					area.add(area_cnt);
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(area);
		for(Integer x : area) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
		
	}

	private static void dfs(int i, int j) {
		
		map[i][j]=true;
		++area_cnt;
		
		for(int d=0;d<4;d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==false) {
				dfs(nr,nc);
			}
		}
		
	}

}
