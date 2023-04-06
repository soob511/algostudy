import java.io.*;
import java.util.*;

public class Main {
	
	static class Pos{
		int x;
		int y;
		int dir;
		
		public Pos(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static ArrayList<Integer>[][] map;
	static boolean[][] treemap;
	static ArrayList<Pos> tagger = new ArrayList<>();
	static int tIdx = 0;
	static int score = 0;
	
	//하,우,상,좌
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken()); //이동방법
			
			if(z==1) {
				map[x][y].add(1);
			} else {
				map[x][y].add(0);
			}
		}
		
		treemap = new boolean[N][N];
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			treemap[x][y]=true;
		}
		
		//술래 경로 정해놓기
		boolean[][] visited = new boolean[N][N];
		int d = 0;
		int n = 0;
		int x = 0;
		int y = 0;
		while(n<N*N-1) {
			visited[x][y]=true;
			int nx = x+dr[d];
			int ny = y+dc[d];

			if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) {
				d = (d+1)%4;
				nx = x+dr[d];
				ny = y+dc[d];
			}
			//역방향 tagger추가
			tagger.add(new Pos(x,y,d));
			
			//순방향 tagger추가
			if(n>=1) {
				int size = tagger.size();
				Pos a = tagger.get(size-1);
				Pos b = tagger.get(size-2);
				
				int dx = b.x-a.x;
				int dy = b.y-a.y;
				int ddir = 0;
				for(int dd=0;dd<4;dd++) {
					if(dx==dr[dd] && dy==dc[dd]) {
						ddir = dd;
					}
				}
				tagger.add(0,new Pos(x,y,ddir));
			}
			
			x=nx;
			y=ny;
			++n;
		}
		tagger.add(0,new Pos(N/2,N/2,2));

		for(int k=0;k<K;k++) {
			
			//현재 술래 위치
			int tx = tagger.get(tIdx).x;
			int ty = tagger.get(tIdx).y;
			
			//새로운 맵
			ArrayList<Integer>[][] map2 = new ArrayList[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map2[i][j] = new ArrayList<>();
				}
			}
			
			//1. 도망자 이동
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					int dist = Math.abs(tx-i)+Math.abs(ty-j);
					if(dist>3) {
						for(int s=0;s<map[i][j].size();s++) {
							map2[i][j].add(map[i][j].get(s));
						}
					}else {
						for(int s=0;s<map[i][j].size();s++){
							int dir = map[i][j].get(s);
							
							int nr = i+dr[dir];
							int nc = j+dc[dir];
							
							//벽에 도달한 도망자
							if(nr<0 || nr>=N || nc<0 || nc>=N) {
								dir=(dir+2)%4;
								nr = i+dr[dir];
								nc = j+dc[dir];
							}
							//술래 자리일 경우 현위치 그대로
							if(nr==tx && nc==ty) {
								map2[i][j].add(dir);
							} 
							//술래 없을 경우 새로운 위치로 이동
							else {
								map2[nr][nc].add(dir);
							}
						}
					}
				}
			}
			map = map2;
			
			
			//2. 술래 이동
			int tsize = tagger.size();
			tIdx = (tIdx+1)%tsize;
			
			tx = tagger.get(tIdx).x;
			ty = tagger.get(tIdx).y;
			int tdir = tagger.get(tIdx).dir;
			
			for(int i=0;i<=2;i++) {
				int nx = tx+dr[tdir]*i;
				int ny = ty+dc[tdir]*i;
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || treemap[nx][ny]) {
					continue;
				}
				
				score+=map[nx][ny].size()*(k+1);
				map[nx][ny].clear();
			}
			
		}
		
		System.out.println(score);
		
	}

}
