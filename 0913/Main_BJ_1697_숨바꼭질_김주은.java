package com.bj;

import java.util.*;
import java.io.*;

public class Main_BJ_1697_숨바꼭질_김주은 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int max = 100000;
		boolean[] visit = new boolean[max+1];
		visit[N]=true;
		
		int cnt = 0;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		
		while(!queue.isEmpty()) {
			int s = queue.size();
			while(s-->0) {
				int n = queue.poll();
				visit[n]=true;
				
				if(n==K) { //동생 위치
					System.out.println(cnt);
					System.exit(0);
				}
	
				if(2*n<=max && !visit[2*n]) queue.add(2*n);
				if(n+1<=max && !visit[n+1]) queue.add(n+1);
				if(n-1>=0 && !visit[n-1]) queue.add(n-1);
			}
			++cnt;
		}
	}
}
