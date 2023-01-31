package greedy;

import java.io.*;
import java.util.*;

public class Main_13904_과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] hw = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            hw[i][0] = Integer.parseInt(st.nextToken());
            hw[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hw, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1],o1[1]);
            }
        });

        int[] sum = new int[1001];

        for(int i=0;i<n;i++){
            for (int j = hw[i][0]; j >0; j--) {
                if(sum[j]==0){
                    sum[j] = hw[i][1];
                    break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i <1001; i++) {
            max+=sum[i];
        }
        System.out.println(max);
    }
}
