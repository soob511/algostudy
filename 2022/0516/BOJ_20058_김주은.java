package com.ssafy.add.d0516;

import java.io.*;
import java.util.*;

public class Main_BJ_20058_마법사상어와파이어스톰_김주은 {
	
	static int M;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		M = (int) Math.pow(2, N);
		
		int[][] map = new int[M][M];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int q=0;q<Q;q++) {
			int l = Integer.parseInt(st.nextToken());
			map = firestorm(l, map);
		}
	}

	private static int[][] firestorm(int l, int[][] map) {
		
		int[][] newmap = new int[M][M];

		l = (int) Math.pow(2, l);
		
		//2^L크기로 90도 회전
		for(int i=0;i<M;i+=l) {
			for(int j=0;j<M;j+=l) {
						
				//90도 회전
				
				for(int x=i,b=j;x<i+l&&b<j+l;x++,b++) {
					for(int y=j,a=i+(l-1);y<j+l&&a>=i;y++,a--) {
						newmap[x][y]=map[a][b];
					}
				}
				
//				for(int x=i;x<i+l;x++) {
//					for(int y=j;y<j+l;y++) {
//						newmap[x][y]=map[x][y];
//					}
//				}
//				
//				for(int b=j;b<j+l;b++) {
//					for(int a=i+(l-1);a>=i;a--) {
//						newmap[a][b]=map[a][b];
//					}
//				}
				
			}
			System.out.println();
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(newmap[i][j]+" ");
			}
			System.out.println();
		}
		

		return newmap;
	}

}
