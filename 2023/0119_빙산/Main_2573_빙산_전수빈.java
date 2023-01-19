package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2573_빙산 {
    static int[][] map;
    static int[][] copy;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         map = new int[n][m];
         copy = new int[n][m];

         //입력
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            //빙산 덩어리 확인
            visit = new boolean[n][m];
            int count=0;
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <m; j++) {
                    if(map[i][j]>0&&!visit[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            if(count>=2){
                System.out.println(result);
                break;
            }else if(count==0){
                System.out.println("0");
                break;
            }

            //몇년후
            result++;

            //빙산줄어듬
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <m; j++) {
                    if(map[i][j]>0){
                        melt(i,j,0);
                    }
                }
            }
            copymap();
        }


    }
    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0||ny<0||nx>=n||ny>=m||visit[nx][ny])continue;
            if(map[nx][ny]>0){
                dfs(nx,ny);
            }
        }
    }
    private static void melt(int x, int y, int zero) {
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0||ny<0||nx>=n||ny>=m)continue;
            if(map[nx][ny]==0){
                zero++;
            }
        }
        copy[x][y] = map[x][y] - zero;
        if(copy[x][y]<0){
            copy[x][y] = 0;
        }
    }

    private static void copymap() {
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }

}
