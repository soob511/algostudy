package Bruteforce;

import java.io.*;
import java.util.*;

public class Main_2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for (int i = 0; i <n; i++) {
            int count=0;
            int[] eat = new int[d+1];
            for (int j = 0; j <k; j++) {
                if(i+j>=n){
                    eat[arr[(i+j)%n]]++;
                }else{
                    eat[arr[i+j]]++;
                }
            }
            eat[c]++;
            for (int j = 1; j <=d; j++) {
                if(eat[j]!=0){
                    count++;
                }
            }
            max = Math.max(count,max);
        }
        System.out.println(max);
    }
}
