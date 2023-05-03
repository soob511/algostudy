package greedy;

import java.io.*;
import java.util.*;

public class Main_1461_도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st= new StringTokenizer(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,Math.abs(0-arr[i]));

            if(arr[i]<0){
                arr[i] = Math.abs(0-arr[i]);
                minus.add(arr[i]);
            }else{
                plus.add(arr[i]);
            }
        }
        Arrays.sort(arr);

        Collections.sort(plus,Collections.reverseOrder());
        Collections.sort(minus,Collections.reverseOrder());
        int sum = 0;

            for (int i = 0; i <minus.size(); i++) {
                if(i==0&&minus.get(i)==max){
                    sum+=minus.get(i);
                }else if(i%m==0){
                    sum+=minus.get(i)*2;
                }
            }
            for (int i = 0; i <plus.size(); i++) {
                if(i==0&&plus.get(i)==max){
                    sum+=plus.get(i);
                }else if(i%m==0){
                    sum+=plus.get(i)*2;
                }
            }

        System.out.println(sum);

    }
}
