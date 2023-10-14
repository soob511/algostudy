import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Rabbit {
		int id;
		int dist;
		int jump;
		long score;
		int x;
		int y;
		
		public Rabbit(int id, int dist, int jump, long score, int x, int y) {
			super();
			this.id = id;
			this.dist = dist;
			this.jump = jump;
			this.score = score;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Pos{
		int x;
		int y;
		public Pos(int x,int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static HashMap<Integer, Rabbit> hmap = new HashMap<>();
	
	static PriorityQueue<Rabbit> sending = new PriorityQueue<>((o1,o2)->{
		if(o1.jump==o2.jump) {
			if(o1.x+o1.y==o2.x+o2.y) {
				if(o1.x==o2.x) {
					if(o1.y==o2.y) {
						return o1.id-o2.id;
					}return o1.y-o2.y;
				}return o1.x-o2.x;
			}return (o1.x+o1.y)-(o2.x+o2.y);
		}return o1.jump-o2.jump;
	});
	
	static PriorityQueue<Pos> pos = new PriorityQueue<>((o1,o2)->{
		if(o1.x+o1.y==o2.x+o2.y) {
			if(o1.x==o2.x) {
				return o2.y-o1.y;
			}return o2.x-o1.x;
		}return (o2.x+o2.y)-(o1.x+o1.y);
	});
	
	static HashMap<Integer, Rabbit> moved = new HashMap<>();
	
	static PriorityQueue<Rabbit> afterK = new PriorityQueue<>((o1,o2)->{
		if(o1.x+o1.y==o2.x+o2.y) {
			if(o1.x==o2.x) {
				if(o1.y==o2.y) {
					return o2.id-o1.id;
				}return o2.y-o1.y;
			}return o2.x-o1.x;
		}return (o2.x+o2.y)-(o1.x+o1.y);
	});
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int N,M,NN,MM;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int q=0;q<Q;q++) {
			
			st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			
			if(cmd==100) {
				//init
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				NN=2*N-2;
				MM=2*M-2;
				
				int P = Integer.parseInt(st.nextToken());
				for(int p=0;p<P;p++) {
					int pid = Integer.parseInt(st.nextToken());
					int L = Integer.parseInt(st.nextToken());
					Rabbit rb = new Rabbit(pid, L, 0, 0, 0, 0);
					hmap.put(pid, rb);
					sending.add(rb);
				}
				
			} else if(cmd==200) {
				int K = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());
				race(K,S);
			} else if(cmd==300) {
				int pid_t = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				change_dist(pid_t, L);
			} else if(cmd==400) {
				System.out.println(best());
			}
			
		}
	}

	private static void race(int K, int S) {
		
		moved.clear();
		
		for(int k=0;k<K;k++) {
			
			//우선순위 높은 토끼 찾기
			Rabbit rb = sending.poll();
			if(!moved.containsKey(rb.id)) {
				moved.put(rb.id, rb);
			}
			
			//우선순위 높은 칸 찾기
			pos.clear();
			for(int d=0;d<4;d++) {
				int nx = rb.x + dr[d]*rb.dist;
				int ny = rb.y + dc[d]*rb.dist;

				//격자를 벗어나는 경우
				if(nx<0) {
					nx-=rb.x;
					nx=-nx;
					nx%=NN;
					nx=nx>=N?NN-nx:nx;
					nx+=rb.x;
				}else if(ny<0) {
					ny-=rb.y;
					ny=-ny;
					ny%=MM;
					ny=ny>=M?MM-ny:ny;
					ny+=rb.y;
				}
				
				nx%=NN;
				nx=nx>=N?NN-nx:nx;
				ny%=MM;
				ny=ny>=M?MM-ny:ny;
				
				pos.add(new Pos(nx,ny));
			}
			
			Pos p = pos.poll();
			int rc = p.x+p.y+2;
			
			//우선순위 높은 칸으로 토끼 이동 & 나머지 토끼 r+c만큼 점수 증가
			for(Rabbit rbb : hmap.values()) {
				if(rbb.id==rb.id) {
					rbb.x=p.x;
					rbb.y=p.y;
					rbb.jump+=1;
					sending.add(rb);
				} else {
					rbb.score+=rc;
				}
			}
			
		}
		
		//K번 턴 이후 한번이라도 뽑혔던 토끼 중 우선순위 높은 토끼 선택
		afterK.clear();
		for(Rabbit rb: moved.values()) {
			afterK.add(rb);
		}
		Rabbit rbbb = afterK.poll();
		rbbb.score+=S;
	}

	private static void change_dist(int pid_t, int l) {
		Rabbit rb = hmap.get(pid_t);
		rb.dist*=l;
	}
	
	private static long best() {
		long max = 0;
		for(Rabbit rb : hmap.values()) {
			if(max<rb.score) {
				max = rb.score;
			}
		}
		return max;
	}

}
