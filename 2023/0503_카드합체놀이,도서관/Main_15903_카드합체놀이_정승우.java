import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15903_카드합체놀이_정승우 {
    static int n,m;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            Arrays.sort(arr);
            arr[0] = arr[0] + arr[1];
            arr[1] = arr[0];
        }
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
