import java.io.*;
import java.util.*;

public class Main_BJ_19236_청소년상어_김주은 {
	
	static class Fish {
		int x;
		int y;
		int dir;
		
		public Fish(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int max_eat = 0;
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Fish[] fishes = new Fish[17];
		
		int sx=0,sy=0,sdir=-1;
		int[][] map = new int[4][4];
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int n = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				map[i][j] = n;
				fishes[n] = new Fish(i,j,dir);
			}
		}
		sdir=fishes[map[0][0]].dir;
		fishes[map[0][0]]=null;
		int eat = map[0][0];
		map[0][0]=-1;
		
		dfs(sx,sy,sdir,eat,map, fishes);
		
		System.out.println(max_eat);
	}

	private static void dfs(int sx, int sy, int sdir, int eaten, int[][] map, Fish[] fishes) {
		
		Fish[] newfishes = new Fish[17];
		for(int i=1;i<=16;i++) {
			if(fishes[i]!=null) {
				newfishes[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].dir);
			}
		}
		
		if(max_eat<eaten) {
			max_eat = eaten;
		}
		
		// 1. 물고기가 이동한다
		for(int i=1;i<=16;i++) {
			if(newfishes[i] != null) {
				int d = newfishes[i].dir;
				int cnt = 0;
				int nx = newfishes[i].x+dr[d+cnt];
				int ny = newfishes[i].y+dc[d+cnt];
				int ndir = d+cnt;
				
				boolean move=true;
				//벽 또는 상어를 만날 때 방향 전환
				while(nx<0 || nx>=4 || ny<0 || ny>=4 || map[nx][ny]==-1) {
					++cnt;
					if(cnt==8) {
						move=false;
						break;
					}
					nx = newfishes[i].x+dr[(d+cnt)%8];
					ny = newfishes[i].y+dc[(d+cnt)%8];
					ndir = (d+cnt)%8;
				}
				
				//방향 전환하여 이동할 수 있을 때
				if(move) {
					//방향에 있는 물고기와 교환
					//1. 지도 위치 교환
					int temp = map[nx][ny];
					map[nx][ny] = map[newfishes[i].x][newfishes[i].y];
					map[newfishes[i].x][newfishes[i].y] = temp;
					
					//2. fishes 정보 교환
					if(temp>0) {
						newfishes[temp] = new Fish(newfishes[i].x, newfishes[i].y,newfishes[temp].dir);
					}
					newfishes[i] = new Fish(nx,ny,ndir);
				}

			}
			
		}
		

		//2. 상어의 이동
		int[][] newmap;
		int nx = sx+dr[sdir];
		int ny = sy+dc[sdir];
		while(nx>=0 && nx<4 && ny>=0 && ny<4) {
			//물고기가 있을 때만 이동
			if(map[nx][ny]>0) {
				
				newmap = new int[4][4];
				for(int i=0;i<4;i++) {
					for(int j=0;j<4;j++) {
						newmap[i][j]=map[i][j];
					}
				}
				newmap[sx][sy]=0;
				
				int tempNum = map[nx][ny];
				Fish temp = newfishes[tempNum];
				
				newfishes[tempNum] = null;
				newmap[nx][ny]=-1;
				dfs(nx, ny, temp.dir, eaten+tempNum, newmap, newfishes);
				newfishes[tempNum] = temp;
			}
			nx+=dr[sdir];
			ny+=dc[sdir];
		}
	}

}
