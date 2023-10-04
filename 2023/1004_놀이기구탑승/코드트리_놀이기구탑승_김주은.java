import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pos{
		int like;
		int empty;
		int x;
		int y;
		
		public Pos(int like, int empty, int x, int y) {
			super();
			this.like = like;
			this.empty = empty;
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int[] seq = new int[N*N];
		int[][] likes = new int[N*N+1][4];
		
		for(int i=0;i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			seq[i]=n;
			for(int j=0;j<4;j++) {
				likes[n][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>((o1,o2)->{
			if(o1.like==o2.like) {
				if(o1.empty==o2.empty) {
					if(o1.x==o2.x) {
						return o1.y-o2.y;
					}
					return o1.x-o2.x;
				}
				return o2.empty-o1.empty;
			}
			return o2.like-o1.like;
		});
		
		for(int i=0;i<N*N;i++) {
			
			pq.clear();
			int n = seq[i];
			
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					
					if(map[a][b]!=0) {
						continue;
					}
					
					int l=0,e=0;
					for(int d=0;d<4;d++) {
						
						int na = a+dr[d];
						int nb = b+dc[d];
						
						if(na<0 || na>=N || nb<0 || nb>=N) {
							continue;
						}
						
						if(map[na][nb]==0) {
							e+=1;
						} else {
							for(int k=0;k<4;k++) {
								if(map[na][nb]==likes[n][k]) {
									l+=1;
									break;
								}
							}
						}
					}
					
					pq.add(new Pos(l,e,a,b));
					
				}
			}
			
			Pos p = pq.poll();
			
			map[p.x][p.y]=n;
			
		}
		
		int score = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				int cnt=0;
				for(int d=0;d<4;d++) {
					int na = i+dr[d];
					int nb = j+dc[d];
					
					if(na<0 || na>=N || nb<0 || nb>=N) {
						continue;
					}
					
					for(int k=0;k<4;k++) {
						if(map[na][nb]==likes[map[i][j]][k]) {
							cnt+=1;
							break;
						}
					}
				}
				
				if(cnt>0) {
					score += Math.pow(10, cnt-1);
				}
				
			}
			
		}
		
		System.out.println(score);
		
	}

}
