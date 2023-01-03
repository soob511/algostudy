package IM;

import java.util.*;
import java.io.*;

public class Main_2477_참외밭 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());// 참외의 개수

		int[][] map = new int[6][2];
		//입력
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int width = 0;
		int length = 0;
		int big = 0;
		//전체 면적 구하기
		int widx=0;
		int lidx=0;
		for (int i = 0; i < 6; i++) {

			if (map[i][0] == 1 || map[i][0] == 2) { //가로 길이 구하기
				width = Math.max(map[i][1], width); //제일 긴 길이
				if(width==map[i][1]) {
					widx = i;//변저장
				}
			} else if (map[i][0] == 3 || map[i][0] == 4) {//세로 길이 구하기
				length = Math.max(map[i][1], length);//제일 긴 길이
				if(length==map[i][1]) {
					lidx = i;//변저장
				}
			}
		}
		big = width * length;
		
		//작은 면적 구하기
		int small =0;
		int swidth =map[(widx+3)%6][1];//작은면적 세로변
		int slength =map[(lidx+3)%6][1];//작은면적 가로변
		small = swidth*slength;
		
		System.out.println((big-small)*k);
		
		
	}

}
