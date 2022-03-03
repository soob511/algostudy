package com.ssafy.add.d0303;


import java.io.*;
import java.util.*;

public class Main_BJ_1244_스위치켜고끄기_김주은 {

   public static void main(String[] args) throws Exception {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = null;
      StringBuilder sb = new StringBuilder();
      
      int N = Integer.parseInt(br.readLine());
      
      int[]	switches = new int[N+1];
      
      st = new StringTokenizer(br.readLine());
      for(int i=1;i<=N;i++) {
    	  switches[i] = Integer.parseInt(st.nextToken());
      }
      
      int M = Integer.parseInt(br.readLine());
      
      for(int i=0;i<M;i++) {
    	  st = new StringTokenizer(br.readLine());
    	  int gender = Integer.parseInt(st.nextToken());
    	  int num = Integer.parseInt(st.nextToken());
    	  
    	  //남학생
    	  if(gender==1) {
    		int val=num;
    		while(num<=N) {
    			switches[num]=(switches[num]==0?1:0);
    			num+=val;
    		}
    	  }
    	  //여학생
    	  else if(gender==2) {
    		  int range = Math.min(N-num, num-1);
    		  int idx=1;
    		  switches[num]=(switches[num]==0?1:0);
    		  while(idx<=range) {
    			  if(switches[num-idx]==switches[num+idx]) {
    				  switches[num-idx]=(switches[num-idx]==0?1:0);
    				  switches[num+idx]=(switches[num+idx]==0?1:0);
    				  ++idx;
    			  }else {
    				  break;
    			  }
    		  }
    	  }
      }
      
      //출력
      for(int i=1;i<=N;i++) {
    	  sb.append(switches[i]);
    	  if(i%20>0) {
    		  sb.append(" ");
    	  }else {
    		  sb.append("\n");
    	  }
      }
      sb.setLength(sb.length()-1);
      System.out.println(sb);
      
   }
}