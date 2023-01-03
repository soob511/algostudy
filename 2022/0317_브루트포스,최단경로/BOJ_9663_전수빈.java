package study;

import java.util.*;

public class Main_9663_NQueen {
	static int[] row;
	static int n;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		row = new int[n];
		queen(0);
		
		System.out.println(count);
		
	}

	private static void queen(int r) { //r 을 행
		if(r==n) { //퀸을 다 놓으면 카운트
			count++;
			return;
		}
		for(int i=0;i<n;i++) {//i를 열
			row[r] = i;
			
			if(check(r)) {//퀸을 놓을수 있다면
				queen(r+1);//다음 퀸 놓기
			}
			
		}
		return;
		
	}

	private static boolean check(int r) {//
		for(int i=0;i<r;i++) {//r을 다음퀸 i를 현재있는 퀸
			
			if(row[r]==row[i]||Math.abs(r-i)==Math.abs(row[r]-row[i])) {//같은 열 있으면 안됨 , 대각선 있으면안됨
				return false;//놓으면 안됨
			}
		}
		return true;//놓아도됨
	}

}
