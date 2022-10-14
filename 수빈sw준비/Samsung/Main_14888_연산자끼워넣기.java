package Samsung;



import java.io.*;
import java.util.*;

public class Main_14888_연산자끼워넣기 {
    static int n;
    static int[] arr;
    static int[] num;
    static int min = Integer.MAX_VALUE;
    static  int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        num = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0],1);
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int sum, int idx) {
        if(idx==n){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }

        for(int i=0;i<4;i++){
            if(num[i]>0){
                num[i]--;
                if(i==0){
                    dfs(sum+arr[idx],idx+1);
                }
                else if(i==1){
                    dfs(sum-arr[idx],idx+1);
                }else if(i==2){
                    dfs(sum*arr[idx],idx+1);
                }else
                {
                    dfs(sum/arr[idx],idx+1);
                }
                num[i]++;

            }
        }
    }

}
