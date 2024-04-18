import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_4195_친구네트워크_정승우 {
    private static int T;
    private static int F;
    private static int[] parent;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            F = Integer.parseInt(br.readLine());
            parent = new int[F * 2];
            count = new int[F * 2];

            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
            }
            for(int i=0; i<count.length; i++) {
                count[i] = 1;
            }

            HashMap<String, Integer> map = new HashMap<>();
            int idx = 0;
            for (int f = 0; f < F; f++) {
                st = new StringTokenizer(br.readLine(), " ");
                String human1 = st.nextToken();
                String human2 = st.nextToken();
                if (!map.containsKey(human1)) {
                    map.put(human1, idx++);
                }
                if (!map.containsKey(human2)) {
                    map.put(human2, idx++);
                }
                System.out.println(union(map.get(human1), map.get(human2)));
            }
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                parent[b] = a; 
                count[a] += count[b];
                return count[a];
            } else {
                parent[a] = b;
                count[b] += count[a];
                return count[b];
            }
        }
        return count[a];
    }
}
