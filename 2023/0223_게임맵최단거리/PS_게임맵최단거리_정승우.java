//import java.util.*;
//class Solution {
//    static int[] dr = {0,1,0,-1};
//    static int[] dc = {-1,0,1,0};
//    static boolean[][] check;
//    static class pos {
//        int r,c, cnt;
//
//        pos(int r, int c, int cnt) {
//            this.r = r;
//            this.c = c;
//            this.cnt = cnt;
//        }
//    }
//    public int solution(int[][] maps) {
//
//        int n = maps.length;
//        int m = maps[0].length;
//        check = new boolean[n][m];
//
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<m; j++) {
//                if(maps[i][j]==0) {
//                    check[i][j] = true;
//                }
//            }
//        }
//
//        Queue<pos> q = new LinkedList<>();
//        check[0][0] = true;
//        q.offer(new pos(0,0,1));
//        int min = Integer.MAX_VALUE;
//        while(!q.isEmpty()) {
//            pos p = q.poll();
//            int r = p.r;
//            int c = p.c;
//            int cnt = p.cnt;
//            for(int d=0; d<4; d++) {
//                int nr = r+dr[d];
//                int nc = c+dc[d];
//                if(0<=nr&&0<=nc&&nr<n&&nc<m&&!check[nr][nc]) {
//                    check[nr][nc] = true;
//                    q.offer(new pos(nr, nc, cnt+1));
//                    if(nr == n-1 && nc == m-1) {
//                        min = Math.min(min, cnt + 1);
//                    }
//                }
//
//            }
//        }
//
//
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }
//}