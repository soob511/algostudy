import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1906_지뢰찾기_김주은 {
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j)=='.'?0:s.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(map[i][j]>0) {
					sb.append('*');
					continue;
				}
				
				int val = 0;
				for(int d=0;d<8;d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]>0) {
						val+=map[nr][nc];
					}
				}
				sb.append(val>=10?"M":val);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
