package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_23290_마법사상어와복제_김주은2 {
	
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	
	static int[] ddr = {-1,0,1,0};
	static int[] ddc = {0,-1,0,1};
	
	static ArrayList<Integer>[][] map = new ArrayList[4][4];
	static int[][] smell = new int[4][4];
	
	static int sx,sy;
	
	static int[] max_path;
	static int max_cnt;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				map[i][j]= new ArrayList<Integer>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			map[x][y].add(d);
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0;i<S;i++) {
			
			ArrayList<Integer>[][] copies = copy();
			
			move();
			
			max_path = new int[3];
			max_cnt = -1;
			shark(0,sx,sy,new int[3]);
			
			sx = max_path[2]/4;
			sy = max_path[2]%4;
			
			for(int j=0;j<3;j++) {
				int px = max_path[j]/4;
				int py = max_path[j]%4;
				if(!map[px][py].isEmpty()) {
					smell[px][py]=3;
					map[px][py].clear();
				}
			}
			
			for(int x=0;x<4;x++) {
				for(int y=0;y<4;y++) {
					if(smell[x][y]>0) {
						smell[x][y]-=1;
					}
				}
			}
			
			paste(copies);
		}
		
		int answer = 0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				answer+=map[i][j].size();
			}
		}
		System.out.println(answer);
	}

	private static void paste(ArrayList<Integer>[][] copies) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(Integer k : copies[i][j]) {
					map[i][j].add(k);
				}
			}
		}
	}

	private static void shark(int idx, int x, int y, int[] path) {
		
		if(idx==3) {
			boolean[][] visited = new boolean[4][4];
			int cnt = 0;
			for(int i=0;i<3;i++) {
				int px = path[i]/4;
				int py = path[i]%4;
				if(!visited[px][py]) {
					visited[px][py]=true;
					cnt+=map[px][py].size();
				}
			}
			
			if(cnt>max_cnt) {
				max_path = Arrays.copyOf(path, 3);
				max_cnt=cnt;
			}
			
			return;
		}
		
		for(int d=0;d<4;d++) {
			int nx = x+ddr[d];
			int ny = y+ddc[d];
			
			if(nx<0 || nx>=4 || ny<0 || ny>=4) {
				continue;
			}
			
			path[idx]=nx*4+ny;
			shark(idx+1,nx,ny,path);
			path[idx]=0;
		}
	}

	private static void move() {
		
		ArrayList<Integer>[][] map2 = new ArrayList[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				map2[i][j]=new ArrayList<>();
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(Integer k : map[i][j]) {
					
					boolean moved = false;
					for(int d=0;d<8;d++) {
						
						int nx = i+dr[(k+8-d)%8];
						int ny = j+dc[(k+8-d)%8];
						
						if(nx<0 || nx>=4 || ny<0 || ny>=4 || smell[nx][ny]>0) {
							continue;
						}
						
						if(nx==sx && ny==sy) {
							continue;
						}
						
						map2[nx][ny].add((k+8-d)%8);
						moved=true;
						break;
					}
					
					if(!moved) {
						map2[i][j].add(k);
					}
				}
			}
		}
		
		map=map2;
		
	}

	private static ArrayList<Integer>[][] copy() {
		ArrayList<Integer>[][] map2 = new ArrayList[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				map2[i][j]=new ArrayList<>();
				for(Integer k : map[i][j]) {
					map2[i][j].add(k);
				}
			}
		}
		return map2;
	}
}
