import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7490_0만들기_정승우 {
    static int tc;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         tc = Integer.parseInt(br.readLine());
         for(int i=0; i<tc; i++) {
             int n = Integer.parseInt(br.readLine());
             dfs(n, 1, 1, 1, 0, "1" );
             sb.append("\n");
         }
        System.out.println(sb.toString());
    }

    private static void dfs(int n, int cur, int num, int sign, int sum, String str) {
        if(n == cur) {
            sum = sum + (num*sign);
            if(sum == 0) {
                sb.append(str+"\n");
            }
            return;
        }
        dfs(n, cur+1, num*10+(cur+1), sign, sum, str+" "+String.valueOf(cur+1));
        dfs(n, cur+1, cur+1, 1, sum+(num*sign), str+ "+" +String.valueOf(cur+1));
        dfs(n, cur+1, cur+1, -1, sum+(num*sign), str+ "-" +String.valueOf(cur+1));
    }
}
