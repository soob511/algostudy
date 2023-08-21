import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_19236_청소년상어_김주은 {

	static class Fish{
		int num;
		int dir;

		public Fish(int num, int dir) {
			super();
			this.num = num;
			this.dir = dir;
		}
	}
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	static int max_eaten = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Fish[][] map = new Fish[4][4];
		int[] list = new int[17];
		
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;

				map[i][j] = new Fish(num, dir);
				list[num] = i*4+j;
			}
		}
		
		//상어 배치하기
		Fish f = map[0][0];
		int eaten = f.num;
		list[f.num] = -1; //리스트에서 먹힌 물고기 좌표 삭제
		f.num=0; //상어 배치(상어 : 0)
		
		dfs(map, list, eaten);
		
		System.out.println(max_eaten);
		
	}

	private static void dfs(Fish[][] map2, int[] list2, int eaten) {
		
		max_eaten = Math.max(max_eaten, eaten);
		

		Fish[][] map = new Fish[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(map2[i][j]!=null) {
					map[i][j] = new Fish(map2[i][j].num,map2[i][j].dir);
				}
			}
		}
		int[] list = new int[17];
		list = Arrays.copyOf(list2, 17);
		
		//1. 물고기 움직이기
		for(int idx=1;idx<=16;idx++) {
			
			if(list[idx]<0) {
				continue;
			}
			
			int currx = list[idx]/4;
			int curry = list[idx]%4;
			
			for(int d=0;d<8;d++) {
				
				int nx = currx+dr[(map[currx][curry].dir+d)%8];
				int ny = curry+dc[(map[currx][curry].dir+d)%8];
				
				
				if(nx<0 || nx>=4 || ny<0 || ny>=4) {
					continue;
				}
				
				if(map[nx][ny]==null) {
					
					map[currx][curry].dir=(map[currx][curry].dir+d)%8;
					
					//list 업데이트
					int cnum = map[currx][curry].num;
					list[cnum]=nx*4+ny;
					
					//map 업데이트
					Fish temp = map[currx][curry];
					map[currx][curry]=map[nx][ny];
					map[nx][ny]=temp;
					
					
					
				} else {
					
					if( map[nx][ny].num==0) {
						continue;
					}
					
					map[currx][curry].dir=(map[currx][curry].dir+d)%8;
					
					//list 업데이트
					int cnum = map[currx][curry].num;
					int nnum = map[nx][ny].num;
					int temps = list[nnum];
					list[nnum] = list[cnum];
					list[cnum] = temps;
					
					//map 업데이트
					Fish temp = map[currx][curry];
					map[currx][curry]=map[nx][ny];
					map[nx][ny]=temp;
				}
				
				break;
			}
			
		}
		
		//2. 상어 움직이기
		int sx = list[0]/4;
		int sy = list[0]%4;
		int sdir = map[sx][sy].dir;
		
		for(int d=1;d<4;d++) {
			int nsx = sx+dr[sdir]*d;
			int nsy = sy+dc[sdir]*d;
			
			if(nsx<0 || nsx>=4 || nsy<0 || nsy>=4) {
				break;
			}
			
			if(map[nsx][nsy]==null) {
				continue;
			}
			
			//상어 이동
			int eat = map[nsx][nsy].num;
			
			list[0]=nsx*4+nsy;
			list[map[nsx][nsy].num]=-1;
			
			map[sx][sy]=null;
			map[nsx][nsy].num = 0;
			
			dfs(map, list, eaten+eat);
			
			map[nsx][nsy].num = eat;
			list[map[nsx][nsy].num]=nsx*4+nsy;
			
		}
		
	
	
	
	}

}
