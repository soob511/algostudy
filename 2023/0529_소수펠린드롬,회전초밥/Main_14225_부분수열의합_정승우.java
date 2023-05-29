import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_14225_부분수열의합_정승우 {
    static int n;
    static int[] arr;
    static boolean[] check;
    static ArrayList<Integer> arraylist = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        check = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Subset(0);
        Collections.sort(arraylist);
        boolean comp[] = new boolean[2000001];
        for(int i=0; i<arraylist.size(); i++) {
            comp[arraylist.get(i)] = true;
        }

        for(int i=1; i<comp.length; i++) {
            if(comp[i]==false) {
                System.out.println(i);
                break;
            }
        }

    }

    private static void Subset(int cnt) {
        if(cnt==n) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                if(check[i]) {
                    sum+= arr[i];
                }
            }
            arraylist.add(sum);
            return;
        }

        check[cnt] = true;
        Subset(cnt+1);
        check[cnt] = false;
        Subset(cnt+1);
    }
}
