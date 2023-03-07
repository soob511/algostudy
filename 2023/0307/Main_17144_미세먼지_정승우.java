import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지_정승우 {
    static int r,c,t;
    static int air_r, air_c;
    static int[][] map;
    //01 -10 0-1 10 상승기류
    //01 10 0-1 -10 하강기류
    static int[] dr = {0,-1,0,1};
    static int[] dc = {1,0,-1,0};
    static int[] dr2 = {0,1,0,-1};
    static int[] dc2 = {1,0,-1,0};
    static int tmp =0;
    static int res = 0;
    static boolean[][] visited;
    static Queue<Pos> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1) {
                    air_r = i;
                    air_c = j;
                }
            }
        }


        for(int tc=0; tc<t; tc++) {
            spread();
            for(int[] a : map) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println("------------------------------------");
            visited = new boolean[r][c];
            visited[air_r-1][air_c+1] = true;
            cycle(air_r-1, air_c+1);
            for(int[] a : map) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println("------------------------------------");
            visited = new boolean[r][c];
            visited[air_r][air_c+1] = true;
            cycle2(air_r, air_c+1);
            for(int[] a : map) {
                System.out.println(Arrays.toString(a));
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(map[i][j]==-1) continue;
                res += map[i][j];
            }
        }

        System.out.println(res);
    }



    //미세먼지 확산
    private static void spread() {
        q = new LinkedList<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(map[i][j]==-1||map[i][j]==0) continue;
                int share = map[i][j]/5;

                int cnt = 0;
                for(int d=0; d<4; d++) {
                    int nr = i+dr[d];
                    int nc = j+dc[d];

                    if(0<=nr&&0<=nc&&nr<r&&nc<c&&map[nr][nc]!=-1) {
                        map[nr][nc] = map[nr][nc]+share;
                        cnt++;
                    }
                }
                map[i][j] = map[i][j] - share * cnt;
            }
        }
    }

    //공기청정기 순환
    private static void cycle(int r1, int c1) {

            if(map[r1][c1]==-1) return;

            for(int d=0; d<4; d++) {
                int nr = r1+dr[d];
                int nc = c1+dc[d];
                if(0<=nr&&0<=nc&&nr<r&&nc<c&&!visited[nr][nc]) {
                    if(map[r1][c1-1]==-1) {
                        map[r1][c1]=0;
                    }
                     tmp = map[nr][nc];
                     map[nr][nc] = map[r1][c1];
                     visited[nr][nc] = true;
                     cycle(nr,nc);
                }
            }

    }

    private static void cycle2(int r, int c) {
        if(map[r][c]==-1) return;

        for(int d=0; d<4; d++) {
            int nr = r+dr2[d];
            int nc = c+dc2[d];
            if(0<=nr&&0<=nc&&nr<r&&nc<c) {
                if(map[r][c-1]==-1) {
                    map[r][c]=0;
                }
                tmp = map[nr][nc];
                map[nr][nc] = map[r][c];
                cycle(nr,nc);
            }
        }
    }

     static class Pos{
        int r,c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
