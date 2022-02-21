package com.ssafy.day0222;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2564_정승우 {

	static int sum =0,dong =0;
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int arr[] = new int[(X+Y)*2];
		int dir=sc.nextInt();
		
		for (int i = 0; i <= dir; i++) {
			int d = sc.nextInt();
			int n = sc.nextInt();
			
			//이 부분에서 방향처리와 입력처리를 같이함
			//1,2,3,4를 순서대로 받음
			//북쪽 방향일때
			if (d==1) {
				arr[n-1]=i+1; 
			//남쪽 방향일떄
			} else if (d==2) {
				arr[X+Y+n]=i+1;
			//서쪽 방향일떄	
			} else if (d==3) {
				arr[X*2+Y+n]=i+1;
			//동쪽 방향일때	
			} else if (d==4) {
				arr[X+n]=i+1;
			}
		}
		System.out.println(Arrays.toString(arr));
		int cnt =0;
		while (arr[cnt]!=dir+1) {
			cnt++;
		}
		System.out.println(cnt);
		
		
		for (int i=1; i<=dir; i++) {
			int pos=0;
			
			for (int j=0; j<arr.length; j++) {
				
				if (arr[j]==i) {
					pos = j;
					sum+=Math.abs(Math.min(cnt-pos, arr.length-(cnt-pos)));
					return;
				}
				

			}

		}
		System.out.println(sum);

	}

}

	
	