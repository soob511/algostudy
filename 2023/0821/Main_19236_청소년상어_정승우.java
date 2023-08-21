import java.util.*;
import java.io.*;

public class Main_19236_청소년상어_정승우 {
    public static int[][] map;
    public static Fish[] fish;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fish = new Fish[17];
        for(int i = 0; i < 4; i++) {
            st  = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;
                fish[num] = new Fish(num, i, j, dir, 1);
                map[i][j] = num;
            }
        }

        int sx = 0, sy = 0;
        int sd = fish[map[0][0]].dir;
        int eat = map[0][0];
        fish[map[0][0]].alive = 0;
        map[0][0] = -1;

        dfs(sx, sy, sd, eat);

        System.out.println(ans);
    }

    public static void dfs(int sx, int sy, int sd, int eat) {
        ans = Math.max(ans, eat);


        int[][] tempMap = new int[map.length][map.length];
        for(int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
        }


        Fish[] tempFish = new Fish[fish.length];
        for(int i = 1; i <= 16; i++)
            tempFish[i] = new Fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir, fish[i].alive);


        moveFish();

        // 상어 이동
        for(int i = 1; i < 4; i++) {
            int nx = sx + dx[sd] * i;
            int ny = sy + dy[sd] * i;


            if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
                int eatFish = map[nx][ny];
                int nd = fish[eatFish].dir;
                map[sx][sy] = 0;
                map[nx][ny] = -1;
                fish[eatFish].alive = 0;

                dfs(nx, ny, nd, eat+eatFish);

                fish[eatFish].alive = 1;
                map[sx][sy] = -1;
                map[nx][ny] = eatFish;
            }
        }


        for(int j = 0; j < map.length; j++)
            System.arraycopy(tempMap[j], 0, map[j], 0, map.length);

        for(int i=1; i<=16; i++)
            fish[i] = new Fish(tempFish[i].num, tempFish[i].x, tempFish[i].y, tempFish[i].dir, tempFish[i].alive);
    }

    //물고기 이동
    public static void moveFish() {
        for(int i = 1; i < 17; i++) {
            if(fish[i].alive == 0) {
                continue;
            }

            int cnt = 0;
            int dir = fish[i].dir;
            int nx = 0, ny = 0;

            while(cnt < 8) {
                dir %= 8;
                fish[i].dir = dir;

                nx = fish[i].x + dx[dir];
                ny = fish[i].y + dy[dir];


                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) {
                    if(map[nx][ny] == 0) {
                        map[fish[i].x][fish[i].y] = 0;
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    } else {

                        int changeFish = fish[map[nx][ny]].num;
                        fish[changeFish].x = fish[i].x;
                        fish[changeFish].y = fish[i].y;
                        map[fish[changeFish].x][fish[changeFish].y] = changeFish;


                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    }
                    break;
                } else {
                    dir++;
                    cnt++;
                }
            }
        }
    }

}

class Fish {
    int num;
    int x;
    int y;
    int dir;
    int alive;

    Fish(int num, int x, int y, int dir, int alive) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.alive = alive;
    }
}