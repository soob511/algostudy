package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_19237_어른상어 {
    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken()); //상어수
        int k = Integer.parseInt(st.nextToken()); //냄새시간

        int[][] smell = new int[n][n];//냄새시간
        int[][] num = new int[n][n];//상어번호
        int[][][] dir = new int[m+1][4][4];//우선순위
        Shark[] shark = new Shark[m+1];

        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                int s = Integer.parseInt(st.nextToken());
                if(s>0){
                    shark[s] = new Shark(i,j,0);
                    smell[i][j] = k;
                    num[i][j] = s;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=m ; i++) {
            shark[i].d = Integer.parseInt(st.nextToken())-1;
        }

        for (int s = 1; s <=m; s++) {
            for (int i = 0; i <4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <4; j++) {
                    dir[s][i][j] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }
        int time = 0;
        while (true){
            int count=0;
            for (int i = 1; i <=m; i++) {
                if(shark[i]!=null){
                    count++;
                }
            }
            if(count==1){//상어1번만 남으면
                System.out.println(time);
                break;
            }
            if(time==1000){
                System.out.println("-1");
                break;
            }
            int[][] map = new int[n][n];//이동
            boolean flag = false;
            int nx = 0;
            int ny = 0;
            int d = 0;
            for (int i = 1; i <=m; i++) { //상어이동
                if(shark[i]!=null){//상어가 있다면
                    for (int j=0;j<4;j++) {
                        d = dir[i][shark[i].d][j];
                        nx = shark[i].x + dx[d];
                        ny = shark[i].y + dy[d];
                        if ((nx>=0&&ny>=0&&nx<n&&ny<n)&&num[nx][ny] == 0) {//냄새없는빈칸
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){//냄새가 없는곳이 없으면
                        for (int j=0;j<4;j++) {
                            d = dir[i][shark[i].d][j];
                            nx = shark[i].x + dx[d];
                            ny = shark[i].y + dy[d];
                            if ((nx>=0&&ny>=0&&nx<n&&ny<n)&&num[nx][ny] == i) {//같은상어의냄새가있는칸
                                break;
                            }
                        }
                    }
                    if(map[nx][ny]==0){//상어번호가높은상어만 이동
                        map[nx][ny] = i;
                        shark[i].x = nx;
                        shark[i].y = ny;
                        shark[i].d = d;
                    }else{
                        shark[i] = null;
                    }
                }
            }

            //냄새 줄이기
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    if(smell[i][j]>0){
                        smell[i][j]--;
                        if(smell[i][j]==0){
                            num[i][j]=0;
                        }
                    }
                }
            }
            //냄새뿌리기
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    if(map[i][j]>0){
                        num[i][j] = map[i][j];
                        smell[i][j] = k;
                    }
                }
            }
            time++;
            //for(int[] b:num) System.out.println(Arrays.toString(b));System.out.println();
            //for(int[] b:smell) System.out.println(Arrays.toString(b));System.out.println();

        }


    }

    private static class Shark {
        int x,y,d;
        public Shark(int x,int y,int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
