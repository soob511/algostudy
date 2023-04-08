import java.io.*;
import java.util.*;

public class Main {
	
	static class Player{
		int x;
		int y;
		int dir;
		int s;//능력치
		int w;//총기능력치
		int score;
		
		public Player(int x, int y, int dir, int s, int w, int score) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.s = s;
			this.w = w;
			this.score = score;
		}
	}
	
	static int M;
	
	static Player[] plist;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer>[][] map = new PriorityQueue[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = new PriorityQueue<>(Collections.reverseOrder());
				int w = Integer.parseInt(st.nextToken());
				if(w>0) {
					map[i][j].add(w);
				}
			}
		}
		
		plist = new Player[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			plist[i] = new Player(x,y,dir,s,0,0);
		}
		
		while(K-->0) {
			
			for(int i=0;i<M;i++) {
				
				Player me = plist[i];
				
				//1. 플레이어 한칸 이동 필요시 방향 전환
				int ndir = me.dir;
				int nx = me.x+dr[ndir];
				int ny = me.y+dc[ndir];
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					ndir = (ndir+2)%4;
					nx = me.x+dr[ndir];
					ny = me.y+dc[ndir];
				}
				
				//이동할 칸에 플레이어가 있는지 확인
				Player op = checkPlayer(nx,ny);
				
				//플레이어 한칸 이동
				me.x = nx;
				me.y = ny;
				me.dir = ndir;
				
				
				//만약 이동한 칸에 플레이어가 없다면
				if(op==null) {
					//내가 가진 총이 없다면
					if(me.w==0){
						if(!map[nx][ny].isEmpty()) {
							me.w = map[nx][ny].poll();
						}
					}
					//내가 가진 총이 있다면
					else {
						//내 총을 넣고, 가장 좋은 총 가진다
						map[nx][ny].add(me.w);
						me.w = map[nx][ny].poll();
					}
				} 
				//만약 이동한 칸에 플레이어가 있다면
				else {
					
					Player winner;
					Player loser;
					
					//점수를 비교 하여 승자 패자 정하기
					int meScore = me.s + me.w;
					int opScore = op.s + op.w;
					int diff = Math.abs(opScore-meScore);
					
					if(meScore<opScore) {
						winner = op;
						loser = me;
					} else if(meScore>opScore) {
						winner = me;
						loser = op;
					} else { //동점
						if(me.s>op.s) {
							winner = me;
							loser = op;
						}else {
							winner = op;
							loser = me;
						}
					}
					
					//승자는 점수 가져감
					winner.score+=diff;
					
					//패자는 가진 총 내려놓기
					if(loser.w>0) {
						map[nx][ny].add(loser.w);
						loser.w = 0;
					}
					
					//원래 가던 방향으로 한칸 이동
					for(int d=loser.dir;d<d+4;d++) {
						int lx = nx+dr[d%4];
						int ly = ny+dc[d%4];
						
						if(lx>=0 && lx<N && ly>=0 && ly<N && checkPlayer(lx,ly)==null) {
							loser.x = lx;
							loser.y = ly;
							loser.dir = d%4;
							
							//패자가 이동한 칸에 총기 있으면 좋은 것 장착
							if(!map[lx][ly].isEmpty()) {
								loser.w = map[lx][ly].poll();
							}
							break;
						}
					}
					
					//승자는 가장 높은 총 선택
					map[nx][ny].add(winner.w);
					winner.w = map[nx][ny].poll();
					
				}
				
			}
			
		}

		for(int i=0;i<M;i++) {
			sb.append(plist[i].score).append(" ");
		}
		System.out.println(sb);
		
	}

	private static Player checkPlayer(int nx, int ny) {
		for(int j=0;j<M;j++) {
			if(nx == plist[j].x && ny == plist[j].y) {
				return plist[j];
			}
		}
		return null;
	}

}
