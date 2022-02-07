package com.ssafy.algostudy;

import java.util.Scanner;

public class BOJ_10870_정승우 {
	int recursive(int n) {
		if (n==0) { //n값이 0일때
			return 0; // 0을 return
		} else if (n==1) { //n값이 1일때
			return 1; // 1 reutrn
		}
		else {
			//recursive 매개변수값에 n-2 , n-1값을 더함. n값이 0,1이 되면서 다시 올라가면서 값을 구함 
			return recursive(n-2) + recursive(n-1); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BOJ_10870_정승우 ft = new BOJ_10870_정승우();
		System.out.println(ft.recursive(N));
	}
	


	

}
