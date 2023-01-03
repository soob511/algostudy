import java.io.*;

public class BOJ_1103_이길상 {
    static char[][] board;
    static int[][] movable;
    static boolean [][] visited;

    static int N, M;

    // x, y 지점에서 최대 이동가능한 횟수
    static int game(int x, int y){
        // 갈 수 없는 곳
        if(x<0 || y<0 || x>=N || y>=M || board[x][y] == 'H'){
            return 0;
        } 

        // 사이클
        if(visited[x][y]) return N*M+1;

        // 다른 분기에서 최대 이동 횟수를 계산해둔 곳
        if(movable[x][y] >0) return movable[x][y];

        // 4방향의 최대 이동 횟수 구하기
        int d = board[x][y] - '0';

        visited[x][y] = true;
        int down = game(x+d, y);
        int up = game(x-d, y);
        int right = game(x, y+d);
        int left = game(x, y-d);
        visited[x][y] = false;

        // 현 지점의 최대 이동 횟수 저장
        movable[x][y] = Math.max(Math.max(up, down), Math.max(right, left)) + 1;
        return movable[x][y];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 보드 크기 입력
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        // 보드 입력
        board = new char[N][];
        for (int n = 0; n < N; n++) {
            board[n] = br.readLine().toCharArray();
        }

        // DFS
        visited = new boolean[N][M];
        movable = new int[N][M];

        int result = game(0, 0);
        System.out.println(result>N*M ? -1:result);
    }
}