import java.io.*;
import java.util.*;

public class Main_BJ_14391_종이조각_김주은2 {
	
	static int N,M;
	
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	
	static int[][] map;
	
	static boolean[][] visited;
	
	static int max=0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<(1<<(N*M));i++) {
			//0카운트
			int sum=0;
			for(int x=N-1;x>=0;x--) {
				int cnt=0;
				int v=0;
				for(int y=M-1;y>=0;y--) {
					int move = x*M+y;
					if((i&(1<<move))==0) {
						cnt+=1;
						v*=10;
						v+=map[(N*M-1-move)/M][(N*M-1-move)%M];
					}else {
						if(cnt>0) {
							cnt=0;
							sum+=v;
							v=0;
						}
					}
				}
				if(cnt>0) {
					sum+=v;
				}
			}
			//1카운트
			for(int y=M-1;y>=0;y--) {
				int cnt=0;
				int v=0;
				for(int x=N-1;x>=0;x--) {
					int move = x*M+y;
					if((i&(1<<move))==(1<<move)) {
						cnt+=1;
						v*=10;
						v+=map[(N*M-1-move)/M][(N*M-1-move)%M];
					}else {
						if(cnt>0) {
							cnt=0;
							sum+=v;
							v=0;
						}
					}
				}
				if(cnt>0) {
					sum+=v;
				}
			}
			
			if(sum>max) {
				max=sum;
			}
		}
		
		System.out.println(max);
		
	}

}
