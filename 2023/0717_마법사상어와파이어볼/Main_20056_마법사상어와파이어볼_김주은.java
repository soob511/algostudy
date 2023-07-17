import java.io.*;
import java.util.*;

public class Main_BJ_20056_마법사상어와파이어볼_김주은2 {
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	static class FireBall {
		int m;
		int s;
		int d;
		int k;
		public FireBall(int m, int s, int d, int k) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
			this.k = k;
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayDeque<FireBall>[][] map = new ArrayDeque[N][N];
		ArrayDeque<FireBall>[][] map2 = new ArrayDeque[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = new ArrayDeque<FireBall>();
				map2[i][j] = new ArrayDeque<FireBall>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = 0;
			
			map[r][c].add(new FireBall(m,s,d,k));
		}
		
		
		for(int time=0;time<K;time++) {
			
			//1. 파이어볼이 자신의 방향 d로 속력 s칸만큼 이동한다
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					while(!map[i][j].isEmpty() && map[i][j].peekFirst().k==time) {
						FireBall fb = map[i][j].pollFirst();
						int ni = (i+(N+dr[fb.d])*fb.s)%N;
						int nj = (j+(N+dc[fb.d])*fb.s)%N;
						map[ni][nj].add(new FireBall(fb.m,fb.s,fb.d,fb.k+1));
					}
				}
			}
			
			//2. 2개이상 파이어볼이 있는 칸
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j].size()>=2) {
						int cnt = map[i][j].size();
						int mSum = 0;
						int sSum = 0;
						
						boolean odd = false;
						boolean even = false;
						
						while(!map[i][j].isEmpty()) {
							FireBall fb = map[i][j].poll();
							mSum+=fb.m;
							sSum+=fb.s;
							if(fb.d%2==0) {
								even=true;
							} else {
								odd=true;
							}
						}
						
						mSum/=5;
						sSum/=cnt;
						
						if(mSum>0) {
							int nd=odd && even?1:0; //다음 방향
							for(int d=nd;d<8;d+=2) {
								map2[i][j].add(new FireBall(mSum,sSum,d,time+1));
							}
						} 
						
					}
				}
			}
			
			//3. 쪼개진 파이어볼 기존 맵에 합치기
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					while(!map2[i][j].isEmpty()) {
						map[i][j].add(map2[i][j].poll());
					}
				}
			}
		}
		
		//4. K번 명령 후 남아있는 파이어볼 질량의 합
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				while(!map[i][j].isEmpty()) {
					FireBall fb = map[i][j].poll();
					answer+=fb.m;
				}
			}
		}
		
		System.out.println(answer);
	}

}
