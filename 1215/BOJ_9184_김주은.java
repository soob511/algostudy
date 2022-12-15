package com.bj;

import java.util.*;
import java.io.*;

public class Main_BJ_9184_신나는함수실행_김주은 {

	static int[][][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {

			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			// dp = new int[101][101][101];
//			for(int i=0;i<102;i++) {
//				for(int j=0;j<102;j++) {
//					Arrays.fill(dp[i][j], Integer.MAX_VALUE);
//				}
//			}

			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c));

		}

		System.out.println(sb);
	}

	private static int w(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		} else if (a < b && b < c) {
			return w(a, b, c - 1) + w(a, b - 1, c - 1) + w(a, b - 1, c);
		} else {
			return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}

	}

}
