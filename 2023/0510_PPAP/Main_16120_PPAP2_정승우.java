import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16120_PPAP2_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        int cnt = 0;

        for(int i=0; i<sb.length(); i++) {
            if(sb.charAt(i)=='P') cnt++;
            else {
                if(cnt >=2 && sb.length() > i+1 && sb.charAt(i+1) == 'P') {
                    cnt--;
                    i++;
                } else {
                    cnt = 0;
                    break;
                }
            }
        };

        if(cnt==1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }


    }
}
