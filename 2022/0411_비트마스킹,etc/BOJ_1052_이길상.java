import java.io.*;
import java.util.*;

public class BOJ_1052_이길상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        // 현재 2진수 묶음이 몇개 나오는가
        int count = 0, bit = 1;
        while(bit <= N){
            if((bit&N) > 0) count++;
            bit <<= 1;
        }

        // 물병을 더 살 필요가 없는 경우
        if(count <= K){
            System.out.println(0);
        }
        // 초과분 합치기
        else{
            
            int sum = 0, over = count-K;
            count = 0;
            bit = 1;

            // 초과 비트 합산
            while(count < over){
                if((bit&N) > 0){
                    count++;
                    sum += bit;
                }
                bit <<= 1;
            }

            // 묶음 중 가장 작은 것 구하기
            while((bit&N) == 0) bit<<=1;
            System.out.println(bit - sum);
        }
        
    }
}
