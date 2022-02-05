package day0208;

import java.io.*;
import java.util.*;

public class BOJ_11729_이길상 {
	static boolean[][] asterisk;
	static int N;
	
	//k 크기의 구멍 만들기
	static void hole(int k) {
		if (k==0) return;
		
		// 3*k 크기를 한 블록으로 생각하며 순회
		for (int i = 0; i < N; i+=(k*3)) {
			for (int j = 0; j < N; j+=(k*3)) {
				// 블록 내부에 구멍을 만들 범위 정하기
				int minX = i + k, minY = j + k;
				int maxX = minX + k, maxY = minY + k;
				
				// 구멍 만드는 중
				for (int x = minX; x < maxX; x++) 
					for (int y = minY; y < maxY; y++) 
						asterisk[x][y] = true;
			}
		}
		
		hole(k/3);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		asterisk = new boolean[N][N];
		hole(N/3);
		
		// 출력이 매우 많기 때문에 StringBuilder 사용
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(asterisk[i][j]? ' ':'*');
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
		sc.close();
	}

}
