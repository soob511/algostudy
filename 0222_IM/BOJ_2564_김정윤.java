package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_김정윤 {
	
	static int[] dir;	// direction
	static int[] dis;	// distance
	static int shorestPath = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int width = Integer.parseInt(st.nextToken());	// 가로 길이
		int height = Integer.parseInt(st.nextToken());	// 세로 길이
		
		int store = Integer.parseInt(br.readLine());	// 상점 개수
		
		dir = new int[store];
		dis = new int[store];
		for(int s=0; s<store; s++) {
			st = new StringTokenizer(br.readLine(), " ");
			dir[s] = Integer.parseInt(st.nextToken());
			dis[s] = Integer.parseInt(st.nextToken());	
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int dongDir = Integer.parseInt(st.nextToken());	// 동근이 direction
		int dongDis = Integer.parseInt(st.nextToken());	// 동근이 distance
		
		// 상점이 위치한 direction과 동근이의 direction 비교
		int minDis = 0, chDir = 0;
		for(int i=0; i<store; i++) {
			while(true) {	// 방향이 같아질 때까지 반복
				if(dir[i]==dongDir) {	// 방향이 같으면
					shorestPath += Math.abs(dongDir-dir[i]);
					break;
				}
				if(dongDir==2) {	// 남쪽인 경우
					shorestPath += Math.min(width-dis[i], dis[i]);	// 짧은 거리 선택
					if(Math.min(width-dis[i], dis[i])==dis[i]) {	// 동근이가 더 작은 경우 시계방향
						dongDir = 3;
					}else {	// 반시계방향
						dongDir = 4;
					}
				}
				if(dongDir==3) {	// 서쪽인 경우
					shorestPath += Math.min(height-dis[i], dis[i]);	// 짧은 거리 선택
					if(Math.min(height-dis[i], dis[i])==dis[i]) {	// 동근이가 더 작은 경우 시계방향
						dongDir = 1;
					}else {	// 반시계방향
						dongDir = 2;
					}
				}
				if(dongDir==1) {	// 북쪽인 경우
					shorestPath += Math.min(width-dis[i], dis[i]);	// 짧은 거리 선택
					if(Math.min(width-dis[i], dis[i])==dis[i]) {	// 동근이가 더 작은 경우 반시계방향
						dongDir = 3;
					}else {	// 시계방향
						dongDir = 4;
					}
				}
				if(dongDir==4) {	// 동쪽인 경우
					shorestPath += Math.min(height-dis[i], dis[i]);	// 짧은 거리 선택
					if(Math.min(height-dis[i], dis[i])==dis[i]) {	// 동근이가 더 작은 경우 반시계방향
						dongDir = 1;
					}else {	// 시계방향
						dongDir = 2;
					}
				}		
			}	
		}
		
		System.out.print(shorestPath);
		
	}

}
