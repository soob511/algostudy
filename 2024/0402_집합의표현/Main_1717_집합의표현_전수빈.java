package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n+1];
        for(int i=1;i<=n;i++){
            map[i] = i;
        }

        for(int t=0;t<m;t++){
            st = new StringTokenizer(br.readLine());
           int num = Integer.parseInt(st.nextToken());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           if(num==0){
               union(a,b);
           }else{
               if(same(a,b)){
                   System.out.println("YES");
               }else{
                   System.out.println("NO");
               }
           }
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
          map[a] =b;
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
