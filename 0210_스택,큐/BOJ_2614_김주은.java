package com.ssafy.add.d0210;

import java.io.*;
import java.util.*;

public class boj_2614_카드2_김주은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//카드의 개수
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//모든 카드를 Queue에 넣기
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		
		while(queue.size()!=1) {
			//제일 위의 카드 버리기
			queue.poll();
			//다음 카드를 제일 아래로 옮기기
			queue.add(queue.poll());
		}
		
		//마지막 남은 카드 출력
		System.out.println(queue.poll());
		
	}

}
