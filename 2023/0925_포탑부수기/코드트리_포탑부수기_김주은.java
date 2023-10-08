import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K;
	static int[][] map, attack;
	
	static class Tower{
		
		int pow;
		int att;
		int x;
		int y;
		
		public Tower(int pow, int att, int x, int y) {
			super();
			this.pow = pow;
			this.att = att;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Attack{
		int x;
		int y;
		ArrayList<Integer> path;
		public Attack(int x, int y, ArrayList<Integer> path) {
			super();
			this.x = x;
			this.y = y;
			this.path = path;
		}
	}
	
	static Tower w,s;
	static ArrayList<Integer> attack_path;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static int[] ddr = {0,1,1,1,0,-1,-1,-1};
	static int[] ddc = {1,1,0,-1,-1,-1,0,1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		attack = new int[N][M];
		
		for(int k=1;k<=K;k++) {
			
			//포탑이 1개일 경우 종료
			int tower = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]>0) {					
						tower+=1;
					}
				}
			}
			if(tower==1) {
				break;
			}

			//1.공격자 선정
			//약한 포탑 선정
			PriorityQueue<Tower> weakest = new PriorityQueue<>((o1,o2)->{
				if(o1.pow==o2.pow) {
					if(o1.att==o2.att) {
						if(o1.x+o1.y==o2.x+o2.y) {
							return o2.y-o1.y;
						}return (o2.x+o2.y)-(o1.x+o1.y);
					}return o2.att-o1.att;
				}return o1.pow-o2.pow;
			});
			
			//강한 포탑 선정
			PriorityQueue<Tower> strongest = new PriorityQueue<>((o1,o2)->{
				if(o1.pow==o2.pow) {
					if(o1.att==o2.att) {
						if(o1.x+o1.y==o2.x+o2.y) {
							return o1.y-o2.y;
						}return (o1.x+o1.y)-(o2.x+o2.y);
					}return o1.att-o2.att;
				}return o2.pow-o1.pow;
			});
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]>0) {					
						weakest.add(new Tower(map[i][j],attack[i][j],i,j));
						strongest.add(new Tower(map[i][j],attack[i][j],i,j));
					}
				}
			}
			
			w = weakest.poll();
			map[w.x][w.y]+=(N+M);
			s = strongest.poll();
			
			//2. 공격
			
			boolean[][] attacked = new boolean[N][M];
			attacked[w.x][w.y]=true;
			int damage = map[w.x][w.y];
			
			if(lazerAttack()) {
				
				int l = attack_path.size();
				for(int i=1;i<l;i++) {
					int x = attack_path.get(i)/M;
					int y = attack_path.get(i)%M;
					attacked[x][y]=true;
					
					if(i<l-1) {
						map[x][y]-=(damage/2);
					}else {
						map[x][y]-=damage;
					}
					
					if(map[x][y]<0) {
						map[x][y]=0;
					}
				}
			} 
			else {
				
				map[s.x][s.y]-=damage;
				attacked[s.x][s.y]=true;
				
				for(int d=0;d<8;d++) {
					int nx = (s.x+ddr[d]+N)%N;
					int ny = (s.y+ddc[d]+M)%M;
					
					if(map[nx][ny]==0 || (w.x==nx && w.y==ny)){
						continue;
					}
					
					attacked[nx][ny]=true;
					map[nx][ny]-=(damage/2);
					
					if(map[nx][ny]<0) {
						map[nx][ny]=0;
					}
				}
				
			}
			
			attack[w.x][w.y]=k;
			
			//3. 포탑 정비
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(attacked[i][j] || map[i][j]==0) {
						continue;
					}
					map[i][j]+=1;
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>max) {
					max = map[i][j];
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static boolean lazerAttack() {
		
		boolean[][] visited = new boolean[N][M];
		ArrayDeque<Attack> q = new ArrayDeque<>();
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(w.x*M+w.y);
		q.add(new Attack(w.x,w.y,path));
		visited[w.x][w.y]=true;
		
		boolean move = false;
		while(!q.isEmpty()) {
			
			Attack a = q.poll();
			
			if(a.x==s.x && a.y==s.y) {
				move=true;
				attack_path = a.path;
				break;
			}

			for(int d=0;d<4;d++) {
				
				int nx = (a.x+dr[d]+N)%N;
				int ny = (a.y+dc[d]+M)%M;
				
				if(visited[nx][ny] || map[nx][ny]==0) {
					continue;
				}
				
				visited[nx][ny]=true;
				ArrayList<Integer> npath = new ArrayList<>();
				for(int p : a.path) {
					npath.add(p);
				}
				npath.add(nx*M+ny);
				
				q.add(new Attack(nx,ny,npath));
			}
		
		}
		
		return move;
		
	}

}
