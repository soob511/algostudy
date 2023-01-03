package study;

import java.util.Scanner;

public class Main_2156_포도주시식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		//dp[2] 는 첫번쨰와 두번째를 합한것이 최대값
		if(n>1) {
			dp[2] = arr[1]+arr[2];
		}
		
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}
		System.out.println(dp[n]);
	}

}
