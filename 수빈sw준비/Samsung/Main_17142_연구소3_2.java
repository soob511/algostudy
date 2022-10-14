package Samsung;

import java.io.*;
import java.util.*;

public class Main_17142_연구소3_2 {
    static int n,m;
    static int[][] map;
    static List<int[]> list = new ArrayList<>();
    static int empty;
    static int[][] select;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){//바이러스 좌표 리스트에 추가
                    list.add(new int[]{i,j});
                }else if(map[i][j]==0){//빈공간 카운트
                    empty++;
                }
            }
        }
        select = new int[m][2];
        per(0,0);


        System.out.println(min==Integer.MAX_VALUE ? -1 : min);


    }

    private static void per(int count, int idx) {
        if (count==m){
            bfs();
            return;
        }
        for(int i=idx;i<list.size();i++){
            select[count] = list.get(i);
            per(count+1,i+1);
        }

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];

        for(int i=0;i<m;i++){
            int x = select[i][0];
            int y = select[i][1];
            q.add(new int[]{x,y});
            visit[x][y] = true;
        }
        int time=0;
        int zero = empty;
        while (!q.isEmpty()){
            if(zero==0){
                break;
            }
            int size = q.size();
            time++;
            while (size-->0){

                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                for(int i=0;i<4;i++){
                    int nx = x+dx[i];
                    int ny = y +dy[i];

                    if(nx>=0&&ny>=0&&nx<n&&ny<n&&map[nx][ny]!=1&&!visit[nx][ny]) {
                        if (map[nx][ny] == 0) {
                            zero--;
                        }
                        q.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }

            }
        }

        if (zero==0){
            min = Math.min(min,time);
        }


    }
}
