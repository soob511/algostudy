package 재귀;

import java.util.Scanner;

public class N10870_피보나치수5 {

	static int n;	// n번째 피보나치 수 출력
	static int sum = 0;
	static int cnt = 1;	// 피보나치 반복 횟수
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	
		
		if(n<2) {
			sum = n;
		}
		else {
			Recursive(0, 1);
		}
		
		//Recursive(0, 1);
		
		System.out.println(sum);

	}
	
	
	public static void Recursive(int num1, int num2) {
//		if(n<2) {
//			sum = n;
//			return;
//		}
		
		if(cnt==n) return;
		
		sum = num1 + num2;
		cnt++;
		
		Recursive(num2, sum);
	}
}
