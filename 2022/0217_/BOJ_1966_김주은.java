package com.ssafy.add.d0217;

import java.io.*;
import java.util.*;

public class boj_1966_프린터큐_김주은 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //문서의 개수
			int M = Integer.parseInt(st.nextToken()); //몇번째로 인쇄되었는지 궁금한 문서가 현재 큐에서 몇번째에 놓여있는지
			
			//1. Queue 생성
			LinkedList<int[]> q = new LinkedList<int[]>(); 
			
			//2. 큐에 add하기.배열에 입력받기.		
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				q.offer(new int[]{i,Integer.parseInt(st.nextToken())}); //0열 위치 인덱스, 1열 중요도
			}
			
			//3. 현재 가장 큰 중요도 값 구하기
			int maxImpt = checkMaxImpt(q);
			
			int ans=0;
			
			//4. 중요도에 따라 poll하며 원하는 인덱스(M)의 출력 순서 찾기
			while(!q.isEmpty()) {
				
				//일단 현재 값 poll
				int[] val = q.poll();
				
				//현재 가장 높은 중요도를 가진 것이 poll 된 경우
				if(val[1]==maxImpt) {
					maxImpt = checkMaxImpt(q); //다음 높은 중요도 계산
					++ans; // 출력된 횟수 증가
					if(val[0]==M) { //poll된 것의 인덱스가 정답과 같은 경우
						break;
					}
				}
				//가장 높은 중요도가 poll된 것이 아닌 경우 다시 offer
				else {
					q.offer(val);
				}
				
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);

	}
	
	static int checkMaxImpt(LinkedList<int[]> q) {		
		int size = q.size();
		int maxImpt = -1;
		for(int i=0;i<size;i++) {
			int[] t = q.get(i);
			if(maxImpt<t[1]) {
				maxImpt = t[1];
			}
		}
		return maxImpt;
		
	}

}
