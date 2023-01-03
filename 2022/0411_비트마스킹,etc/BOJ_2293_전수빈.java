package dp;

import java.util.Scanner;

public class Main_2293_동전1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt(); //동전종류
		int k = sc.nextInt();//합

		int[] arr = new int[n+1];
		int[] dp = new int[k+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		dp[0]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=arr[i];j<=k;j++) {
				dp[j] = dp[j]+dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
	}

}
