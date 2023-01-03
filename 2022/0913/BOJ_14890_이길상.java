import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int answer = 2*N;
        for (int i = 0; i < N; i++) {
            int count_row = 1;
            for (int j = 1; j < N; j++) {
                if (map[i][j] == map[i][j-1]){
                    count_row++;
                    continue;
                }
                if (map[i][j] == map[i][j-1]-1 && count_row >= 0){
                    count_row = -L + 1;
                    continue;
                }
                if (map[i][j] == map[i][j-1]+1 && count_row >= L){
                    count_row = 1;
                    continue;
                }
                
                count_row = 0;
                answer--;
                break;
            }
            if (count_row<0) answer--;
            
            int count_col = 1;
            for (int j = 1; j < N; j++) {
                if (map[j][i] == map[j-1][i]){
                    count_col++;
                    continue;
                }
                if (map[j][i] == map[j-1][i]-1 && count_col >= 0){
                    count_col = -L + 1;
                    continue;
                }
                if (map[j][i] == map[j-1][i]+1 && count_col >= L){
                    count_col = 1;
                    continue;
                }
                
                count_col = 0;
                answer--;
                break;
            }
            if (count_col<0) answer--;
        }
        System.out.println(answer);
    }
}
