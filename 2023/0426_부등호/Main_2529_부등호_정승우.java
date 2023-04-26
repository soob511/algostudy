import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2529_부등호_정승우 {
    static int n;
    static char[] arr;
    static boolean[] checked = new boolean[10];
    static List<String> number = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str = br.readLine().replaceAll(" ", "");
        arr = new char[n];
        for(int i=0; i<n; i++) {
            arr[i] = str.charAt(i);
        }

        for(int i=0; i<=9; i++) {
            checked[i] = true;
            dfs(i, 0, i+"");
        }

        System.out.println(number.get(number.size()-1));
        System.out.println(number.get(0));
    }

    private static void dfs(int num, int idx, String s) {
        if(idx==n) {
            number.add(s);
        } else {
            for(int i=0; i<=9; i++) {
                if(checked[i]==false) {
                    if(arr[idx]=='<') {
                        if(num>=i) {
                            continue;
                        }
                    } else {
                        if(num<=i) {
                            continue;
                        }
                    }
                    checked[i] = true;
                    dfs(i, idx+1, s+i);

                }
            }
        }
        checked[num] = false;
    }

}
