import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23288_주사위굴리기2_정승우 {
    static int n,m,k,cnt,score;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static int curD, curR, curC; //  현재 주사위 방향, 현재 주사위 위치 (r,c)
    public static Dice dice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        curD = 0;
        curR = 0;
        curC = 0;
        dice = new Dice();

        for(int i=0; i<k; i++) {
            int nr = curR + dr[curD];
            int nc = curC + dc[curD];
            if(0<=nr&&0<=nc&&nr<n&&nc<m) {
                curR = nr;
                curC = nc;
            } else {
                curD = (curD + 2) % 4;
                curR += dr[curD];
                curC += dc[curD];
            }
            roll();
            int B = map[curR][curC];
            cnt = 1;
            visited = new boolean[n][m];
            visited[curR][curC] = true;
            dfs(B, curR, curC);
            score += B * cnt;

            if(dice.bottom > B) {
                changeDir(1);
            } else if (dice.bottom < B) {
                changeDir(2);
            }

        }
        System.out.println(score);
    }

    private static void changeDir(int c) {
        if (c==0) {
            curD = (curD + 2) % 4;
        } else if (c==1) {
            curD = (curD + 1) % 4;
        } else if (c==2) {
            curD = (curD + 3) % 4;
        }
    }

    private static void dfs(int B, int cR, int cC) {

        for(int d=0; d<4; d++) {
            int nr = cR+dr[d];
            int nc = cC+dc[d];
            if(0<=nr&&0<=nc&&nr<n&&nc<m&&!visited[nr][nc]&&map[nr][nc]==B) {
                visited[nr][nc] = true;
                cnt++;
                dfs(B, nr, nc);
            }
        }
    }

    public static void roll() {
        int tmpTop = dice.top;
        int tmpBottom = dice.bottom;
        int tmpFront = dice.front;
        int tmpBack = dice.back;
        int tmpLeft = dice.left;
        int tmpRight = dice.right;

        // 오른쪽으로 굴리기
        if(curD == 0) {
            dice.bottom = tmpRight;
            dice.top = tmpLeft;
            dice.left = tmpBottom;
            dice.right = tmpTop;
        }
        // 아래로 굴리기
        else if(curD == 1) {
            dice.front = tmpTop;
            dice.top = tmpBack;
            dice.back = tmpBottom;
            dice.bottom = tmpFront;
        }
        // 왼쪽으로 굴리기
        else if(curD == 2) {
            dice.bottom= tmpLeft;
            dice.top = tmpRight;
            dice.left = tmpTop;
            dice.right = tmpBottom;
        }
        // 위로 굴리기
        else if(curD == 3) {
            dice.front = tmpBottom;
            dice.back = tmpTop;
            dice.top = tmpFront;
            dice.bottom = tmpBack;
        }

    }
    static class Dice {
        int top, bottom, left, right, front, back;

        public Dice() {
            this.top = 1;
            this.bottom = 6;
            this.left = 4;
            this.right = 3;
            this.front = 5;
            this.back = 2;
        }
    }
}
