import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위던지기_정승우 {
    static int n,m,x,y,k;
    static int[][]map;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0,};
    static int[] dice = {0,0,0,0,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            int mv = Integer.parseInt(st.nextToken())-1;
            x += dr[mv];
            y += dc[mv];
            if(x>=0&&y>=0&&x<n&&y<m) {
                switch (mv) {
                    case 0:
                        mv_right();
                        break;
                    case 1:
                        mv_left();
                        break;
                    case 2:
                        mv_up();
                        break;
                    case 3:
                        mv_down();
                        break;
                }

                if(map[x][y] == 0 ) {
                    map[x][y] = dice[1];
                } else {
                    dice[1] = map[x][y];
                    map[x][y] = 0;
                }
                System.out.println(dice[0]);
            } else {
                x-=dr[mv];
                y-=dc[mv];
            }
        }
    }
    public static void mv_right() {
        int tmp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[5];
        dice[5] = tmp;

    }

    public static void mv_left() {
        int tmp = dice[0];
        dice[0] = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[4];
        dice[4] = tmp;

    }

    public static void mv_up() {
        int tmp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[3];
        dice[3] = tmp;

    }

    public static void mv_down() {
        int tmp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[1];
        dice[1] = dice[2];
        dice[2] = tmp;

    }
}
