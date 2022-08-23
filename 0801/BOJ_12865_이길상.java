import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int[] dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            int W = Integer.parseInt(line[0]);
            int V = Integer.parseInt(line[1]);
            for (int j = K-W; j >= 0; j--) {
                if (dp[j]+V > dp[j+W])
                    dp[j+W] = dp[j]+V;
            } 
        }

        System.out.println(dp[K]);

    }
}
