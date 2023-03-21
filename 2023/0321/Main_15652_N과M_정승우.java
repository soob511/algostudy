package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M_정승우 {
    static int n,m;
    static int[] res;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new int[m];
        arr = new int[n];
        check = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        dfs(0, 0);
        System.out.println(sb);


    }

    private static void dfs(int idx, int cnt) {
        if(cnt==m) {
            for(int i=0; i<m; i++) {
                sb.append(res[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<n; i++) {

            res[cnt] = arr[i];
            dfs(i, cnt+1);

        }
    }
}
