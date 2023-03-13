package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10775_공항 {
    static int[] docking;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        docking = new int[g+1];
        for (int i = 0; i <=g; i++) {
            docking[i] = i;
        }
        int count=0;
        while (p-->0){
            int n = Integer.parseInt(br.readLine());
            int gate = find(n);
            if(gate==0){
                break;
            }
            count++;
            union(gate,gate-1);
        }
        System.out.println(count);

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y){
            docking[x] = y;
        }
    }

    private static int find(int n) {
        if(n==docking[n]){
            return n;
        }
        return docking[n] = find(docking[n]);
    }
}
