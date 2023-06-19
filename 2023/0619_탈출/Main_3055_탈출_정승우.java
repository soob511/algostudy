import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출_정승우 {
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static Queue<Pos> queue1;
    static Queue<Pos> queue2;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();


        for(int i=0; i<n; i++) {
            String str = br.readLine();

            for(int j=0; j<m; j++) {
                if(str.charAt(j)=='S') {
                    queue1.add(new Pos(i,j,0));
                }
                if(str.charAt(j)=='*') {
                    queue2.add(new Pos(i,j));
                }
                map[i][j] = str.charAt(j);
            }
        }

        bfs();
        if(answer==Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }

    }

    private static void bfs() {
        while(!queue1.isEmpty()) {

            // 물 먼저 이동
            int len = queue2.size();
            for(int i=0; i<len; i++) {
                Pos p = queue2.poll();
                int r = p.r;
                int c = p.c;

                for(int d=0; d<4; d++) {
                    int nr = r+dr[d];
                    int nc = c+dc[d];
                    if(0<=nr&&0<=nc&&nr<n&&nc<m) {
                        if(map[nr][nc]=='.') {
                            map[nr][nc] = '*';
                            queue2.add(new Pos(nr,nc));
                        }
                    }
                }
            }
            len = queue1.size();
            for(int i=0; i<len; i++) {
                Pos p = queue1.poll();
                int r = p.r;
                int c = p.c;
                int t = p.t;

                for(int d=0; d<4; d++) {
                    int nr = r+dr[d];
                    int nc = c+dc[d];
                    if(0<=nr&&0<=nc&&nr<n&&nc<m) {

                        if(map[nr][nc]=='D') {
                            answer = Math.min(answer, t+1);
                            return;
                        } else if(map[nr][nc]=='.') {
                            map[nr][nc]='S';
                            queue1.add(new Pos(nr,nc,t+1));
                        }
                    }
                }
            }
        }
    }

    static class Pos {
        int r;
        int c;
        int t;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Pos(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }

    }
}
