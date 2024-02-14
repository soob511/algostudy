import java.util.*;

class Solution {
    static int n,m;
    static int map[][];
    static boolean visited[][];
    static Queue<Pos> queue = new LinkedList<>();
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int sum;
    public int[] solution(String[] maps) {
        List<Integer> answer = new LinkedList<>();
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            char[] mapCharArray = maps[i].toCharArray();

            for(int j=0; j<m; j++) {

                if(mapCharArray[j]=='X') {
                    map[i][j] = -1;
                    continue;
                }
                map[i][j] = mapCharArray[j] - '0';
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==-1||visited[i][j]==true) {
                    continue;
                }
                visited[i][j] = true;
                queue.add(new Pos(i,j,map[i][j]));
                sum = 0;
                bfs();
                answer.add(sum);
            }
        }

        if(answer.size()==0) {

            return new int[] {-1};

        } else {

            Collections.sort(answer);
            int[] result = new int[answer.size()];

            for(int i=0; i<result.length; i++) {
                result[i] = answer.get(i);
            }

            return result;
        }

    }

    private static void bfs() {

        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int r = p.r;
            int c = p.c;
            int value = p.value;

            sum += value;

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0<=nr&&0<=nc&&nr<n&&nc<m&&!visited[nr][nc]&&map[nr][nc]!=-1) {
                    queue.add(new Pos(nr,nc,map[nr][nc]));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static class Pos {

        int r,c,value;

        Pos(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }
}