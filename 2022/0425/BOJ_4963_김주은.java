package com.ssafy.add.d0425;

import java.io.*;
import java.util.*;

public class Main_BJ_4963_섬의개수_김주은 {
	
	static int W,H;
	static boolean[][] map;
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W==0 && H==0) break;
			
			map = new boolean[H][W];
			
			//땅 입력
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++	) {
					map[i][j] = Integer.parseInt(st.nextToken())==1?false:true;
				}
			}
			
			int answer=0;
			
			//섬 탐색
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(!map[i][j]) {
						search(i,j);
						++answer;
					}
				}
			}
			
			sb.append(answer).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

	private static void search(int i, int j) {
		
		map[i][j]=true;
		
		for(int d=0;d<8;d++) {
			int nr=i+dr[d];
			int nc=j+dc[d];
			
			if(nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc]) continue;
			
			search(nr,nc);
		}
	}

}
