import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1038_감소하는수_정승우 {
    static int N;
    static ArrayList<Long> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        if(N>=1023) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                dec(i, 1);
            }
            Collections.sort(arr);

            System.out.println(arr.get(N));
        }
    }

    private static void dec(long num, int cnt) {
        if(cnt > 10) {
            return;
        }
        arr.add(num);

        for(int i=0; i<10; i++) {
            if(num % 10 > i) {
                dec((num * 10) + i, cnt+1);
            }
        }
        return;

    }
}
