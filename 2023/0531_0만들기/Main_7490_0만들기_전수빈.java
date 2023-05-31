package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7490_0만들기 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i <tc; i++) {
            int n = Integer.parseInt(br.readLine());
            dfs(n,1,1,1,0,"1");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int n, int idx, int num, int sign, int sum, String s) {
        if(n == idx) {
            sum = sum + (num * sign);
            if (sum == 0) {
                sb.append(s +"\n");
            }
            return;
        }
        dfs(n, idx+1, num*10+(idx+1), sign, sum, s+ " " +String.valueOf(idx+1));//공백
        dfs(n, idx +1, num+1, 1, sum + (num*sign), s+ "+" +String.valueOf(idx+1));//더하기
        dfs(n, idx+1, num+1, -1, sum + (num*sign), s+ "-" +String.valueOf(idx+1));//뺴기

    }
}
