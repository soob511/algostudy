import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1652_누울자리를찾아라_김주은 {
	
	static int[][] room;
	static int N;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		room = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				room[i][j] = s.charAt(j)=='.'?0:1;
			}
		}
		
		int rowCnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && room[i][j]==0) {
					rowCnt+=checkRow(i,j);
				}
			}
		}
		
		visited = new boolean[N][N];
		int colCnt=0;
		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++) {
				if(!visited[i][j] && room[i][j]==0) {
					colCnt+=checkCol(i,j);
				}
			}
		}
		
		System.out.println(rowCnt + " "+colCnt);
	}

	private static int checkRow(int i, int j) {
		int cnt=0;
		for(int d=j;d<N;d++) {
			if(room[i][d]==0) {
				++cnt;
				visited[i][d]=true;
			} else {
				visited[i][d]=true;
				break;
			}
		}
		if(cnt>=2) {
			return 1;
		}else {
			return 0;
		}
	}
	
	private static int checkCol(int i, int j) {
		int cnt=0;
		for(int d=i;d<N;d++) {
			if(room[d][j]==0) {
				++cnt;
				visited[d][j]=true;
			} else {
				visited[d][j]=true;
				break;
			}
		}
		if(cnt>=2) {
			return 1;
		}else {
			return 0;
		}
	}

}
