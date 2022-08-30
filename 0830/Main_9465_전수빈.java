package dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++){

            int n =  Integer.parseInt(br.readLine());
            int[][] map = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for(int i=0;i<2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int[] b:map) System.out.println(Arrays.toString(b));System.out.println();
            dp[0][1] = map[0][1];
            dp[0][2] = map[0][2];

            for(int j=2;j<=n;j++){
                dp[0][j] = Math.max(dp[1][j-1],dp[1][j-2])+map[0][j];
                dp[1][j] = Math.max(dp[0][j-1],dp[0][j-2])+map[1][j];
            }

            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }

    }
}
