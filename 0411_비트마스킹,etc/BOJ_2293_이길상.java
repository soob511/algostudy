import java.io.*;
import java.util.*;

public class BOJ_2293_이길상 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input N, K
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        // input coin
        int[] coin = new int[N];
        for (int n = 0; n < N; n++) {
            coin[n] = Integer.parseInt(br.readLine());
        }
        //Arrays.sort(coin);

        // dp array;
        int[] dp = new int[K+1];
        dp[0] = 1;

        // for (int i = 0; i <= K; i++) {
        //     if(dp[i]>0){
        //         for (int c : coin) {
        //             if(i+c <= K) dp[i+c]+=dp[i];
        //         }
        //     }
        // }
        
        // dp
        for (int C : coin) {
            for (int i = 0; i <= K-C; i++) {
                dp[i+C] += dp[i];
            }
        }
        
        System.out.println(dp[K]);        
    }
}
