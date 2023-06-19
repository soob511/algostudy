package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_3055_탈출 {
    static int r,c;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int result = Integer.MAX_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         r = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());

         map = new char[r][c];
        for (int i = 0; i <r; i++) {
            String s = br.readLine();
            for (int j = 0; j <c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i <r; i++) {
            for (int j = 0; j <c; j++) {
                if(map[i][j]=='*'){
                    water.add(new int[]{i,j});
                }else if(map[i][j]=='S'){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        bfs();
        System.out.println(result==Integer.MAX_VALUE?"KAKTUS":result);
    }

    private static void bfs() {
        while (!q.isEmpty()) {

            int size = water.size();
            while (size-->0){
                int[] p = water.poll();
                int x = p[0];
                int y = p[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny]=='.') {
                        map[nx][ny] = '*';
                        water.add(new int[]{nx,ny});
                    }
                }
            }

            size = q.size();
            while(size-->0){
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                int time = p[2];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if(map[nx][ny]=='D'){
                            result=Math.min(result,time+1);
                            return;
                        }else if(map[nx][ny]=='.'){
                            map[nx][ny] = 'S';
                            q.add(new int[]{nx,ny,time+1});
                        }
                    }
                }
            }
        }
    }
}
