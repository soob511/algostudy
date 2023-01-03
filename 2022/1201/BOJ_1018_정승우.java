
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_정승우 {

    static boolean[][] check;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        check= new boolean[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                char ch = str.charAt(j);
                if (ch=='W') {
                    check[i][j] = true;
                } else {
                    check[i][j] = false;
                }
            }
        }

        int N_start = N - 7;
        int M_start = M - 7;
        for(int i=0; i<N_start; i++) {
            for (int j=0; j<M_start; j++) {
                find(i,j);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        int i_end = x+8;
        int j_end = y+8;
        int count = 0;

        boolean checking = check[x][y];
        for (int i=x; i<i_end; i++) {
            for (int j=y; j<j_end; j++) {
                if(check[i][j] != checking) {
                    count++;
                }
                checking = !checking;
            }
            checking = !checking;
        }
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}
