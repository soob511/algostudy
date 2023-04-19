import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1092_배_정승우2 {
    static int n,m;
    static int cnt = 0;
    //크레인
    static ArrayList<Integer> c = new ArrayList<>();
    //박스
    static ArrayList<Integer> b = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            c.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(c, Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(b, Collections.reverseOrder());


        if(c.get(0)<b.get(0)) {
            System.out.println(-1);
            return;
        }

        while(!b.isEmpty()) {
            cnt++;
//            for (int i = 0; i < c.size(); i++) {
//                for (int j = 0; j < b.size(); j++) {
//                    if (c.get(i) >= b.get(j)) {
//                        b.remove(j);
//                        break;
//                    }
//                }
//            }
            for(Integer crane : c) {
                for(int i=0; i<b.size(); i++) {
                    if(crane>=b.get(i)) {
                        b.remove(i);
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
