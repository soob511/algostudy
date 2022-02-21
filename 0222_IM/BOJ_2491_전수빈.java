package IM;

import java.util.Scanner;

public class Main_2491_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수열의 길이
		
		int[] arr = new int[n];
		// 수열 입력
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		int bcnt=1; //오름차순 카운트
		int result=1; //수열길이

		//오름차순
		for(int i=0;i<n-1;i++) {
			
			if(arr[i]<=arr[i+1]) {//다음수가 더 크면 카운트
				bcnt++;
				
				if(bcnt>=result) { //길이 최댓값 넣어주기
					result= bcnt;
				}
			}
			else//초기화
			{
				bcnt=1;
			}
		}
		
		int scnt=1; //내림차순 카운트
		
		//내림차순
		for(int i=0;i<n-1;i++) {
			
		if(arr[i]>=arr[i+1]) {//다음수가 작으면 카운트
				scnt++;
				
				if(scnt>=result) {//길이 최댓값 넣어주기
					result= scnt;
				}
			}
			else//초기화
			{
				scnt=1;
			}
		}
		System.out.println(result);
	}

}
