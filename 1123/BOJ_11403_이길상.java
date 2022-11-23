import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] adj = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int x = 0; x < N; x++) {
                if (i==x) continue;
                for (int y = 0; y < N; y++) {
                    if (i==y) continue;
                    if (adj[x][y]==0 && adj[x][i]==1 && adj[i][y]==1)
                        adj[x][y] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(adj[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
