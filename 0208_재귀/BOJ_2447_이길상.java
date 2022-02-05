package day0208;

import java.io.*;
import java.util.*;

public class BOJ_2447_이길상 {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	// a 위치에서 c위치로 원판 k개 옮기기. b는 무시
	static void hanoi(int a, int b, int c, int k) {
		// 1개만 옮기는 경우
		if(k==1) {
			sb.append(a + " " + c + "\n");
			count++;
			return;
		}
		
		// 여러개 옮기는 경우
		hanoi(a, c, b, k-1);
		hanoi(a, b, c, 1);
		hanoi(b, a, c, k-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		hanoi(1, 2, 3, sc.nextInt());
		System.out.println(count);
		System.out.println(sb.toString());
		
		sc.close();
	}

}
