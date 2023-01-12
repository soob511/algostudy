import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N+2][N+2];

        for (int x = 1; x <= N; x++) {
            String line = br.readLine();

            for (int y = 1; y <= N; y++) {
                char info = line.charAt(y-1);

                if (info!='.'){
                    int mines = info - '0';
                    
                    addMine(map, x, y, mines);
                }
            }
        }

        buildString(N, map);

        System.out.println(sb);
    }

    private static void buildString(int N, int[][] map) {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                int i = map[x][y];
                if (i >= 100)       sb.append('*');
                else if (i >= 10)   sb.append('M');
                else                sb.append(i);
            }
            sb.append('\n');
        }
    }

    private static void addMine(int[][] map, int x, int y, int mines) {
        map[x][y] = 100;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                map[x+i][y+j] += mines;
            }
        }
    }
}
