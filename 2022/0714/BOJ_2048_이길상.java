import java.util.*;
import java.io.*;

public class Main{

    static int N, block = 0;
    static int[][][] board;

    // 상하좌우로 이동
    static void moveLeft(int[][] prev, int[][] next){
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                next[i][j] = 0;

        for (int i = 0; i < N; i++) {
            int p = 0;
            int val = 0;
            for (int j = 0; j < N; j++) {
                if(prev[i][j] == 0) continue;
                if(prev[i][j] == val){
                    next[i][p++] = val*2;
                    val = 0;
                }
                else if(val == 0){
                    val = prev[i][j];
                }
                else{
                    next[i][p++] = val;
                    val = prev[i][j];
                }
            }
            next[i][p] = val;
        }
    }


    static void moveRight(int[][] prev, int[][] next){
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                next[i][j] = 0;

        for (int i = 0; i < N; i++) {
            int p = N-1;
            int val = 0;
            for (int j = N-1; j > -1; j--) {
                if(prev[i][j] == 0) continue;
                if(prev[i][j] == val){
                    next[i][p--] = val*2;
                    val = 0;
                }
                else if(val == 0){
                    val = prev[i][j];
                }
                else{
                    next[i][p--] = val;
                    val = prev[i][j];
                }
            }
            next[i][p] = val;
        }
    }

    static void moveUp(int[][] prev, int[][] next){
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                next[i][j] = 0;

        for (int i = 0; i < N; i++) {
            int p = 0;
            int val = 0;
            for (int j = 0; j < N; j++) {
                if(prev[j][i] == 0) continue;
                if(prev[j][i] == val){
                    next[p++][i] = val*2;
                    val = 0;
                }
                else if(val == 0){
                    val = prev[j][i];
                }
                else{
                    next[p++][i] = val;
                    val = prev[j][i];
                }
            }
            next[p][i] = val;
        }
    }


    static void moveDown(int[][] prev, int[][] next){
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                next[i][j] = 0;

        for (int i = 0; i < N; i++) {
            int p = N-1;
            int val = 0;
            for (int j = N-1; j > -1; j--) {
                if(prev[j][i] == 0) continue;
                if(prev[j][i] == val){
                    next[p--][i] = val*2;
                    val = 0;
                }
                else if(val == 0){
                    val = prev[j][i];
                }
                else{
                    next[p--][i] = val;
                    val = prev[j][i];
                }
            }
            next[p][i] = val;
        }
    }

    // 백트래킹 경우의 수 탐색
    static void move(int i){
        if (i == 5) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    block = Math.max(block, board[5][x][y]);
                }
            }

            return;
        }

        moveDown(board[i], board[i+1]);
        move(i+1);

        moveLeft(board[i], board[i+1]);
        move(i+1);
        
        moveUp(board[i], board[i+1]);
        move(i+1);

        moveRight(board[i], board[i+1]);
        move(i+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 단계별 2차원 배열 공간 확보
        board = new int[6][N][N];

        // 보드 입력
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[0][i][j] = Integer.parseInt(line[j]);
            }
        }

        // 완전 탐색
        move(0);

        System.out.println(block);

    }
}
