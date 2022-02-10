package com.ssafy.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_정승우 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//반복문으로 queue에 1~6까지 저장
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
	
		//제일 앞에 값 버리고 2->1 로 이동한 값 맨 뒤에 저장 후 삭제. 값이 1과 같거나 작아지면 종료
		while (queue.size()>1) {
			queue.poll();
			queue.offer(queue.peek());
			queue.poll();
		}
		System.out.println(queue.poll());
	}
	

}
