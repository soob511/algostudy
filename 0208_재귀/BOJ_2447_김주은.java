package com.ssafy.add.d0208;

import java.util.Scanner;

public class boj_2447_별찍기10 {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
		
//		int T = sc.nextInt();
		int N = 0;
		
//		while(T>1) {
//			T/=3;
//			++N;
//		}
		
		stars(27);
		
	}
	
	public static void stars(int N) {
		
		if(N==1) return;
		
		stars(N/3);
		printstar();
		stars(N/3);
		printstar();
		stars(N/3);
		printstar();
		System.out.println();
		stars(N/3);
		printstar();
		stars(N/3);
		printspace();
		stars(N/3);
		printstar();
		System.out.println();
		stars(N/3);
		printstar();
		stars(N/3);
		printstar();
		stars(N/3);
		printstar();
		System.out.println();
		
	}
	
	public static void printstar() {
		System.out.print("*");
	}
	public static void printspace() {
		System.out.print(" ");
	}

}
