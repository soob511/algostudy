package unionfind;

import java.io.*;
import java.util.*;


public class Main_1976_여행가자 {
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n+1];
        for(int i=1;i<=n;i++){
            map[i] = i;
        }

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1){
                    union(i,j);
                }
            }
        }
        int[] arr = new int[m+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean pass = true;
        for(int i=1;i<m;i++){
            if(!same(arr[i],arr[i+1])){
                pass= false;
                break;
            }
        }
        if(pass){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
    private static boolean same(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b){
            return true;
        }else{
            return false;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b){
            map[b] = a;
        }
    }

    private static int find(int a) {
        if(map[a]==a){
            return a;
        }else{
            return map[a] = find(map[a]);
        }
    }
}
