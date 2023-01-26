package graph;

import java.io.*;
import java.util.*;

public class Main_11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int INF = 10000000;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                map[i][j] = INF;
                if(i==j){
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b],c);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if(map[i][j]==INF){
                   map[i][j]=0;
               }
               sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
