package IM;

import java.io.*;
import java.util.*;

public class Main_10157_자리배정 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int c,r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 c = sc.nextInt(); //공연장 크기
		 r = sc.nextInt();
		
		int[][] map = new int[r][c];
		
		int k = sc.nextInt(); //대기번호
		
		int x=r-1; // 왼쪽맨밑부터 시작
		int y=0;
		
		int dir=0;
		int count=1;
		
		if(k>r*c) { // 배정받을 좌석이 없을때
			System.out.println("0");
			System.exit(0);
		}
		
		while(count!=k) {//좌석배정할때까지
			

			map[x][y] = count;
			int nx = x+dx[dir];
			int ny = y+dy[dir];
		
			if(range(nx,ny)&&map[nx][ny]==0) { //이동
				x=nx;
				y=ny;
				count++;
				
			}
			else if(nx<0||ny<0||nx>=r||ny>=c||map[nx][ny]!=0) { //방향전환
			dir++;
			dir=dir%4;
			}

		}

			System.out.println((y+1)+" "+(r-x));

		
		
	}
	private static boolean range(int nx, int ny) {
		// TODO Auto-generated method stub
		return nx>=0&&ny>=0&&nx<r&&ny<c;
	}

	

	

}
