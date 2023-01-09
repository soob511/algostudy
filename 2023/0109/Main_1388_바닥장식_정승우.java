import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1388_바닥장식_정승우 {

    public static class Node {
        int x,y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N,M;
    static char[][] map;
    static boolean[][] checked;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        checked = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }

        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(checked[i][j] == false) {
                    if(map[i][j] == '-') {
                        check = true;
                        BFS(i,j);
                        ans++;
                    } else {
                        check = false;
                        BFS(i, j);
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void BFS(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i,j));
        checked[i][j] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int nX, nY;
            if(check == true) {
                nX = x;
                nY = y + 1;
                if(nY < 0 || nY >= M || checked[nX][nY]==true || map[nX][nY]=='|') {
                    continue;
                }
                q.add(new Node(nX, nY));
                checked[nX][nY] = true;
            } else {
                nX = x + 1;
                nY = y;
                if(nX < 0 || nX >= N || checked[nX][nY]==true || map[nX][nY]=='-') {
                    continue;
                }
                q.offer(new Node(nX, nY));
                checked[nX][nY] = true;
            }
        }
    }
}
