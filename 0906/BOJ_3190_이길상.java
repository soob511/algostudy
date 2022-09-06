import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int[] head = {0, 0};
    static int[] tail = {0, 0};
    static int dir = 0; // 동:0 남:1 서:2 북:3
    static int time = 0;

    static int[][] board;
    static int N;

    static void move() {
        time++;

        // 다음 머리 좌표
        head[0] += dx[dir];
        head[1] += dy[dir];

        // 벽이나 몸에 부딛힐 경우
        if (head[0]<0 || head[0]==N || head[1]<0 || head[1]==N || board[head[0]][head[1]]>0){
            System.out.println(time);
            System.exit(0);
        }

        // 빈칸일 경우 꼬리 이동
        if (board[head[0]][head[1]] == 0){
            int taildir = board[tail[0]][tail[1]] - 1;
            board[tail[0]][tail[1]] = 0;
            
            tail[0] += dx[taildir];
            tail[1] += dy[taildir];
        }
        
        // 머리 이동
        board[head[0]][head[1]] = dir + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 크기 입력
        N = Integer.parseInt(br.readLine());

        // 초기설정
        board = new int[N][N];
        board[0][0] = 1;

        // 사과 입력
        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            String[] line = br.readLine().split(" ");     
            int r = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);
            board[r-1][c-1] = -1;
        }

        // 방향전환 입력
        int L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            String[] line = br.readLine().split(" ");     
            int X = Integer.parseInt(line[0]);
            char C = line[1].charAt(0);

            // 이동
            for (int x = time; x < X; x++) {                
                move();
            }

            // 방향 전환
            if(C == 'L') dir = (dir+3)%4;
            if(C == 'D') dir = (dir+1)%4;
            board[head[0]][head[1]] = dir + 1;

        }

        // 이동
        while(true) {
            move();
        }
    }
}
