package com.ssafy.add.d0222;

import java.util.*;
import java.io.*;

public class Main_BJ_2477_참외밭_김주은 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[]	data = new int[2];
		int[] cnt = new int[5];
		int[] idx = new int[2];
		int[] big = new int[2];
		int[] small = new int[2];
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0;i<6;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			cnt[dir]+=1;
			q.offer(new int[] {dir, len});
		}
		
		
		//한번만 등장하는 방향을 idx 배열에 저장
		int a=0; 
		for(int i=1;i<=4;i++) {
			if(cnt[i]==1) idx[a++]=i;
		}
		
		
		//큰 직사각현 변들에 대한 값을 big배열에 담으며 poll
		int b=0;
		while(true) {
			int[] val = q.poll();
			if(val[0]==idx[0]) {
				big[b++]=val[1];
				if(b==2) break;
			}else if(val[0]==idx[1]) {
				big[b++]=val[1];
				if(b==2) break;
			}else {
				q.offer(val);
			}
		}
		
		//남은 4개의 변 중에서 두번째와 세번째 값이 작은 직사각형의 두 변
		q.poll();
		small[0] = q.poll()[1];
		small[1] = q.poll()[1];

		
		System.out.println(N*(big[0]*big[1]-small[0]*small[1]));
		
	}

}
