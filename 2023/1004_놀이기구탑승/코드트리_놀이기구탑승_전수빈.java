package 코드트리;

import java.io.*;
import java.util.*;

public class Main_놀이기구탑승 {
    static int n;
    static int[][] map,arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        arr = new int[n*n+1][4];
        for (int i = 0; i <n*n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j <4; j++) {
                arr[num][j] = Integer.parseInt(st.nextToken());
            }
            choose(num);
        }
        int sum = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                int like = 0;
                for (int d = 0; d <4; d++) {
                    int nx = i+dx[d];
                    int ny = j + dy[d];
                    if(nx<0||ny<0||nx>=n||ny>=n)continue;
                    for (int k = 0; k <4; k++) {
                        if(map[nx][ny]==arr[map[i][j]][k]){
                            like++;
                            break;
                        }
                    }
                }
                if(like!=0) {
                    sum += Math.pow(10,like-1);
                }
            }
        }
        System.out.println(sum);

    }

    private static void choose(int num) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                if(map[i][j]!=0)continue;
                int empty = 0;
                int like = 0;
                for (int d = 0; d <4; d++) {
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if(nx<0||ny<0||nx>=n||ny>=n)continue;
                    if(map[nx][ny]==0)empty++;
                    else {
                        for (int k = 0; k < 4; k++) {
                            if (map[nx][ny] == arr[num][k]){
                                like++;
                                break;
                            }
                        }
                    }
                }
                pq.add(new Seat(i,j,like,empty));
            }
        }
        Seat seat = pq.poll();
        map[seat.x][seat.y] = num;
    }

    private static class Seat implements Comparable<Seat>{
        int x;
        int y;
        int like;
        int empty;

        public Seat(int x,int y,int like, int empty){
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;
        }

        @Override
        public int compareTo(Seat o) {
            if(this.like==o.like){//친구수가 같으면
                if(this.empty==o.empty){
                    if(this.x==o.x){
                        return this.y-o.y;
                    }else return this.x - o.x;
                }else return o.empty-this.empty;
            }else return o.like - this.like;
        }
    }
}
