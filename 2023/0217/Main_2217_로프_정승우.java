import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217_로프_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long max = 0;

        for(int i= n-1; i>=0; i--) {
            arr[i] = arr[i] * (n-i);
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
