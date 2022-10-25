package com.bj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_BJ_1068_트리_김주은 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] tree = new int[N];

		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
		}

		boolean[] isLeaf = new boolean[N];
		Arrays.fill(isLeaf, true);

		int del = sc.nextInt();
		tree[del] = -2;
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// 지울 노드의 직속 자식
		for (int i = 0; i < N; i++) {
			if (tree[i] == del) {
				queue.add(i);
				tree[i] = -2;
			}
		}

		while (!queue.isEmpty()) {

			int val = queue.poll();

			for (int i = 0; i < N; i++) {
				if (tree[i] == val) {
					queue.add(i);
					tree[i] = -2;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (tree[i] >= 0) {
				isLeaf[tree[i]] = false;
			}
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			if (tree[i] != -2 && isLeaf[i]) {
				++count;
			}
		}

		System.out.println(count);
	}

}
