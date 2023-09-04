package 삼성하반기준비;

import java.io.*;
import java.util.*;
public class Main_23288_주사위굴리기2 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] dice = {{0,2,0},{4,1,3},{0,5,0},{0,6,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum =0;
        int d = 0;
        int r = 0;
        int c = 0;
        while (k-->0){
            //주사위 굴리기
            int nr = r+dx[d];
            int nc = c +dy[d];
            if(nr<0||nc<0||nr>=n||nc>=m){//범위벗어나면 반대로
                d  = (d+2)%4;
                nr  = r+dx[d];
                nc = c+dy[d];
            }
            r = nr;
            c = nc;

            if(d==0){//동
                int temp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = temp;
            }else if(d==1){//남
                int temp = dice[3][1];
                for (int i = 3; i >=1; i--) {
                    dice[i][1] = dice[i-1][1];
                }
                dice[0][1] = temp;
            }else if(d==2){//서
                int temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
            }else{//북
                int temp = dice[0][1];
                for(int i=0; i<3; i++) dice[i][1] = dice[i+1][1];
                dice[3][1] = temp;
            }
            //점수획득
            boolean[][] visit = new boolean[n][m];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{r,c});
            visit[r][c] = true;
            int count = 1;
            while (!q.isEmpty()){
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                for (int i = 0; i <4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]!=map[r][c]||visit[nx][ny])continue;
                    count++;
                    q.add(new int[]{nx,ny});
                    visit[nx][ny] = true;
                }
            }
            //점수 더하기
            sum += count*map[r][c];

            //주사위바닥비교
            if(dice[3][1]>map[r][c]){//주사위수가 크면 시계방향
                d  = (d+1)%4;
            }else if(dice[3][1]<map[r][c]){//주사위수가 작으면 반시계
                d = d-1;
                if(d==-1){
                    d = 3;
                }
            }
        }
        System.out.println(sum);
    }
}
