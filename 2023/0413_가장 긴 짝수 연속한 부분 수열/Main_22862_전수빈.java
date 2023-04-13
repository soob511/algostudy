package topointer;

import java.io.*;
import java.util.*;

public class Main_22862_가장긴짝수연속한부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num%2==0){//짝수면 체크
                arr[i] = true;
            }
        }

        int l = 0;//부분수열시작
        int r = 0;//부분수열 끝
        int count=0;
        int max = 0;
        while (r<n){
                if(count<k){ //홀수 삭제
                    if(!arr[r]){
                        count++;
                    }
                    r++;
                    max  = Math.max(r-l-count,max);
                }else if(arr[r]){
                    r++;
                    max  = Math.max(r-l-count,max);
                }else{
                    if(!arr[l]){
                        count--;
                    }
                    l++;
                }
        }
        System.out.println(max);

    }
}
