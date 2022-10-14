package Samsung;

import java.io.*;
import java.util.*;

public class Main_나무박멸 {
    static int n, m, k, c;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[][] tree;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] kx = {-1,-1,1,1};//좌상, 우상,우하,좌하
    static int[] ky = {-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//맵 크기
        m = Integer.parseInt(st.nextToken());//진행되는 년수
        k = Integer.parseInt(st.nextToken());//제초제확산 크기
        c = Integer.parseInt(st.nextToken());//제초제 남아있는 년수

        map = new int[n][n];
        tree = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    q.add(new int[]{i, j});
                }
                if(map[i][j]==-1){
                    tree[i][j] = map[i][j];
                }
            }

        }
        grow();//인접한 네개의 칸중 있는수만큼 나무 성장
        move();//확산
        die();//제초제
//        while (m-->0){
//        }
        for (int[] b : tree) System.out.println(Arrays.toString(b));
        System.out.println();

    }

    private static void die() {
        for (int x = 0; x <n; x++) {
            for (int y = 0; y<n; y++) {
                if(tree[x][y]>0){
                    q.add(new int[]{x,y});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        int diex=0;
        int diey=0;
        int size = q.size();
        while(size-->0){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int sum = tree[x][y];
                for(int i=0;i<4;i++){
                    for (int j = 1; j <= k; j++) {
                        int nx = x+kx[i]*j;
                        int ny = y+ky[i]*j;
                        if(nx>=0&&ny>=0&&nx<n&&ny<n&&tree[nx][ny]>0){
                            sum+=tree[nx][ny];
                        }
                    }
                    if(sum>=max){
                        if(sum==max){
                            if(diex<x){
                                diex = x;
                            }else if(diex==x){
                                diey = y;
                            }

                        }else{
                            diex = x;
                            diey = y;
                        }
                    }







                }


        }


    }

    private static void move() {

            int size = q.size();
            while (size--> 0) {
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (map[nx][ny] ==0) {
                        cnt++;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (map[nx][ny] ==0) {
                        tree[nx][ny] += (tree[x][y] / cnt);
                    }
                }

            }
        }
    private static void grow() {
            int size = q.size();
            while (size-- > 0) {
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (map[nx][ny] > 0) {
                        cnt++;
                    }
                }
                tree[x][y] = map[x][y] + cnt;
                q.add(new int[]{x, y});
            }

    }
}
