import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동_정승우 {
    static int N,L,R;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Pos> q;
    static ArrayList<Pos> list = new ArrayList<>();
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static boolean check;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N][N];
        q = new LinkedList<>();


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        outer:
        while(true) {

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visit[i][j]) {
                        q.add(new Pos(i,j));
                        list.add(new Pos(i,j));
                        visit[i][j] = true;
                        bfs();
                    }
                }
            }
            if(check==false) {
                break outer;
            } else {
                check=false;
                q = new LinkedList<>();
                cnt++;
                visit = new boolean[N][N];
            }
        }
        System.out.println(cnt);
    }

    private static void bfs() {

        while(!q.isEmpty()) {
            Pos p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(0<=nr&&0<=nc&&nr<N&&nc<N&&!visit[nr][nc]) {
                    if(L<=Math.abs(map[r][c]-map[nr][nc])&&Math.abs(map[r][c]-map[nr][nc])<=R) {
                        q.add(new Pos(nr,nc));
                        list.add(new Pos(nr,nc));
                        check = true;
                        visit[nr][nc] = true;
                    }
                }
            }
        }
        int sum = 0;
        for(int i=0; i<list.size(); i++) {
            Pos p = list.get(i);
            int r = p.r;
            int c = p.c;
            sum+= map[r][c];
        }
        for(int i=0; i<list.size(); i++) {
            Pos p = list.get(i);
            int r = p.r;
            int c = p.c;
            map[r][c] = sum/list.size();
        }
        list.removeAll(list);
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
