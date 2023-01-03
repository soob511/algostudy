import java.io.*;

public class BOJ_2156_이길상 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input N
        int N = Integer.parseInt(br.readLine());

        int[][] dp  = new int[N+3][3];

        for (int i = 3; i < N+3; i++) {
            // input wine
            int wine = Integer.parseInt(br.readLine());

            // dp[n][i] : 직전에 i개의 잔을 마시지 않은 상황에서 이번 잔을 마셨을 때, 최대값
            dp[i][0] = wine + Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = wine + Math.max(Math.max(dp[i-2][0], dp[i-2][1]), dp[i-2][2]);
            dp[i][2] = wine + Math.max(Math.max(dp[i-3][0], dp[i-3][1]), dp[i-3][2]);
        }

        System.out.println(
            Math.max( 
                Math.max(Math.max(dp[N+1][0], dp[N+1][1]), dp[N+1][2]),
                Math.max(Math.max(dp[N+2][0], dp[N+2][1]), dp[N+2][2])
            )
        );
    }
}
