import java.util.*;
import java.io.*;

public class 코드트리_놀이기구탑승_정승우 {
    static int n;
    static int[][] map;
    static int[][] list;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        list = new int[n*n+1][4];
        for(int i=0; i<n*n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<4; j++) {
                list[num][j] = Integer.parseInt(st.nextToken());
            }
            Node node = calc_node(num);
            map[node.r][node.c] = num;
        }
        sol();
    }

    public static void sol() {
        int res= 0;
        int tmp = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int num = map[i][j];
                int[] like = list[num];
                for(int d=0; d<4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(0<=nr&&0<=nc&&nr<n&&nc<n) {
                        if (map[nr][nc] == like[0] || map[nr][nc] == like[1] || map[nr][nc] == like[2] || map[nr][nc] == like[3]){
                            tmp++;
                        }
                    }
                }
                if (tmp == 1) res += 1;
                else if (tmp == 2) res += 10;
                else if (tmp == 3) res += 100;
                else if (tmp == 4) res += 1000;
                tmp = 0;
            }
        }

        System.out.println(res);
    }


    public static Node calc_node(int number){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (map[r][c] == 0){

                    int likes = 0;
                    int empty = 0;
                    int[] like = list[number];
                    for(int d=0; d<4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (0<=nr&&0<=nc&&nr<n&&nc<n){
                            if (map[nr][nc] == like[0] || map[nr][nc] == like[1] || map[nr][nc] == like[2] || map[nr][nc] == like[3]){
                                likes++;
                            }
                            else if (map[nr][nc] == 0) empty++;
                        }
                    }

                    pq.add(new Node(r, c, likes, empty));
                }
            }
        }
        return pq.poll();
    }

    public static class Node implements Comparable<Node>{
        int r, c, likes, empty;

        public Node(int r, int c, int like, int empty) {
            this.r = r;
            this.c = c;
            this.likes = like;
            this.empty = empty;
        }

        @Override
        public int compareTo(Node o) {
            if (this.likes == o.likes){
                if (this.empty == o.empty){
                    if (this.r == o.r) return this.c - o.c;
                    else return this.r - o.r;
                }
                else return o.empty - this.empty;
            }
            else return o.likes - this.likes;
        }
    }
}