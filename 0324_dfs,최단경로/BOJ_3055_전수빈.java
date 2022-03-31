package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_3055_탈출 {
	
	static int r,c;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int wx,wy,x,y;
	static int time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 r = sc.nextInt();
		 c = sc.nextInt();
		
		map = new char[r][c];
		
		for(int i=0;i<r;i++) {
			String s = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') {
					map[i][j]=0;
					x = i;
					y=j;
				}
				else if(map[i][j]=='*') {
					x=i;
					y=j;
				}
			}
		}
		
		for(char[] b:map)System.out.println(Arrays.toString(b));System.out.println();
		water();
		System.out.println(time);

	}
	private static void water() {
		Queue<int[]> wq = new LinkedList<>();//물
		Queue<int[]> q = new LinkedList<>();//고슴도치
		wq.add(new int[] {wx,wy});
		q.add(new int[] {x,y});
		
		while(!wq.isEmpty()) {
			int[] w = wq.poll();
			for(int i=0;i<4;i++) {
				int nx = w[0]+dx[i];
				int ny = w[1]+dy[i];
				
				if(nx>=0&&ny>=0&&nx<r&&ny<c&&map[nx][ny]=='.') {
					wq.add(new int[] {nx,ny});
					map[nx][ny]='.';
				}
				
			}
			int[]  go= wq.poll();
			for(int i=0;i<4;i++) {
				int nx = go[0]+dx[i];
				int ny = go[1]+dy[i];
				
				if(nx>=0&&ny>=0&&nx<r&&ny<c&&map[nx][ny]=='.') {
					if(map[nx][ny]=='D') {
						return;	
					}
					wq.add(new int[] {nx,ny});
					map[nx][ny]='S';
					map[go[0]][go[1]]='.';
					
				}
				
			}
			
			
			time++;
		}
		
		
		
	
	}
	
	
	

}
