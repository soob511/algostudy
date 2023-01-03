package Queue_Dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_김정윤 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 정수 N 입력
		
		Queue<Integer> cards = new LinkedList();
		
		// 1. 1~N 카드 생성
		for(int i=1; i<=N; i++) {
			cards.add(i);
		}
		
		// 2. 카드 이동
		while(true) {	
			if(cards.size()==1) break;	// 종료 조건
			cards.poll();				// 맨 위의 카드 삭제
			cards.offer(cards.poll());	// 맨 위의 카드 --> 맨 밑으로
		}
		
		System.out.println(cards.poll());

	}

}
