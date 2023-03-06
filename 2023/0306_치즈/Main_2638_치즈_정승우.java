import java.io.*;
import java.util.*;

public class Main_2638_치즈_정승우 {
    static int n,m;
    static int c_num = 0;
    static int t = 0;
    static int[][] map;
    static int[][] air;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]==1) {
                    c_num++;
                }
            }
        }

        //치즈가 없어진다면
        while(c_num != 0) {
            bfs();
        }
        System.out.println(t);

    }

    private static void bfs() {
        air = new int[n][m];
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0,0));
        air[0][0] = -1;

        while(!q.isEmpty()) {
            Pos p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];

                if(nr<0||nc<0||nr>=n||nc>=m) continue;

                if(map[nr][nc] == 1) {
                    air[nr][nc]++;
                }
                if(map[nr][nc] == 0 && air[nr][nc] == 0) {
                    air[nr][nc] = -1;
                    q.offer(new Pos(nr, nc));
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(air[i][j] >= 2) {
                    c_num--;
                    map[i][j] = 0;
                }
            }
        }
        t++;
    }

    static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}

