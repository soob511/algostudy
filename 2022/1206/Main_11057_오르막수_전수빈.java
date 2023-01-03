package study;

import java.util.Scanner;

public class Main_11057_오르막수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];
        for(int i=0;i<10;i++){
          dp[0][i] = 1;
        }
        for (int i = 1; i <=n; i++) {
             int sum=0;
            for (int j = 0; j <10; j++) {
                sum += dp[i-1][j];
            }
            dp[i][0] = sum;
            for (int j = 1; j <10; j++) {
                dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
            }
        }
        System.out.println(dp[n][0]%10007);

    }
}
