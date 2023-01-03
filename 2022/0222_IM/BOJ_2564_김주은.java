package com.ssafy.add.d0222;

import java.util.*;
import java.io.*;

public class Main_BJ_2564_경비원_김주은 {

	static int[][] map;
	static int W, H;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());

		// 방향, 거리 입력
		int[][] place = new int[M+1][2];

		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			place[i][0] = Integer.parseInt(st.nextToken());
			place[i][1] = Integer.parseInt(st.nextToken());
		}

		int distance = 0;
		for (int i = 0; i < M; i++) {
			//dir값이 작은 쪽이 왼쪽 매개변수, 큰 쪽이 오른쪽 매개변수에 들어가도록 실행
			if(place[M][0]<=place[i][0])
				distance += minDistance(place[M], place[i]);
			else {
				distance += minDistance(place[i], place[M]);
			}
		}

		System.out.println(distance);

	}

	static int minDistance(int[] a, int[] b) {
		
		//두 장소가 같은 선에 있는 경우
		if(a[0]==b[0]) return Math.abs(a[1]-b[1]);

		if (a[0] == 1) {
			if(b[0]==2) {
				int add=0;
				if(a[1]+b[1]>=W) {
					add = 2*W-a[1]-b[1];
				}else {
					add = a[1]+b[1];
				}
				return H + add;
			}
			if(b[0]==3) {
				return a[1]+b[1];
			}
			if(b[0]==4) {
				return W-a[1] + b[1];
			}

		} else if (a[0] == 2) {
			if(b[0]==3) {
				return a[1]+H-b[1];
			}
			if(b[0]==4) {
				return W-a[1]+H-b[1];
			}

		} else if (a[0] == 3) {
			if(b[0]==4) {
				int add=0;
				if(a[1]+b[1]>=H) {
					add = 2*H-a[1]-b[1];
				}else {
					add = a[1]+b[1];
				}
				return W + add;
			}

		} 

		return 0;
	}
}
