package dfs_bfs;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main_7562_나이트의이동 {

	static int[] dx = {-2,-1,2,1,-2,-1,1,2};
    static int[] dy = {1,2,1,2,-1,-2,-2,-1};
    static int x,y,l;
    static int[][] map;
    static boolean[][] visit;
    static int count;
    static int endx,endy;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine()); //testcase 수
		
		for(int t=1;t<=tc;t++) {
			 l = Integer.parseInt(br.readLine()); //한변의 길이
			map = new int[l][l];
			visit = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			 x = Integer.parseInt(st.nextToken()); //나이트현재칸
			 y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			 endx= Integer.parseInt(st.nextToken()); //도착칸
			 endy = Integer.parseInt(st.nextToken());
			
			bfs();
			System.out.println(map[endx][endy]);
		}
		

	}
	private static void bfs() {
		if(x==endx&&y==endy) {//도착지점이면 
			return;
		}
		
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		
		qx.add(x);//나이트 시작칸 
		qy.add(y);
		visit[x][y]=true;//방문체크
		
		while(!qx.isEmpty()) {
			int a = qx.poll();
			int b = qy.poll();
			
			for(int i=0;i<8;i++) {//8방탐색
				int nx= a+dx[i];
				int ny =b+dy[i];
				if(nx>=0&&ny>=0&&nx<l&&ny<l&&!visit[nx][ny]) {
					qx.add(nx);
					qy.add(ny);
					visit[nx][ny]=true;
					
					map[nx][ny]=map[a][b]+1;//횟수 저장
				}
			}
			
		}
		
		
		
	}

}
