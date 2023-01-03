import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            boolean[] check = new boolean[26];
            boolean tmp = true;

            for(int j=0; j<str.length(); j++) {
                int idx = str.charAt(j) - 'a';
                if(check[idx]) {
                    if(str.charAt(j) != str.charAt(j-1)) {
                        tmp = false;
                        break;
                    }
                } else {
                    check[idx] = true;
                }
            }
            if(tmp) cnt++;
        }
        System.out.println(cnt);

    }
}
