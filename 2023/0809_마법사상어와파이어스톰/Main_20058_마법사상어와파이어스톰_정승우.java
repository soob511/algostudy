import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사상어와파이어스톰_정승우 {
    static int n,q,b,l;
    static int[][] map;
    static int[] level;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static boolean[][] visited;
    static int sum,max;
    static Queue<Pos> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        b = (int) Math.pow(2,n);

        map = new int[b][b];
        visited = new boolean[b][b];
        for(int i=0; i<b; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<b; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        level = new int[q];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<q; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }


        //q번 시전

        for(int i=0; i<q; i++) {
            l = (int) Math.pow(2,level[i]);
            area();
            reduce();
        }
         for(int i=0; i<b; i++) {
             for(int j=0; j<b; j++) {
                 sum += map[i][j];
             }
         }
         for(int i=0; i<b; i++) {
             for(int j=0; j<b; j++) {
                 if(!visited[i][j]) {
                     queue.add(new Pos(i,j));
                     bfs();
                 }
             }
         }

        System.out.println(sum);
        System.out.println(max);


    }

    private static void bfs() {
        int cnt = 0;
        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int r = p.r;
            int c = p.c;
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(0<=nr&&0<=nc&&nr<b&&nc<b&&!visited[nr][nc]&&map[nr][nc]>0) {
                    cnt++;
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr,nc));
                }
            }
        }
        max = Math.max(max,cnt);
    }

    private static void reduce() {
        int[][] tmp = new int[b][b];
        //복사해놓고
        for(int i=0; i<b; i++) {
            for(int j=0; j<b; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        for(int i=0; i<b; i++) {
            for(int j=0; j<b; j++) {
                if(tmp[i][j]==0) continue;
                int cnt = 0;
                for(int d=0; d<4; d++) {
                    int nr = i+dr[d];
                    int nc = j+dc[d];
                    if(0<=nr&&0<=nc&&nr<b&&nc<b&&0<tmp[nr][nc]) {
                        cnt++;
                    }
                }
                if(cnt<3) {
                    map[i][j]--;
                }
            }
        }



    }

    private static void area() {
        for(int i=0; i<b; i+=l) {
            for(int j=0; j<b; j+=l) {
                turn(i,j);
            }

        }
    }

    private static void turn(int r,int c) {
        int[][] tmp = new int[l][l];
        for(int i=0; i<l; i++) {
            for(int j=0; j<l; j++) {
                tmp[i][j] = map[r+l-1-j][c+i];
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                map[r+i][c+j] = tmp[i][j];
            }
        }
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
