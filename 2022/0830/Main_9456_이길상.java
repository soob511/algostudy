import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][N + 2];
            int[][] dp = new int[2][N + 2];

            for (int i = 0; i < 2; i++) {
                String[] line = br.readLine().split(" ");
                for (int n = 0; n < N; n++) {
                    sticker[i][n] = Integer.parseInt(line[n]);
                }
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if(N==1){
                System.out.println(Math.max(dp[0][0], dp[1][0]));
                continue;
            }
            dp[0][1] = sticker[0][1] + dp[1][0];
            dp[1][1] = sticker[1][1] + dp[0][0];
            for (int n = 2; n < N; n++) {
                dp[0][n] = Math.max(dp[1][n-1], dp[1][n-2]) + sticker[0][n];
                dp[1][n] = Math.max(dp[0][n-1], dp[0][n-2]) + sticker[1][n];
            }

            System.out.println(Math.max(Math.max(dp[0][N-1], dp[1][N-1]), Math.max(dp[0][N-2], dp[1][N-2])));
        }
    }
}
