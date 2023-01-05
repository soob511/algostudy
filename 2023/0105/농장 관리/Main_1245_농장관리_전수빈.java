package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_1245_농장관리 {
    static int n,m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,1,-1};
    static int count;
    static boolean top;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         map = new int[n][m];
         visit = new boolean[n][m];

        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
               if(!visit[i][j]&&map[i][j]!=0){
                   top = true;
                   dfs(i,j);
                   if(top){
                       count++;
                   }
               }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for(int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||ny<0||nx>=n||ny>=m)continue;
            if(map[nx][ny]>map[x][y]){
                top=false;
            }
            if(visit[nx][ny])continue;
            if(map[x][y]==map[nx][ny]){
                dfs(nx,ny);
            }
        }
    }

}
