import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1956_운동_정승우 {
    static int v,e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[v+1][e+1];

        for(int i=1; i<=v; i++) {
            for(int j=1; j<=v; j++) {
                if(i!=j) {
                    arr[i][j] = 10000000;
                }
            }
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }
        for(int k=1; k<=v; k++) {
            for(int i=1; i<=v; i++) {
                for(int j=1; j<=v; j++) {
                    if(i==j) {
                        continue;
                    }
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int res = 10000000;
        for(int i=1; i<=v; i++) {
            for(int j=1; j<=v; j++) {
                if(i==j) {
                    continue;
                }
                if (arr[i][j] != 10000000 && arr[j][i] != 10000000) {
                    res = Math.min(res, arr[i][j] + arr[j][i]);
                }
            }
        }
        if(res==10000000) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }


    }
}
