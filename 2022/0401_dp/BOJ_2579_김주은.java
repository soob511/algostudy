package com.ssafy.add.d0405;

import java.io.*;
import java.util.*;

public class Main_BJ_2579_계단오르기_김주은 {
	
	public static void main(String args[]) throws Exception{
	      
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] stairs = new int[N+2];
        for(int i=2;i<N+2;i++){
            stairs[i]=sc.nextInt();
        }
        int[] DP = new int[N+2];
        
        for(int i=2;i<=N+1;i++){
            int max = Integer.MIN_VALUE;

            if(i-2>=0){
                max = Math.max(max, DP[i-2]+stairs[i]);
            }
            if(i-3>=0){ 
                max = Math.max(max, DP[i-3]+stairs[i-1]+stairs[i]);
            }
            
            DP[i] = max;
        }
        
        System.out.println(DP[N+1]);
    }
}
