package 코드트리;

import java.io.*;
import java.util.*;

public class Main_포탑부수기 {
    static int[] dx = {0,1,0,-1};//우하좌상
    static int[] dy = {1,0,-1,0};
    static int[] dx2 = {-1,-1,-1,0,1,1,1,0};
    static int[] dy2 = {-1,0,1,1,1,0,-1,-1};
    static int n,m,k;
    static int[][] map,rec;
    static ArrayList<Attack> list;
    static int[][] pathx,pathy;
    static boolean[][] play;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
         map = new int[n][m];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

         rec = new int[n][m];
        int turn = 0;
        while (k-->0){
            turn++;
            //공격자선정
            list = new ArrayList<>();
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <m; j++) {
                    if(map[i][j]>0){
                       list.add(new Attack(i,j,map[i][j],rec[i][j]));
                    }
                }
            }
            if(list.size()==1){//포탑사이즈 1개
                break;
            }
            Collections.sort(list);
            Attack attack = list.get(0);
            int ax = attack.x;
            int ay = attack.y;
            rec[ax][ay] = turn;
            Attack recieve = list.get(list.size()-1);//공격받는포탑
            int rx = recieve.x;
            int ry = recieve.y;

            map[ax][ay] += n+m;//공격자공격력증가
            int power = map[ax][ay];

            pathx = new int[n][m];
            pathy = new int[n][m];

            play = new boolean[n][m];
            play[ax][ay] = true;
            play[rx][ry] = true;
            //레이저 공격
            if(laser()){
                map[rx][ry] -= power;
                int x = pathx[rx][ry];
                int y = pathy[rx][ry];
                while (!(x==ax&&y==ay)){
                    map[x][y] -= power/2;
                    play[x][y] = true;
                    int nx = pathx[x][y];
                    int ny = pathy[x][y];
                    x = nx;
                    y = ny;
                }
            }else{//포탄 공격
                map[rx][ry] -= power;
                for (int d = 0; d <8; d++) {
                    int nx = (rx+dx2[d]+n)%n;
                    int ny = (ry+dy2[d]+m)%m;
                    if(nx==ax&&ny==ay)continue;//공격자제외
                    map[nx][ny] -= power/2;
                    play[nx][ny] = true;
                }

            }

            //포탑부서짐
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <m; j++) {
                    if(map[i][j]<0){
                        map[i][j] = 0;
                    }
                }
            }

            //포탑정비
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <m; j++) {
                    if(map[i][j]>0&&!play[i][j]){
                        map[i][j] +=1;
                    }
                }
            }
            //for (int[]b:map) System.out.println(Arrays.toString(b));System.out.println();
        }

        int answer = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if(map[i][j]>answer){
                    answer = map[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean laser() {
        boolean move = false;
        Attack attack = list.get(0);//공격자
        int ax = attack.x;
        int ay = attack.y;

        Attack recieve = list.get(list.size()-1);//공격받는포탑
        int rx = recieve.x;
        int ry = recieve.y;

        boolean[][] visit = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ax,ay});
        visit[ax][ay] = true;
        while (!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            if(x==rx&&y==ry){
                move = true;
                break;
            }
            for (int d = 0; d <4; d++) {
                int nx = (x+dx[d]+n) %n;
                int ny = (y+dy[d]+m)%m;
                if(visit[nx][ny]||map[nx][ny]==0)continue;//방문했거나 부서진 포탑
                q.add(new int[]{nx,ny});
                visit[nx][ny] = true;
                pathx[nx][ny] = x;
                pathy[nx][ny]  = y;

            }
        }
        return move;

    }

    private static class Attack implements Comparable<Attack>{
        int x,y,num,recent;
        public Attack(int x,int y,int num,int recent){
            this.x = x;
            this.y = y;
            this.num = num;
            this.recent = recent;
        }

        @Override
        public int compareTo(Attack o) {
            if(o.num==this.num) {
                if (o.recent == this.recent) {
                    if (o.x + o.y == this.x + this.y) {
                            return o.y - this.y;//열 내림차순
                    }return (o.x + o.y) - (this.x + this.y);//합 내림차순
                }return o.recent - this.recent;//최근 내림차순
            }return this.num-o.num;//공격력 오름차순
        }
    }
}
