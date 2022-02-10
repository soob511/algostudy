package com.ssafy.add.d0210;

import java.io.*;
import java.util.*;

public class boj_10773_제로_김주은 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		int sum=0; //적은 수의 합
		
		//입력되는 총 정수 개수
		int K = Integer.parseInt(br.readLine());
		
		//수를 조건에 맞게 저장
		for(int i=0;i<K;i++) {
			//재현이가 부르는 수 입력
			int n = Integer.parseInt(br.readLine());
			
			//정수가 0일 경우 가장 최근 수 pop
			if(n==0) {
				stack.pop();
			}
			//정수가 0이 아닐 경우 해당 수 push
			else {
				stack.push(n);
			}
		}
		
		//합 구하기
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}

}
