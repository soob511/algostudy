package A;

import sun.awt.EventQueueItem;

import java.io.*;
import java.util.*;


public class Main_14500_테크로미노 {
    static int max = 0;
    static int n,m;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         map = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int[] b:map ) System.out.println(Arrays.toString(b));
//        System.out.println();

        //탐색
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    visit[i][j] = true;
                    tetris(i,j,map[i][j],1);
                    visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void tetris(int x, int y, int sum, int count) {

        if(count==4){//테트로미노 완성시 합계
            max = Math.max(max,sum);//최댓값 비교

            return;
        }

        for(int i=0;i<4;i++){

            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=n||ny<0||ny>=m){
                continue;
            }
            if(!visit[nx][ny]){

                if(count==2){
                    visit[nx][ny]=true;
                    tetris(x,y,sum+map[nx][ny],count+1);
                    visit[nx][ny] = false;
                }

                visit[nx][ny]= true;
                tetris(nx,ny,sum+map[nx][ny],count+1);
                visit[nx][ny]=false;



            }


        }
    }
}
