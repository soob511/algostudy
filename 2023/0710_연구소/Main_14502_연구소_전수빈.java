package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_14502_연구소 {
    static int n,m;
    static int[][] map;
    static ArrayList<int[]> wall,virus;
    static boolean[] visit;
    static int cnt;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         map = new int[n][m];
         check = new boolean[n][m];
         wall = new ArrayList<>();
         virus = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    wall.add(new int[]{i,j});
                }else if(map[i][j]==2){
                    virus.add(new int[]{i,j});
                    cnt++;
                }else{
                    cnt++;
                }
            }
        }
        visit = new boolean[wall.size()];
        dfs(0,0);
        System.out.println((n*m)-result);

    }

    private static void dfs(int count, int idx) {
        if(count==3){
            Queue<int[]> q = new LinkedList<>();
            check = new boolean[n][m];
            int num = cnt+3;
            for (int i = 0; i <virus.size(); i++) {
                q.add(new int[]{virus.get(i)[0],virus.get(i)[1]});
                check[virus.get(i)[0]][virus.get(i)[1]] = true;
            }
            while (!q.isEmpty()){
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                for (int i = 0; i <4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]!=0||check[nx][ny])continue;
                    q.add(new int[]{nx,ny});
                    check[nx][ny] = true;
                    num++;
                }
            }
            result = Math.min(num,result);
            return;
        }

        for(int i=idx;i<wall.size();i++){
            if(!visit[i]){
                visit[i] = true;
                map[wall.get(i)[0]][wall.get(i)[1]]=1;
                dfs(count+1,i+1);
                visit[i] = false;
                map[wall.get(i)[0]][wall.get(i)[1]]=0;
            }
        }
    }
}
