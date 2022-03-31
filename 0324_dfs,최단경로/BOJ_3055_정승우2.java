package com.ssafy.day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//탈출문제
public class BOJ_3055_정승우2 {
	
	static class pos {
		
		int r;
		int c;
		int cnt;
		
		//고슴도치
		pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		//홍수
		pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		

		
	}
	//방향값 설정
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	//위치값
	static int R,C;
	//결과값
	static int result=Integer.MAX_VALUE;
	static char[][] map;
	

	//고슴도치 큐
	static Queue<pos> hog = new LinkedList<>();
	//물의 큐
	static Queue<pos> water = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
	
		
		for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j]=='S') {
                    hog.add(new pos(i,j,0));
                }else if(map[i][j]=='*'){
                    water.offer(new pos(i,j));
                }
            }
        }

		bfs();
		//result가 max_value면 비버굴에 도착X
		System.out.println(result==Integer.MAX_VALUE?"KAKTUS":result);
		
	}
	
	public static void bfs() {
		
		while (!hog.isEmpty()) {
            // 홍수
            int len = water.size();
            for(int i=0;i<len;i++){
                //t 객체에 water위치값 저장
            	pos t = water.poll();
                int r = t.r;
                int c = t.c;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc]=='.') {
                        map[nr][nc] = '*';
                        water.add(new pos(nr,nc));
                    }
                }
            }

            // 고슴도치 이동
            len = hog.size();
            for(int i=0;i<len;i++){
            	//t객체에 고슴도치 위치값 저장
                pos t = hog.poll();
                int r = t.r;
                int c = t.c;
                int time = t.cnt;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if(map[nr][nc]=='D'){
                            result=Math.min(result,time+1);
                            return;
                        }else if(map[nr][nc]=='.'){
                            map[nr][nc] = 'S';
                            hog.add(new pos(nr,nc,time+1));
                        }
                    }
                }
            }
        }
	}
	

}
