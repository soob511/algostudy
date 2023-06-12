package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_17836_공주님을구해라 {
    static int n, m, t;
    static int[][] map;
    static int[][] copy;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int num,gx,gy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    gx = i;
                    gy = j;
                }
            }
        }
        visit = new boolean[n][m];
        bfs();
        int result = copy[n - 1][m - 1];
        if(num!=0){
            copy = new int[n][m];
            visit = new boolean[n][m];
            nife();
            int a = copy[n-1][m-1]+num;
            if(result==0){
                result=a;
            }else{
                result = Math.min(result,a);
            }
        }
        if(result>0&&result<=t){
            System.out.println(result);
        }else{
            System.out.println("Fail");
        }
    }

    private static void nife() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{gx,gy});
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                copy[nx][ny] = copy[x][y] + 1;
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || map[nx][ny] == 1) continue;
                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                copy[nx][ny] = copy[x][y] + 1;
                if(map[nx][ny]==2){
                    num = copy[nx][ny];
                }
            }
        }
    }


}
