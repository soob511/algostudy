package com.ssafy.day0301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_정승우 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][6];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int a = 0; a < 6; a++) {
        	//updown으로 사용중인 숫자는 사용 안하기 위해 체크하는 boolean배열
            boolean[][] check = new boolean[N][6];
            //합계
            int sum = 0;
            //아래
            int down = a;
            
            int up = 0;
            for (int i = 0; i < N; i++) {
            	//주사위 윗면 아랫면 짝찌어줌
                switch(down) {
                case 0 : up=5;
                	break;
                case 1 : up=3;
            		break;
                case 2 : up=4;
            		break;
                case 3 : up=1;
            		break;
                case 4 : up=2;
            		break;
                case 5 : up=0;
            		break;
                } 
                //짝지어준 값 true
                //위아래로 사용중인 값은 제외하기 위해 true로 체크
                check[i][down] = true;
                check[i][up] = true;
                int tmp = 0;
                
                //true가 아닌 arr[i][j]의 값이 tmp보다 크다면 tmp에 저장(가장 큰 값 찾기)
                for (int j = 0; j < 6; j++) {
                    if (!check[i][j])
                        tmp = Math.max(tmp, arr[i][j]);
                }
                sum += tmp;
                //i값이 4가 아닌동안(arr[i+1][j]와 arr[i][up]을 비교하기 때문에 
                if (i != N - 1) {
                    for (int j = 0; j < 6; j++) {
                    	//다음으로 입력받는 주사위 번호중 일치하는 값이 있다면
                        if (arr[i + 1][j] == arr[i][up]) {
                            
                        	down = j;
                        }
                    }
                }
            }
            //
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}