package Samsung;

import java.util.*;
import java.io.*;

public class Main_예술성 {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());

        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                if(!visit[i][j]){
                    bfs(i,j);
                }
            }
        }



    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        while (!q.isEmpty()){


        }


    }
}
