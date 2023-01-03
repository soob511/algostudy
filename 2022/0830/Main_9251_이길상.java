import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = "0" + br.readLine();
        String B = "0" + br.readLine();
        int AL = A.length();
        int BL = B.length();
        int[][] dp = new int[AL][BL];
        
        for (int a = 0; a < AL; a++) {
            for (int b = 0; b < BL; b++) {
                if (a>0 && b>0){
                    if (A.charAt(a) == B.charAt(b)) dp[a][b] = dp[a-1][b-1] + 1;
                    else dp[a][b] = Math.max(dp[a - 1][b], dp[a][b - 1]);
                }
                else if (A.charAt(a) == B.charAt(b)) dp[a][b] = 0;
            }
        }

        System.out.println(dp[AL-1][BL-1]);
    }
}
