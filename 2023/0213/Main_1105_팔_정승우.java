import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1105_팔_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        String L = st.nextToken();
        String R = st.nextToken();
        if(L.length() == R.length()) {
            if(L.charAt(0)==R.charAt(0)) {
                int answer = 0;
                for(int i=0; i<L.length(); i++) {
                    if(L.charAt(i)==R.charAt(i)) {
                        if(L.charAt(i)=='8') answer++;
                    }
                    else break;
                }
                str.append(answer);
            }
            else str.append(0);

        }
        else str.append(0);

        System.out.println(str.toString());

    }
}
