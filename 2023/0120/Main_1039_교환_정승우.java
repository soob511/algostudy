import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1039_교환_정승우 {
    static int k, res, len;
    static String n;
    static int[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = st.nextToken();
        k = Integer.parseInt(st.nextToken());
        len = n.length();
        check = new int[k+1][1000001];
        res = -1;
        res = dfs(n, 0);

        }

    static int dfs(String strN, int depth) {
        int num = Integer.parseInt(strN);
        if (depth==k) return num;

        int ret = check[depth][num];
        if(ret!=0) return ret;

        ret = -1;
        for (int i = 0; i < len-1; i++)
        {
            for (int j = i+1; j < len; j++)
            {
                if (i==0 && strN.charAt(j)=='0') continue;
                String tmpStr = swapLoc(strN,i,j);
                int tRet = dfs(tmpStr, depth+1);
                ret = tRet > ret? tRet:ret;
            }
        }
        check[depth][num] = ret;
        return ret;
    }

    static String swapLoc(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }
}
