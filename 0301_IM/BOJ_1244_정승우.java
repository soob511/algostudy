package com.ssafy.day0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1244_정승우 {

	public static void main(String[] args) throws IOException{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
				
		// 스위치 개수
		int N = Integer.parseInt(br.readLine());
		//스위치 담을 배열
		int[]arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int t=1; t<=N; t++) {
			arr[t] = Integer.parseInt(st.nextToken());
		}
		
		//학생 수
		int stu = Integer.parseInt(br.readLine());
		//학생과 받은 번호
		for (int t=0; t<stu; t++) {
			st = new StringTokenizer(br.readLine());
			//성별
			int a = Integer.parseInt(st.nextToken());
			//받은 번호
			int num = Integer.parseInt(st.nextToken());
			
			//남자일경우
			if (a==1) {
				for (int i=num; i<arr.length; i+=num) {
					if(arr[i]==1) {
						arr[i]=0;
					} else arr[i]=1;
				}
			} 
			//여자일경우
			else {
				//num의 좌우값을 비교하기 위한 lt값과 rt값
				int lt=num-1,rt=num+1;
				//lt,rt값이 범위 안에 있는동안
				while (lt!=0 && rt!=arr.length) {
					//lt 값과 rt값이 같고 그때 lt값이 0이라면
					if (arr[lt]==arr[rt]&&arr[lt]==0) {
						//값을 1로 바꿈
						arr[lt]=arr[rt]=1;
						//그 다음 좌우값 비교를 위한 처리
						lt--;
						rt++;
						//lt값과 rt값이 같고 그 값이 1이라면
					} else if (arr[lt]==arr[rt]&&arr[lt]==1) {
						//0으로 바꿔줌
						arr[lt]=arr[rt]=0;
						lt--;
						rt++;
						
						//
					} else {
						lt--;
						rt++;
						continue;
					}
				}
				//arr[num]은 무조건 바뀌므로 반복문이 끝나고 변경
				if(arr[num]==0) arr[num]=1;
				else arr[num]=0;
			}
		}
		//20개씩 출력하도록 처리
		for (int i=1; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			if (i %20 == 0) {
				System.out.println();
			}
		}
	}

}
