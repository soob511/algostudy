import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10974_모든순열_정승우 {
    static int n;
    static int[] ans, arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));

        ans = new int[n];
        check = new boolean[n];
        permutation(0);

    }

    private static void permutation(int cnt) {
        if(cnt==n) {
            for(int i=0; i<n; i++) {
                System.out.print(ans[i]+" ");

            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++) {
            if(check[i]) {
                continue;
            }
            check[i] = true;
            ans[cnt] = arr[i];
            permutation(cnt+1);
            check[i] = false;
        }
    }
}
