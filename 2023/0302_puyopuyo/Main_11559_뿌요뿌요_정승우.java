import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559_뿌요뿌요_정승우 {

    static class Pos {
        int r;
        int c;
        int color;

        Pos(int r,int c,int color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
    static int[][] map = new int[12][6];
    static boolean[][] check = new boolean[12][6];
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static boolean pop = false;
    static int cnt = 0;
    static Queue<Pos> queue = new LinkedList<>();
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<12; i++) {
            String str = br.readLine();
            for(int j=0; j<6; j++) {
                if(str.charAt(j)=='.') {
                    map[i][j] = 0;
                } else if (str.charAt(j)=='R') {
                    map[i][j] = 1;
                } else if (str.charAt(j)=='G') {
                    map[i][j] = 2;
                } else if (str.charAt(j)=='B') {
                    map[i][j] = 3;
                } else if (str.charAt(j)=='P') {
                    map[i][j] = 4;
                } else if (str.charAt(j)=='Y') {
                    map[i][j] = 5;
                }
            }
        }

        while(true) {
            pop = false;
            check = new boolean[12][6];


            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    if(map[i][j]==0||check[i][j]) {
                        continue;
                    }
                    list = new ArrayList<>();
                    queue.add(new Pos(i,j,map[i][j]));
                    list.add(new int[] {i,j});
                    check[i][j] = true;
                    BFS();
                }
            }
            down();
            if(pop == false) {
                break;
            }
            cnt++;

        }
        System.out.println(cnt);

    }

    private static void BFS() {
        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int r = p.r;
            int c = p.c;
            int color = p.color;

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0<=nr&&0<=nc&&nr<12&&nc<6&&!check[nr][nc]&&map[nr][nc]==color) {
                    queue.add(new Pos(nr, nc, map[nr][nc]));
                    list.add(new int[] {nr,nc});
                    check[nr][nc] = true;
                }
            }
        }

        if(list.size()>=4) {
            for(int i=0; i<list.size(); i++) {
                int r = list.get(i)[0];
                int c = list.get(i)[1];

                map[r][c] = 0;
                pop = true;
            }
        }
    }

    static void down() {
        for(int j=0; j<6; j++) {
            Queue<Pos> queue = new LinkedList<>();
            int idx =11;
            for(int i=11; i>=0; i--) {
                if(map[i][j] != 0) {
                    queue.add(new Pos(i,j,map[i][j]));
                    map[i][j]=0;
                }
            }
            while(!queue.isEmpty()) {
                Pos p = queue.poll();
                int color = p.color;
                map[idx][j] = color;
                idx--;
            }
        }
    }
}
