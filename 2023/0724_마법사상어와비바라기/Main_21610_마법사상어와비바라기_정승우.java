import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기_정승우 {
    static int n,m;
    static int[][] map;
    static int[] dr = {0,-1,-1,-1,0,1,1,1};
    static int[] dc = {-1,-1,0,1,1,1,0,-1};
    static boolean[][] check;
    static Queue<Pos> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        check = new boolean[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new Pos(n-1, 0));
        q.add(new Pos(n-1, 1));
        q.add(new Pos(n-2, 0));
        q.add(new Pos(n-2, 1));

        while(0<m) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            for(Pos p : q) {
                p.r = (n + p.r + dr[d] * (s % n)) % n;
                p.c = (n + p.c + dc[d] * (s % n)) % n;
                map[p.r][p.c]++;
            }

            while(!q.isEmpty()) {
                Pos p = q.poll();
                int x = p.r;
                int y = p.c;
                int cnt = 0;
                check[x][y] = true;

                for(int i=1; i<8; i+=2) {
                    int nr = x+dr[i];
                    int nc = y+dc[i];
                    if(0<=nr&&0<=nc&&nr<n&&nc<n&&1<=map[nr][nc]) {
                        cnt++;
                    }
                }
                map[x][y] += cnt;
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!check[i][j] && 2<=map[i][j]) {
                        map[i][j] -= 2;
                        q.add(new Pos(i,j));
                    }
                }
            }
            check = new boolean[n][n];
            m--;
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                res += map[i][j];
            }
        }
        System.out.println(res);
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
