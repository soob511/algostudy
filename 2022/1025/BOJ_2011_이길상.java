import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int L = input.length;

        int[] dp = new int[L];
        // 잘못된 암호
        if (input[0] == '0') {
            System.out.println(0);
            return;
        }
        dp[0] = 1;

        if (L > 1) {
            // 잘못된 암호
            if (input[1] == '0' && input[0] != '2' && input[0] != '1') {
                System.out.println(0);
                return;
            }
            if (input[1] > '0')
                dp[1] = dp[0];
            if ((input[1] <= '6' && input[0] == '2') || input[0] == '1')
                dp[1] += 1;
        }

        if (L > 2) {
            for (int i = 2; i < L; i++) {
                // 잘못된 암호
                if (input[i] == '0' && input[i - 1] != '2' && input[i - 1] != '1') {
                    System.out.println(0);
                    return;
                }

                if (input[i] > '0')
                    dp[i] = dp[i - 1];
                if ((input[i] <= '6' && input[i - 1] == '2') || input[i - 1] == '1')
                    dp[i] += dp[i - 2];

                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[L - 1]);
    }

}
