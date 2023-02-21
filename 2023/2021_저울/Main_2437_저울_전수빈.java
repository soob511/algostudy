package greedy;

import java.io.*;
import java.util.*;

public class Main_2437_저울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i <n; i++) {
            if(sum+1<arr[i]){
                break;
            }
            sum+=arr[i];
        }
        System.out.println(sum+1);
    }
}
