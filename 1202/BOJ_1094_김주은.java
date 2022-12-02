

import java.util.Scanner;

public class Main_BJ_1094_막대기_김주은 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt=0;
		
		for(int i=0;i<7;i++) {
			if((N & (1<<i)) == (1<<i)) {
				++cnt;
			}
		}
		
		System.out.println(cnt);
	}

}
