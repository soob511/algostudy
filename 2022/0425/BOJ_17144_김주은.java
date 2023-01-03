package com.ssafy.add.d0425;

import java.io.*;
import java.util.*;

public class Main_BJ_미세먼지안녕_김주은 {
	
	static int R,C;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		//맵 입력
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t=1;t<=T;t++) {			
			//미세먼지 확산 후 공기청정기 작동
			map = airconditioner(spread(map));
		}
		
		//남아있는 미세먼지 양 
		System.out.println(remainDust(map));
		
	}


	private static int remainDust(int[][] map) {
		
		int answer = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					answer+=map[i][j];
				}
			}
		}
		return answer;
	}


	private static int[][] spread(int[][] map) {
		
		int[][] newmap = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1) {
					newmap[i][j]=-1;
				}
				else if(map[i][j]!=0) {
					
					int dust = map[i][j]/5;
					newmap[i][j]+=map[i][j];
					
					for(int d=0;d<4;d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]==-1) continue;
						
						newmap[nr][nc]+=dust;
						newmap[i][j]-=dust;
					}
				}
			}
		}

		
		return newmap;
	}

	private static int[][] airconditioner(int[][] map) {
		
		//공기 청정기 위치 찾기
		int upper=-1; //윗쪽 공기청정기
		int lower=-1; //아랫쪽 공기청정기
		for(int i=0;i<R;i++) {
			if(map[i][0]==-1) {
				upper=i;
				lower=i+1;
				break;
			}
		}
		
		//윗쪽순환
		for(int i=upper-1;i>=0;i--) { //왼쪽
			map[i+1][0]=map[i][0];
		}
		for(int j=1;j<=C-1;j++) { //위쪽
			map[0][j-1]=map[0][j];
		}
		for(int i=1;i<=upper;i++) { //오른쪽
			map[i-1][C-1]=map[i][C-1];
		}
		for(int j=C-2;j>=1;j--) { //아래쪽
			map[upper][j+1]=map[upper][j];
		}
		map[upper][0]=-1; //공기청정기 위치 표시
		map[upper][1]=0; //깨끗한 공기
		
		//아랫쪽순환
		for(int i=lower+1;i<=R-1;i++) { //왼쪽
			map[i-1][0]=map[i][0];
		}
		for(int j=1;j<=C-1;j++) { //아래쪽
			map[R-1][j-1]=map[R-1][j];
		}
		for(int i=R-2;i>=lower;i--) { //오른쪽
			map[i+1][C-1]=map[i][C-1];
		}
		for(int j=C-2;j>=1;j--) { //위쪽
			map[lower][j+1]=map[lower][j];
		}
		
		map[lower][0]=-1; //공기청정기 위치 표시
		map[lower][1]=0; //깨끗한 공기
		
		return map;
	}
}
