import java.util.*;
class Solution {
    static boolean[][] visit;
    static int answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    public int solution(int[][] land) {
        int result = 0;
         n = land.length;
         m = land[0].length;
        for(int i=0;i<m;i++){
            visit = new boolean[n][m];
            answer =0;
            for(int j=0;j<n;j++){
                if(land[j][i]==1&&!visit[j][i]){
                    bfs(j,i,land);
                }
            }
            result = Math.max(result,answer);
        }
        //System.out.println(n + " "+ m);
        return result;
    }
    static void bfs(int a, int b,int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        visit[a][b] = true;
        answer++;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for(int d=0;d<4;d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx<0||nx>=n||ny<0||ny>=m||land[nx][ny]==0||visit[nx][ny])continue;
                q.add(new int[]{nx,ny});
                visit[nx][ny] = true;
                answer++;
            }
        }
    }
}