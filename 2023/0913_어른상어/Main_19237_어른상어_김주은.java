import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_19237_어른상어_김주은 {
	
	static class Smell{
		int num;
		int time;
		public Smell(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
	}
	
	static class Shark{
		int x;
		int y;
		int dir;
		public Shark(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static Smell[][] smell;
	static int[][] map;
	static Shark[] shark;
	static int[][][] dirs;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int N,M,k;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		smell = new Smell[N][N];
		map = new int[N][N];
		shark = new Shark[M];
		dirs = new int[M][4][4];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken())-1;
				if(map[i][j]>=0) {
					shark[map[i][j]]=new Shark(i,j,-1);
					smell[i][j] = new Smell(map[i][j], k);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			shark[i].dir=Integer.parseInt(st.nextToken())-1;
		}
		
		for(int t=0;t<M;t++) {
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) {
					dirs[t][i][j]=Integer.parseInt(st.nextToken())-1;
				}
			}
		}
		
		int time = 0;
		while(true) {
			
			if(oneLeft()) {
				System.out.println(time);
				return;
			}
			
			time+=1;
			if(time>1000) {
				System.out.println(-1);
				return;
			}
			
			
			//1. 상어 이동
			int[][] map2 = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map2[i][j]=-1;
				}
			}
			Smell[][] smell2 = new Smell[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(smell[i][j]!=null) {
						smell2[i][j]=new Smell(smell[i][j].num,smell[i][j].time);
					}
				}
			}
			A : for(int i=0;i<M;i++) {
				if(shark[i]!=null) {
					
					int sx = shark[i].x;
					int sy = shark[i].y;
					int sdir = shark[i].dir;
					
					//자신이 지나온길
					int px=-1,py=-1,pdir=-1;
					
					//다음 길
					int nextx=-1,nexty=-1,nextdir=-1;
					
					boolean move = false;
					for(int d=0;d<4;d++) {
						int nsx = sx + dr[dirs[i][sdir][d]];
						int nsy = sy + dc[dirs[i][sdir][d]];
						
						if(nsx<0 || nsx>=N || nsy<0 || nsy>=N) {
							continue;
						}
						
						if(smell2[nsx][nsy]!=null) {
							//내가 지나온 길
							if(smell2[nsx][nsy].num==i) {
								if(px==-1 && py==-1 && pdir==-1) {
									px = nsx;
									py = nsy;
									pdir = dirs[i][sdir][d];
								}
								continue;
							} 
							//다른 상어 냄새 길
							else {
								//이전에는 상어가 없었으나 앞번호 상어가 이동하여 자리 잡은 경우
								if(smell[nsx][nsy]==null) {
									shark[i]=null;
									continue A;
								} 
								//이전에도 상어가 있었다
								else {
									continue;
								}
							}
						}
						
						move=true;
						nextx = nsx;
						nexty = nsy;
						nextdir = dirs[i][sdir][d];
						break;
					}
					
					if(!move) {
						nextx = px;
						nexty = py;
						nextdir = pdir;
					}
					
					//새로운 상어 이동 적용
					map2[nextx][nexty]=i;
					smell2[nextx][nexty]=new Smell(i,k+1);
					shark[i].x = nextx;
					shark[i].y = nexty;
					shark[i].dir = nextdir;
					
				}
			}
			
			map=map2;
			smell=smell2;
			
			//2. 상어 냄새 -1
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(smell[i][j] != null) {
						smell[i][j].time-=1;
						if(smell[i][j].time==0) {
							smell[i][j]=null;
						}
					}
				}
			}
			
//			System.out.println("=========="+time+"==========");
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					if(smell[i][j]==null) {
//						System.out.print("[0,0]");
//					}else {
//						System.out.print("["+smell[i][j].num+","+smell[i][j].time+"]");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println("------");
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.printf("[%2d]",map[i][j]);
//				}
//				System.out.println();
//			}
		
			
		}
		
	}

	private static boolean oneLeft() {
		boolean shark=false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<=0) {
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
	}

}
