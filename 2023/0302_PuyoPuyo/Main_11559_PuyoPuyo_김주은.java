import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main_BJ_11559_PuyoPuyo_김주은 {
	
	static char[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static Queue<int[]> queue = new ArrayDeque<>();
	static ArrayList<int[]> field = new ArrayList<>();
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		for(int i=0;i<12;i++) {
			String s = br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int time=0;
		while(true) {
			
			//터질 수 있는 버블 터트리기
			if(!canPop()) {
				break;
			}
			
			++time;
			
			//아래로 끌어당기기
			pullDown();
						
		}
		
		System.out.println(time);
	}

	private static void pullDown() {
		for(int j=0;j<6;j++) {
			int floor=0;
			for(int i=11;i>=0;i--) {
				if(map[i][j]=='.') {
					floor=i;
					break;
				}
			}
			for(int i=floor-1;i>=0;i--) {
				if(map[i][j]!='.') {
					char temp = map[i][j];
					map[i][j] = map[floor][j];
					map[floor][j]=temp;
					floor--;
				}
			}
		}
	}

	private static boolean canPop() {

		visited = new boolean[12][6];
		boolean canPop = false;
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(map[i][j]!='.' && !visited[i][j]) {
					queue.clear();
					field.clear();
					queue.add(new int[] {i,j});
					visited[i][j]=true;
					
					while(!queue.isEmpty()) {
						int[] v = queue.poll();
						field.add(new int[] {v[0],v[1]});
						
						for(int d=0;d<4;d++) {
							int nr = v[0]+dr[d];
							int nc = v[1]+dc[d];
							
							if(nr<0 || nr>=12 || nc<0 || nc>=6 || visited[nr][nc] || map[nr][nc]!=map[i][j]) {
								continue;
							}
							
							visited[nr][nc]=true;
							queue.add(new int[] {nr,nc});
						}
					}
					
					if(field.size()>=4) {
						canPop=true;
						for(int x=0;x<field.size();x++) {
							int a = field.get(x)[0];
							int b = field.get(x)[1];
							map[a][b]='.';
						}
					}
				}
			}
		}
		
		return canPop;
	}

}
