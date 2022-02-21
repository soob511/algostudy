package com.ssafy.day0222;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2491_정승우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		int cnt =1, cnt2=1;
		int lt=0,rt=1,lt2=N-2,rt2=N-1;
		
		while (true) {
			
			if (lt==N-1) {
				if(max<cnt) max=cnt;
				break;
			}
			if (arr[lt]<=arr[rt]) {
				rt++;
				lt++;
				cnt++;
			}
			else if (arr[lt]>arr[rt]) {
				if (max<cnt) max=cnt;
				cnt=1;
				rt++;
				lt++;
			}
		}
			
		while (true) {
			
			if (rt2==0) {
				if(max<cnt2) max=cnt2;
				break;
			}
			if (arr[rt2]<=arr[lt2]) {
				rt2--;
				lt2--;
				cnt2++;
			}
			else if (arr[rt2]>arr[lt2]) {
				if (max<cnt2) max=cnt2;
				cnt2=1;
				rt2--;
				lt2--;
			}
		}
		System.out.println(max);

	}

}
