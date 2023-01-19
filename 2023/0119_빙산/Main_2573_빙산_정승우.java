
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산_정승우 {
    static int n,m,tmp;
    static int year;
    static int count; // 빙하 개수 count
    static int[][] map, map2;
    static boolean[][] check;
    static boolean[][] check2;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};

    static Queue<pos> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //녹기전
        map = new int[n][m];
        //녹은 후
        map2 = new int[n][m];
        check = new boolean[n][m];
        check2 = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            count=0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j]!=0) {
                        check[i][j] = true;
                        dfs(i, j);
                    }

                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    map[i][j] = map2[i][j];
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(!check2[i][j]&&map[i][j]!=0) {
                        check2[i][j] = true;
                        queue.add(new pos(i,j));
                        bfs();
                        count++;
                    }
                }
            }
            check = new boolean[n][m];
            check2 = new boolean[n][m];
//            count = 0;

            year++;

            if(count>=2) {
                System.out.println(year);
                break;
            } else if(count==0) {
                System.out.println(0);
                break;
            }
        }
    }


    private static void dfs(int i, int j) {

        //0의 개수를 센다
        int cnt = 0;
        //빙하 녹는부분 처리
        for(int d=0; d<4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            if(nr>=0&&nc>=0&&nr<n&&nc<m) {
                if(map[nr][nc]==0) {
                    cnt++;
                }
            }
            //tmp에 0의 개수 저장
            if(d==3) {
                tmp = cnt;
            }
        }
        //해당 칸에 녹은 후 빙하를 저장
        map2[i][j] = map[i][j] - tmp;

        if(map2[i][j] < 0) {
            map2[i][j] = 0;
        }

    }

    //몇개의 빙하 덩어리가 있는지 확인
    private static void bfs() {
        while(!queue.isEmpty()) {
            pos p = queue.poll();
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr>=0&&nc>=0&&nr<n&&nc<m&&!check2[nr][nc]&&map[nr][nc]!=0) {
                    queue.add(new pos(nr,nc));
                    check2[nr][nc] = true;
                }
            }
        }
    }

    public static class pos {
        int r,c;

        pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}