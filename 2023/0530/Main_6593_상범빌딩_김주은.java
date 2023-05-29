import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_BJ_6593_상범빌딩_김주은 {
	
	//동,서,남,북,상,하
	static int[] dl= {0,0,0,0,-1,1};
	static int[] dr= {0,0,1,-1,0,0};
	static int[] dc= {1,-1,0,0,0,0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
		
			if(L==0 && R==0 && C==0) {
				break;
			}
			
			int[][][] building = new int[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];
			
			int sl=-1,sr=-1,sc=-1;
			int el=-1,er=-1,ec=-1;
			
			for(int l=0;l<L;l++) {
				for(int r=0;r<R;r++) {
					String s = br.readLine();
					for(int c=0;c<C;c++) {
						
						char ch = s.charAt(c);
						if(ch=='S') {
							sl=l;
							sr=r;
							sc=c;
						} else if(ch=='E') {
							el=l;
							er=r;
							ec=c;
						}else if(ch=='#') {
							building[l][r][c]=-1;
						}
					}
				}
				br.readLine();
			}
			
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.add(new int[] {sl,sr,sc,0});
			visited[sl][sr][sc]=true;
			
			boolean escape=false;
			int time=-1;
			
			while(!q.isEmpty()) {
				
				int[] v = q.poll();
				
				if(v[0]==el && v[1]==er && v[2]==ec) {
					escape=true;
					time=v[3];
					break;
				}
				
				for(int d=0;d<6;d++) {
					int nl = v[0]+dl[d];
					int nr = v[1]+dr[d];
					int nc = v[2]+dc[d];
					
					if(nl<0 || nl>=L || nr<0 || nr>=R || nc<0 || nc>=C || visited[nl][nr][nc] || building[nl][nr][nc]<0) {
						continue;
					}
					
					visited[nl][nr][nc]=true;
					q.add(new int[] {nl,nr,nc,v[3]+1});
				}
			
				
			}
			if(escape) {
				sb.append("Escaped in "+time+ " minute(s).\n");
			}else {
				sb.append("Trapped!\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
