package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M_정승우 {
    static int n,m;
    static int[] arr;
    static int[] res;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        check = new boolean[n];
        res = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);
        System.out.println(sb);



    }

    private static void dfs(int cnt, int idx) {
        if(cnt==m) {
            for(int i=0; i<m; i++) {
                sb.append(res[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<n; i++) {
            res[cnt] = arr[i];
            dfs(cnt+1,i);
        }
    }
}
