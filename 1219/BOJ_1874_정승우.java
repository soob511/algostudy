import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;

        for(int i=0; i<n; i++) {
            int v = Integer.parseInt(br.readLine());

            if(v > last) {
                for (int j = last + 1; j <= v; j++) {
                    s.push(j);
                    sb.append("+").append("\n");

                }
                last = v;
            } else {
                if (s.peek() != v) {
                    System.out.println("NO");
                    return;
                }
            }
            s.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);

    }
}
