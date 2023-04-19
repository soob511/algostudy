package greedy;

import java.io.*;
import java.util.*;

public class Main_1092_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        int time = 0;
        if (box.get(0) > crane.get(0)) {
            time = -1;
        }else{
            while (!box.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < n;) {
                    if (idx == box.size()) break;
                    else if (crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    } else idx++;
                }
                time++;
            }
        }

        System.out.println(time);
    }
}
