import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        // 데이터 선언
        int[] BOARD = new int[101];
        Arrays.fill(BOARD, -1);
        Map<Integer, Integer> LADDER = new HashMap<>();
        Map<Integer, Integer> SNAKE = new HashMap<>();
        
        // N, M 입력
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        
        // 사다리 입력
        for (int n = 0; n < N; n++) {
            line = br.readLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);
            
            LADDER.put(X, Y);
        }
        // 뱀 입력
        for (int m = 0; m < M; m++) {
            line = br.readLine().split(" ");
            int U = Integer.parseInt(line[0]);
            int V = Integer.parseInt(line[1]);
            
            SNAKE.put(U, V);
        }

        // BFS 응용
        BOARD[1] = 0;
        Queue<Integer> POINTS = new LinkedList<>();
        POINTS.add(1);
        while (!POINTS.isEmpty()){
            int p = POINTS.poll();
            for (int move = 1; move < 7; move++) {
                int target = p + move;
                if (target > 100) continue;
                if (SNAKE.containsKey(target)) target = SNAKE.get(target);
                if (LADDER.containsKey(target)) target = LADDER.get(target);
                if (BOARD[target] < 0 || BOARD[target] > BOARD[p]+1){
                    BOARD[target] = BOARD[p]+1;
                    POINTS.add(target);
                }
            }
        }

        System.out.println(BOARD[100]);
    }
}
