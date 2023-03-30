import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,F;
	static int[][] map;
	static int[][] list;

	static int tx,ty;

	static Queue<int[]> q = new ArrayDeque<>();
	static boolean[][] visited;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		tx = Integer.parseInt(st.nextToken())-1;
		ty = Integer.parseInt(st.nextToken())-1;
		
		list = new int[M][4];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			list[i][0]= Integer.parseInt(st.nextToken())-1;
			list[i][1]= Integer.parseInt(st.nextToken())-1;
			list[i][2]= Integer.parseInt(st.nextToken())-1;
			list[i][3]= Integer.parseInt(st.nextToken())-1;
		}
		Arrays.sort(list, (o1,o2)->{
			if(o1[0]==o2[0]) {
				return o1[1]-o2[1];
			}else {
				return o1[0]-o2[0];
			}
		});
		
		boolean[] visitedList = new boolean[M];
		boolean success=true;
		
		int m = M;
		while(m-->0) {
			
			//다음 태울 승객 선택하기
			int minDist=Integer.MAX_VALUE;
			int idx=-1;
			for(int i=0;i<M;i++) {
				if(!visitedList[i]) {
					int dist = calcDist(tx,ty,list[i][0],list[i][1]);
					if(dist>=0 && dist<=F && dist<minDist) {
						minDist = dist;
						idx = i;
					}
				}
			}
			//태울 수 있는 승객 없다면 종료
			if(idx==-1) {
				success=false;
				break;
			}
			//승객위치로 이동, 연료 소모
			tx = list[idx][0];
			ty = list[idx][1];
			F-=minDist;
			if(F==0) {
				success=false;
				break;
			}
			//승객 이동하기
			int dist = calcDist(tx,ty,list[idx][2],list[idx][3]);
			if(dist>=0 && dist<=F) {
				F-=dist;
				if(F<0) {
					success=false;
					break;
				}
				//승객 이동을 성공하면 연료 채우기
				visitedList[idx]=true;
				F+=dist*2;
				tx=list[idx][2];
				ty=list[idx][3];
			}else {
				success=false;
				break;
			}
			
		}
		
		if(success) {
			System.out.println(F);
		}else {
			System.out.println(-1);
		}
		
	}

	private static int calcDist(int sx, int sy, int ex, int ey) {
		
		q.clear();
		q.add(new int[] {sx,sy,0});
		visited = new boolean[N][N];
		visited[sx][sy]=true;
		
		int time = -1;
		while(!q.isEmpty()) {
			
			int[] v = q.poll();
			
			if(v[0]==ex && v[1]==ey) {
				time = v[2];
				break;
			}
			
			for(int d=0;d<4;d++) {
				int nr = v[0]+dr[d];
				int nc = v[1]+dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]==1) {
					continue;
				}
				
				visited[nr][nc]=true;
				q.add(new int[] {nr,nc,v[2]+1});
			}
			
		}
		
		return time;
		
	}

}
