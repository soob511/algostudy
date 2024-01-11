import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Pos> q = new LinkedList<>();
    static boolean[][] check;
    static int rLen;
    static int cLen;
    public int solution(String[] board) {
        int answer = 0;
        rLen = board.length;
        cLen = board[0].length();
        check = new boolean[rLen][cLen];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                if(board[i].charAt(j) == 'R') {

                    q.offer(new Pos(i,j,0));
                    check[i][j] = true;
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

                while(0<=nr&&0<=nc&&nr<rLen&&nc<cLen&&board[nr].charAt(nc) != 'D') {
                    nr += dr[d];
                    nc += dc[d];
                }

                nr -= dr[d];
                nc -= dc[d];

                if(check[nr][nc] || (r == nr && c == nc)) continue;


                check[nr][nc] = true;
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