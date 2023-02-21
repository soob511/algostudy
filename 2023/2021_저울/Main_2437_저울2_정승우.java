import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437_저울2_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

         if(arr[0]>1) {
            System.out.println(1);
            return;
        }

        int ans = arr[0];
        for(int i=1; i<n; i++) {
            if(ans+1<arr[i]) {
                ans+=1;
                break;
            }

            ans+= arr[i];

            if(i==n-1) {
                ans++;
            }

            System.out.println(ans);
        }

    }
}
