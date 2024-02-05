import java.util.*;
class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static Queue<Pos> q = new LinkedList<>();
    static int rL;
    static int cL;
    static boolean[][] visited;
    public int solution(String[] board) {
        rL = board.length;
        cL = board[0].length();
        visited = new boolean[rL][cL];
        int answer = 0;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                if(board[i].charAt(j) == 'R') {

                    q.offer(new Pos(i,j,0));
                    visited[i][j] = true;
                    answer = bfs(board);
                }
            }
        }

        return answer;
    }

    int bfs(String[] board) {

        while(!q.isEmpty()) {
            Pos p = q.poll();
            int r = p.r;
            int c = p.c;
            int dep = p.dep;
            if(board[r].charAt(c) == 'G') {

                return dep;
            }

            for(int d=0; d<4; d++) {
                int nr = r;
                int nc = c;

                while(0<=nr&&0<=nc&&nr<rL&&nc<cL&&board[nr].charAt(nc) != 'D') {
                    nr += dr[d];
                    nc += dc[d];
                }

                nr -= dr[d];
                nc -= dc[d];

                if(visited[nr][nc] || (r == nr && c == nc)) continue;


                visited[nr][nc] = true;
                q.offer(new Pos(nr, nc, dep+1));
            }

        }

        return -1;
    }

    class Pos {

        int r;
        int c;
        int dep;

        Pos (int r, int c, int dep) {
            this.r = r;
            this.c = c;
            this.dep = dep;
        }
    }
}