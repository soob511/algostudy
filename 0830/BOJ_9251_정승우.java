import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_정승우 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int r = str1.length();
        int c = str2.length();
        int dp[][] = new int[r+1][c+1];

        for(int i=1; i<= r; i++) {
            for(int j=1; j<=c; j++) {
                //문자가 같은 경우
                if(str1.charAt(i-1)== str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    //이전 행과 열중 가장 큰 값을 가져옴
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[r][c]);
    }


}
