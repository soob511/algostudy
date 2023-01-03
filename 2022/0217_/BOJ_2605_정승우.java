package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605_정승우 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//출력할 결과를 담을 ArrayList 생성
		ArrayList<Integer> arrayList = new ArrayList<>();
		//학생들이 뽑은 번호 저장할 배열 생성
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			
			//학생들이 뽑은 번호 저장
			arr[i] = Integer.parseInt(st.nextToken());
			
			//뽑은 번호의 값이 arrayList의 사이즈보다 크거나 같다면
			if (arr[i]>=arrayList.size()) {
				//arrayList의 맨앞에 i+1값을 추가
				arrayList.add(0,i+1);
			} else {
				//arrayList가 더 큰 경우 arrayList의 사이즈에서 뽑은 번호를 뺀 인덱스 위치에 i+1값 추가
				arrayList.add(arrayList.size()-arr[i],i+1);				
			}
		}
		for (int a : arrayList) {
			System.out.print(a+" ");
		}
	}

}
