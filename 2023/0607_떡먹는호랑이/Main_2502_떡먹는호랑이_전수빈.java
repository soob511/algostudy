package DP;

import java.io.*;
import java.util.*;
public class Main_2502_떡먹는호랑이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[d+1];
        for (int i = 1; i <k/2; i++) {
            dp[1] = i;
            for (int j = i; j <k; j++) {
                dp[2] =j;
                for (int l = 3; l <=d; l++) {
                    dp[l]  = dp[l-1]+dp[l-2];
                }
                if (dp[d]==k){
                    System.out.println(dp[1]);
                    System.out.println(dp[2]);
                    return;
                }
            }
        }
    }
}
