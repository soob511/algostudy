import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드_정승우 {
    static int n,m;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if(i==j) continue;
                dist[i][j] = 1000000000;
            }
        }
        for(int t=0; t<m; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b],c);
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(dist[i][j] >= 1000000000) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
