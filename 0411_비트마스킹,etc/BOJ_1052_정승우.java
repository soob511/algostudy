package com.ssafy.day0411;

import java.util.Scanner;

public class BOJ_1052_정승우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        //상점에서 구매해야할 물병 개수
        int result = 0;



        while(true) {
        	//N값 2진수를 String형 binary변수에 저장
        	String binary = Integer.toBinaryString(N);
        	//1의 개수를 저장할 변수
        	int count = 0;
        	
        	for (int i=0; i<binary.length(); i++) {
        		if(binary.charAt(i)=='1') count++;
        		
        	}
        	
        	if(count <= K) {
        		System.out.println(result);
        		break;
        	}
        	//이동 불가로 상점에서 1개 구매후 다시 반복문 실행
        	N++;
        	result++;
        }
    
    }
}