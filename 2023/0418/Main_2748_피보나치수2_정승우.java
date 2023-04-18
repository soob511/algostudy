package DP;

import java.util.Scanner;

public class Main_2748_피보나치수2_정승우 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long dp[] = new long[n+1];


            dp[0] = 0;
            if(n!=0) {
                dp[1] = 1;
            }


        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        System.out.println(dp[n]);
    }
}
