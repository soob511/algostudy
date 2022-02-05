package day0208;

import java.io.*;
import java.util.*;

public class BOJ_10870_이길상 {

	static int Fibo(int n) {
		if(n<2) return n;
		else return Fibo(n-1) + Fibo(n-2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Fibo(sc.nextInt()));
	
		sc.close();
	}

}
