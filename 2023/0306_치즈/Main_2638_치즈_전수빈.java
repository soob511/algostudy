package implement;

import java.io.*;
import java.util.*;

public class Main_2638_치즈 {
    static int n,m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean check;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         map = new int[n][m];
        for (int i = 0; i <n; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            check = true;
            out();
            cheese();
            if (check)break;
            result++;
        }
        System.out.println(result);
    }
    private static void out() {
        visit = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if(map[i][j]==0){
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                    while (!q.isEmpty()){
                        int[] p = q.poll();
                        int x = p[0];
                        int y = p[1];
                        for (int d = 0; d <4; d++) {
                            int nx = x+dx[d];
                            int ny = y+ dy[d];
                            if (nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==1||visit[nx][ny])continue;
                            q.add(new int[]{nx,ny});
                            visit[nx][ny] = true;
                        }
                    }
                    break;
                }
            }
        }
    }

    private static void cheese() {
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if(map[i][j]==1){
                    check = false;
                    int cnt = 0;
                    for (int d = 0; d <4; d++) {
                        int nx = i + dx[d];
                        int ny = j +dy[d];
                        if (nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==1)continue;
                        if(visit[nx][ny]){
                            cnt++;
                        }
                    }
                    if(cnt>=2){
                        map[i][j]=0;
                    }
                }
            }
        }
    }

}
