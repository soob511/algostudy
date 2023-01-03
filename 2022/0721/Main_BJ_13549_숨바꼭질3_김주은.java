package com.bj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_BJ_13549_숨바꼭질3_김주은 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int MAX = 100000;

		int[] check = new int[MAX + 1];
		Arrays.fill(check, -1);

		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(N);
		check[N] = 0;

		while (!queue.isEmpty()) {

			int val = queue.poll();

			if (val * 2 <= MAX && check[val * 2] == -1) {// 미방문
				check[val * 2] = check[val];
				queue.addFirst(val * 2);
			}
			
			if(val+1<=MAX && check[val+1]==-1) {
				check[val + 1] = check[val]+1;
				queue.addLast(val + 1);
			}
			
			if(val-1>=0 && check[val-1]==-1) {
				check[val - 1] = check[val]+1;
				queue.addLast(val - 1);
			}

		}
		
		System.out.println(check[K]);

	}

}
