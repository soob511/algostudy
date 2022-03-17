package IM;

import java.io.*;
import java.util.*;

public class Main_2304_창고다각형 {

	public static void main(String[] args) throws Exception{
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = 1001;
		int[] map = new int[m];
		
		int n = Integer.parseInt(br.readLine()); //다각형 갯수
		
		int start = 1001; //시작인덱스
		int end = 0;//끝 인덱스
		int mid =0 ; // 제일큰 인덱스
		int max=0;
		for(int i=0;i<n;i++) { // 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L =  Integer.parseInt(st.nextToken());
			int h =  Integer.parseInt(st.nextToken());
			map[L] = h;
			
			if(max<h) {//제일큰 인덱스 구하기
				max=h;
				mid = L;
			}
		
			start = Math.min(start, L); // 시작인덱스 구하기
			end = Math.max(end, L);//끝인덱스 구하기

		}

		
		//제일큰값기준 왼쪽 구하기
		int left=0;
		int num=0;
		for(int i=start;i<=mid;i++) {
			if(map[i]>=num) {
				num = map[i];
				left += num;
			}
			else if(map[i]<num) {
				left += num;
			}
			
		}
		
		//오른쪽 구하기
		int right=0;
		num=0;
		for(int i=end;i>mid;i--) {
			if(map[i]>=num) {
				num = map[i];
				right += num;
			}
			else if(map[i]<num) {
				right += num;
			}
		}
		
		//넓이 합
		System.out.println(left+right);
		
	}

}
