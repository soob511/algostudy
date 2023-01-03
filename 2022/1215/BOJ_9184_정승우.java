import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184_정승우 {

    static int [][][]visited;


    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        else if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        else if (visited[a][b][c] == 0 && (a < b && b < c)) {
            visited[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return visited[a][b][c];
        }

        else if (visited[a][b][c] == 0) {
            visited[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            return visited[a][b][c];
        }

        return visited[a][b][c];


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        visited = new int [50][50][50];
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==-1&&b==-1&&c==-1) {
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c)).append("\n");
        }
        System.out.print(sb);
    }
}
