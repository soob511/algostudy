package IM;

import java.util.*;
import java.io.*;

public class Main_2578_빙고 {

   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int[][] map = new int[5][5];
      int[][] num = new int[5][5];

      // 맵입력
      for (int i = 0; i < 5; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int j = 0; j < 5; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      int count = 0;
      loop:
    	//부르는 숫자 입력  
      for (int x = 0; x < 5; x++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int y = 0; y < 5; y++) {
            
            num[x][y] = Integer.parseInt(st.nextToken());
            
            count++;
            int bingo = 0;
            int sum3 = 0; // 왼쪽대각선
            int sum4 = 0; // 오른쪽대각선
            
            for (int i=0;i<5;i++) {
            	for (int j=0;j<5;j++) {
            		if (map[i][j] == num[x][y]) {
            			map[i][j] = -1; //부르는 숫자 해당값 -1
            		}
            	}
            }
            
            //맵 탐색
            for (int i = 0; i < 5; i++) {

               int sum1 = 0; // 가로
               int sum2 = 0; // 세로

               for (int j = 0; j < 5; j++) {
                  if (i == j) {//왼쪽 대각선
                	  sum3 += map[i][j];
                  }
                  if (i + j == 4) {//오른쪽 대각선
                	  sum4 += map[i][j];
                  }
                  sum1 += map[i][j];// 가로
                  sum2 += map[j][i];// 세로
               }
               //합이 -5이면 빙고
               if (sum1 == -5) bingo++;
               if (sum2 == -5) bingo++;
               if (sum3 == -5) bingo++;
               if (sum4 == -5) bingo++;

               //빙고 3줄 완성
        	   if (bingo >= 3) {
                   break loop;
                }
            }
         }

      }	
      System.out.println(count);
   }
}