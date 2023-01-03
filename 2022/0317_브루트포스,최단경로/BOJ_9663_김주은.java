package com.ssafy.add.d0317;

import java.io.*;
import java.util.*;

public class Main_BJ_9663_NQueen_김주은 {
	
	static int N;
	static int qcount=0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] map = new int[N];
		
		search(map,0); //map, 퀸을 놓을 0번째 행부터 탐색
		
		System.out.println(qcount);
		
	}
	
	static void search(int[] map, int i) {
		
		if(i>=N) {
			++qcount;
			return;
		}
		
		outer: for(int j=0;j<N;j++) {
			
			//퀸을 놓을 수 없는 경우 체크
			for(int t=0;t<i;t++) {
				//같은 열에 있거나 대각선에 있는 경우
				if(map[t]==j || i-t == Math.abs(map[t]-j)) {
					continue outer;
				}
			}
			
			map[i]=j;
			search(map, i+1);
		}
		return;
	}
}

/*
public class Main_BJ_9663_NQueen_김주은 {
	
	static int N;
	static int qcount=0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[N][N];
		
		search(map, 0); //map, 퀸을 놓을 0번째 행부터 탐색
		
		System.out.println(qcount);
		
	}
	
	static boolean[][] setBlocks(boolean[][] map,int i, int j) {
		//가로 & 세로 true 처리
		for(int t=0;t<N;t++) {
			map[i][t]=map[t][j]=true;
		}
		//대각선 처리
		int d=0;
		while(i+(++d)<N) {
			if(i+d<N && j-d>=0 && !map[i+d][j-d]) { //남서 방향
				map[i+d][j-d]=true;
			}
			if(i+d<N && j+d<N && !map[i+d][j+d]) { //남동 방향
				map[i+d][j+d]=true;
			}
		}
		
		return map;
	}
	
	static void search(boolean[][] map, int i) {
		
		if(i>=N) {
			++qcount;
			return;
		}
		
		boolean[][] prevmap;
		
		for(int j=0;j<N;j++) {
			
			if(map[i][j]) continue; //이미 true이면 continue
			
			System.out.println(i+":"+j);
			
			prevmap = arrayCopy(map);
			
			map = setBlocks(map,i,j); //map[i][j]에 퀸을 둘 때의 map
			
			search(map, i+1);

			if(i==0) {
				map = new boolean[N][N];
			}else {
				map = arrayCopy(prevmap);
			}
		}
		
		return; //행에 아무 퀸도 놓지 않은 경우 리턴
		
	}
	
	static boolean[][] arrayCopy(boolean[][] source){
		boolean[][] dest = new boolean[N][N];
		for(int i=0;i<N;i++) {
			dest[i] = source[i].clone();
		}
		return dest;
	}

}
*/

