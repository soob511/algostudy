package unionfind;

import java.io.*;
import java.util.*;

public class Main_20040_사이클게임 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
        for(int t=1;t<=m;t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(find(i)==find(j)){
                System.out.println(t);
                return;
            }else{
                union(i,j);
            }
        }
        System.out.println(0);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b){
            arr[b]=a;
        }
    }

    private static int find(int a) {
        if(arr[a]==a){
            return a;
        }else{
            return arr[a] = find(arr[a]);
        }
    }
}
