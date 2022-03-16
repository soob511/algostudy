package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_7569_토마토3차원  {
	static int m,n,H;
	static int[][][] map;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());//가로칸수
		n = Integer.parseInt(st.nextToken());//세로칸수
		H = Integer.parseInt(st.nextToken());//높이
		map = new int[H][n][m];
		//입력
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}


		//토마토 익히기
		bfs();
		
		int count=0;//안익은게 있는지 체크
		int max=0;
		for(int h=0;h<H;h++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[h][i][j]==0) {//0(안익은거)있으면 카운트
						count++;
					}
					max=Math.max(max, map[h][i][j]);//제일큰값
				}
			}
		}
		if(count!=0) {//0이 있어서 익지못하는 상황
			System.out.println(-1);
		}
		else if(max==1) {// 원래 다 익어있는 상태
			System.out.println(0);
		}
		else {//최소 일수
 			System.out.println(max-1);
		}
		
	}

	private static void bfs() {
		
		Queue<int []> q = new LinkedList<int []>();
		
		for(int h=0;h<H;h++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[h][i][j]==1) {
						q.add(new int[] {h,i,j});
						
					}
				}
			}
		}
		while(!q.isEmpty()) {
			int[] a = q.poll();
			for(int i=0;i<6;i++) {
				int nz = a[0]+dz[i];
				int nx = a[1]+dx[i];
				int ny = a[2]+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m&&nz>=0&&nz<H) {
					if(map[nz][nx][ny]==0) {
						q.add(new int[] {nz,nx,ny});
						map[nz][nx][ny]=map[a[0]][a[1]][a[2]]+1;
					}
				}
			}
		}
	}

}

