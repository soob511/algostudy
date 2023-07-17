
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, k;
    static int r, c, m, s, d;
    static Queue<int[]>[][] map;
    static Queue<int[]>[][] movemap;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};// 상 우상 우 우하 하 좌하 좌 좌상
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //맵크기
        M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
        k = Integer.parseInt(st.nextToken()); // 이동수

        map = new LinkedList[N][N];
        movemap = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
                movemap[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1; //위치
            c = Integer.parseInt(st.nextToken()) - 1;
            m = Integer.parseInt(st.nextToken()); // 질량
            s = Integer.parseInt(st.nextToken()); //속력
            d = Integer.parseInt(st.nextToken());//방향
            map[r][c].add(new int[]{m, s, d});
        }

        while (k-- > 0) {
            move(); //이동
            check();//2개이상 파이어볼
        }
        int sum=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = map[i][j].size();
                while (size-->0){
                    if(!map[i][j].isEmpty()){
                        int[] p = map[i][j].poll();
                        sum+= p[0];
                    }

                }
            }
        }
        System.out.println(sum);

    }

    private static void check() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int size = movemap[x][y].size();
                if (size >= 2) {
                    int dir = 0; //합쳐지는방향
                    int weight = 0; //질량
                    int speed = 0; //방향
                    while (!movemap[x][y].isEmpty()) {
                        int[] p = movemap[x][y].poll();
                        weight += p[0];
                        speed += p[1];
                        if (p[2] % 2 == 1) {//홀수
                            dir++;
                        }
                    }
                    if ((weight /= 5) == 0) {//질량이0이면 소멸
                        continue;
                    }
                    speed/=size; //속력 = 속력의 합/ 합쳐진 파이어볼의 갯수

                    if(dir==0||dir==size){//모두 홀수거나 모두 짝수
                        for(int d=0;d<8;d+=2){//0 2 4 6
                            map[x][y].add(new int[]{weight,speed,d});
                        }
                    }else{
                        for (int d = 1; d <8; d+=2) {//1 3 5 7
                            map[x][y].add(new int[]{weight,speed,d});
                        }
                    }


                }else if (size==1){
                    map[x][y].add(movemap[x][y].poll());
                }

            }
        }


    }

    private static void move() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                while (!map[x][y].isEmpty()) {
                    int[] p = map[x][y].poll();
                    int s = p[1];
                    int d = p[2];
                    int nx = (x + dx[d] * s)%N;
                    int ny =(y + dy[d] * s)%N;
                    if(nx<0){
                        nx+=N;
                    }else if(nx>=N){
                        nx-=N;
                    }
                    if(ny<0){
                        ny+=N;
                    }else if(ny>=N){
                        ny-=N;
                    }
                    movemap[nx][ny].add(p);
                }
            }
        }


    }

}
