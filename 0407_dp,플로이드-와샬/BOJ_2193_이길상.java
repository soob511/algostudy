import java.io.*;
import java.util.*;

public class BOJ_2193_이길상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long on_true = 1, on_false = 0;
        boolean on = false;
        while(N-->0){
            on ^= true;
            if(on) on_true += on_false;
            else on_false += on_true;
        }

        System.out.println(on ? on_true : on_false);


        // long ends_with_zero = 0, ends_with_one = 1;

        // for (int i = 1; i < N; i++) {
        //     long temp = ends_with_one + ends_with_zero;
        //     ends_with_one = ends_with_zero;
        //     ends_with_zero = temp;
        // }

        // System.out.println(ends_with_one + ends_with_zero);
    }
}
