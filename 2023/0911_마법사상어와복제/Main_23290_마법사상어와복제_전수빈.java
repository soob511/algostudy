package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_23290_마법사상어와복제 {
    static int sx,sy;
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1};//좌 좌상 상 우상 우 우하 하 좌하
    static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    static int[] sdx = {-1,0,1,0};//상좌하우
    static int[] sdy = {0,-1,0,1};
    static int[] select;
    static int[] result;
    static int max;
    static Queue<Integer>[][] fish;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        fish = new LinkedList[4][4];
        Queue<Integer>[][] move = new LinkedList[4][4];
        int[][] shark = new int[4][4];
        int[][] smell = new int[4][4];

        for (int i = 0; i <4; i++) {
            for (int j = 0; j <4; j++) {
                fish[i][j] = new LinkedList<>();
            }
        }

        for (int k = 0; k <m; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            fish[x][y].add(d);
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken())-1;
        sy = Integer.parseInt(st.nextToken())-1;
        shark[sx][sy] = 1;

        while (s-->0){

            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i <4; i++) {
                for (int j = 0; j <4; j++) {
                    move[i][j] = new LinkedList<>();
                }
            }
            //2. 물고기이동
            for (int x = 0; x <4; x++) {
                for (int y = 0; y <4; y++) {
                    if(fish[x][y].size()>0){
                       while (!fish[x][y].isEmpty()){
                           int d =  fish[x][y].poll();
                           q.add(new int[]{x,y,d});//1. 물고기복제
                           while (true){
                               int nx = x+dx[d];
                               int ny = y+dy[d];
                               if((nx>=0&&ny>=0&&nx<4&&ny<4)&&smell[nx][ny]==0&&shark[nx][ny]==0){//범위안, 냄새없고, 상어없고
                                   move[nx][ny].add(d);
                                  break;
                               }else {
                                   d = d-1;
                                   if(d==0)d=8;
                               }
                           }
                       }
                    }
                }
            }

            fish = move;

            //3-1.상어진행방향 뽑기
            max = Integer.MIN_VALUE;
            result = new int[3];
            select = new int[3];
            per(0);


            //3-2.상어 이동
            shark[sx][sy] = 0;
            for (int i = 0; i <3; i++) {
                sx += sdx[result[i]];
                sy += sdy[result[i]];
                if(fish[sx][sy].size()>0){
                    fish[sx][sy].clear();
                    smell[sx][sy]=3;
                }
            }
            shark[sx][sy] = 1;

            //4.냄새 사라짐
            for (int i = 0; i <4; i++) {
                for (int j = 0; j <4; j++) {
                    if(smell[i][j]>0){
                        smell[i][j]--;
                    }
                }
            }
            //5.복제
            while (!q.isEmpty()){
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                int d = p[2];
                fish[x][y].add(d);
            }

        }

        //남은물고기수
        int answer = 0;
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <4; j++) {
                if(fish[i][j].size()>0){
                    answer += fish[i][j].size();
                }
            }
        }
        System.out.println(answer);

    }

    private static void per(int count) {
        if(count==3){
            int cnt  = eat();
            if(cnt==-1)return;//못가는지역
            if(max<cnt){
                max = cnt;
                for (int i = 0; i <3; i++) {
                    result[i] = select[i];
                }
            }
            return;
        }
        for (int i = 0; i <4; i++) {
            select[count] = i;
            per(count+1);
        }
    }

    private static int eat() {
        boolean[][] visit = new boolean[4][4];
        int num = 0;
        int nx = sx;
        int ny = sy;
        for (int i = 0; i <3; i++) {
             nx += sdx[select[i]];
             ny += sdy[select[i]];
            if(nx<0||ny<0||nx>=4||ny>=4){
               return -1;
            }
            if(visit[nx][ny])continue;//이미 방문했으면 물고기수x
            num+=fish[nx][ny].size();
            visit[nx][ny] = true;
        }
        return num;

    }


}
