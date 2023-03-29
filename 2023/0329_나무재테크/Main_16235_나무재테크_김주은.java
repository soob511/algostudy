import java.io.*;
import java.util.*;

public class Main_BJ_16235_나무재테크_김주은 {
	
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[][] trees = new ArrayList[N][N];
		int[][] robot = new int[N][N];
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				robot[i][j] =Integer.parseInt(st.nextToken());
				map[i][j]=5;
				trees[i][j]=new ArrayList<>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			trees[x][y].add(z);
		}
		
		while(K-->0) {
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//봄
					Collections.sort(trees[i][j]);
					int dead = -1;
					for(int k=0;k<trees[i][j].size();k++) {
						int v = trees[i][j].get(k);
						if(map[i][j]>=v) {
							map[i][j]-=v;
							trees[i][j].set(k, v+1);
						}else {
							dead=k;
							break;
						}
					}
					//여름
					if(dead>=0) {
						for(int k=trees[i][j].size()-1;k>=dead;k--) {
							int v = trees[i][j].get(k);
							map[i][j]+=v/2;
							trees[i][j].remove(k);
						}
					}
				}
			}
			
			//가을
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0;k<trees[i][j].size();k++) {
						int v = trees[i][j].get(k);
						
						if(v%5==0) {
							for(int d=0;d<8;d++) {
								int nr = i+dr[d];
								int nc = j+dc[d];
								
								if(nr<0 || nr>=N || nc<0 || nc>=N) {
									continue;
								}
								
								trees[nr][nc].add(1);
							}
						}
					}
				}
			}
			
			//겨울
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]+=robot[i][j];
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer += trees[i][j].size();
			}
		}
		
		System.out.println(answer);
	}

}
