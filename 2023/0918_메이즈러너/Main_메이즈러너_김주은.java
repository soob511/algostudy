import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2023_1_2_메이즈러너_김주은 {

	static int N,M,K,ex,ey;
	static int[][] map;
	static int[][] p;
	static boolean[] exit;
	static int exit_cnt=0;
	static int move=0;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		p = new int[M][2];
		exit = new boolean[M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0]=Integer.parseInt(st.nextToken())-1;
			p[i][1]=Integer.parseInt(st.nextToken())-1;
		}
		
		st = new StringTokenizer(br.readLine());
		ex=Integer.parseInt(st.nextToken())-1;
		ey=Integer.parseInt(st.nextToken())-1;
		
		X : for(int k=0;k<K;k++) {
			if(exit_cnt==M) {
				break;
			}
			
			//1. 출구쪽으로 이동
			for(int m=0;m<M;m++) {
				if(exit[m]) {
					continue;
				}
				
				int px = p[m][0];
				int py = p[m][1];
				
				int npx;
				int npy;
				
				int dx = ex-px==0?0:(ex-px)/Math.abs(ex-px);
				int dy = ey-py==0?0:(ey-py)/Math.abs(ey-py);

				for(int d=0;d<2;d++) {
					npx=px;
					npy=py;
					if(d==0) {//상하 이동
						npx += dx;
					} else {//수평 이동						
						npy += dy;
					}
					//이동X
					if(npx==px && npy==py) {
						continue;
					}
					//벽 없는 경우
					if(map[npx][npy]==0) {
						p[m][0]=npx;
						p[m][1]=npy;
						move+=1;
						if(npx==ex && npy==ey) {
							exit[m]=true;
							exit_cnt+=1;
							if(exit_cnt==M) {
								break X;
							}
						}
						break;
					}
				}
			}
			
			//2. 출구와 참가자 포함한 최소 정사각형 찾기
			int mx=-1,my=-1,len=-1;
			A : for(int l=2;l<=N;l++) {
				for(int x=0;x<=N-l;x++) {
					for(int y=0;y<=N-l;y++) {
						if(ex>=x && ex<x+l && ey>=y && ey<y+l) {
							for(int m=0;m<M;m++) {
								if(exit[m]) {
									continue;
								}
								if(p[m][0]>=x && p[m][0]<x+l && p[m][1]>=y && p[m][1]<y+l) {
									mx=x;
									my=y;
									len=l;
									break A;
								}
							}
						}
					}
				}
			}
			
			//3. 90도 회전
			int[][] map2 = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map2[i][j]=map[i][j];
				}
			}
			//사람 회전
			for(int m=0;m<M;m++) {
				if(exit[m]) {
					continue;
				}
				if(p[m][0]>=mx && p[m][0]<mx+len && p[m][1]>=my && p[m][1]<my+len) {
					int x = p[m][0]-mx;
					int y = p[m][1]-my;
					p[m][0]=mx+y;
					p[m][1]=my+len-1-x;
				}
			}
			//출구 회전
			int etx = ex-mx;
			int ety = ey-my;
			ex = mx+ety;
			ey = my+len-1-etx;
			//지도 회전
			for(int x=mx,ay=my;x<mx+len;x++,ay++) {
				for(int y=my,ax=mx+len-1;y<my+len;y++,ax--) {
					map2[x][y]=map[ax][ay]==0?0:map[ax][ay]-1;
				}
			}
			map=map2;
		}
		
		System.out.println(move);
		System.out.println((ex+1)+" "+(ey+1));
	}
}
