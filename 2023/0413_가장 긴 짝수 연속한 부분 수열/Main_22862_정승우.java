import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22862_가장긴짝수연속한부분수열_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int res = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int lt = 0, rt = 0, tk = 0, tmp = 0;

        if(arr[0]%2 == 1) {
            tk = 1;
        } else {
            tk = 0;
        }

        if(arr[0]%2 == 0) {
            tmp = 1;
        } else {
            tmp = 0;
        }
        res = tmp;

        while(true) {

            if(tk > k) {
                if(arr[lt++] % 2 ==0) {
                    tmp--;
                } else {
                    tk--;
                }
            } else {
                rt++;
                if(rt >= arr.length) break;

                if(arr[rt] % 2 == 0) {
                    tmp++;
                    if(tmp > res) {
                        res = tmp;
                    }

                } else {
                    tk++;
                }
            }
        }
        System.out.println(res);




    }
}
