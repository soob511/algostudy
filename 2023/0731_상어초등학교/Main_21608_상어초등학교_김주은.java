import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_21608_상어초등학교_김주은2 {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap[] likes = new HashMap[N*N+1];
		for(int i=1;i<=N*N;i++) {
			likes[i]=new HashMap<>();	
		}
		int[] seq = new int[N*N];
		
		for(int i=0;i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			seq[i]=Integer.parseInt(st.nextToken());
			for(int j=0;j<4;j++) {
				likes[seq[i]].put(Integer.parseInt(st.nextToken()), true);
			}
		}
		
		int[][] map = new int[N][N];
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) { //좋아하는 학생 수
					if(o1[1]==o2[1]) { //비어있는 칸
						if(o1[2]==o2[2]) { //행 번호 오름차순
							return o1[3]-o2[3]; //열 번호 오름차순
						}
						return o1[2]-o2[2];
					}
					return o2[1]-o1[1];
				}
				return o2[0]-o1[0];
			}
		});
		
		for(int i=0;i<N*N;i++) {
			
			int student = seq[i];
			
			//좋아하는 학생이 가장 많이 인접한 칸 찾기
			q.clear();
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					if(map[x][y]>0) {
						continue;
					}
					int empty = 0;
					int like = 0;
					for(int d=0;d<4;d++) {
						int nx = x+dr[d];
						int ny = y+dc[d];
						if(nx<0 || nx>=N || ny<0 || ny>=N) {
							continue;
						}
						if(map[nx][ny]==0) {
							empty+=1;
						}
						if(likes[student].containsKey(map[nx][ny])) {
							like+=1;
						}
					}
					q.add(new int[] {like,empty,x,y});//좋아하는 학생 수, 빈칸, 행, 열
				}
			}
			
			int[] v = q.poll();
			
			map[v[2]][v[3]]=student;
			
		}
		
		
		//만족도 구하기
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt=0;
				for(int d=0;d<4;d++) {
					int ni = i+dr[d];
					int nj = j+dc[d];
					if(ni<0 || ni>=N || nj<0 || nj>=N) {
						continue;
					}
					if(likes[map[i][j]].containsKey(map[ni][nj])) {
						cnt+=1;
					}
				}
				if(cnt>0) {
					answer+=Math.pow(10,cnt-1);
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
