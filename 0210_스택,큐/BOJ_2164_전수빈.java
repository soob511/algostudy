package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer>  queue = new LinkedList<>(); //큐 생성
		int n = sc.nextInt();//갯수입력
		
		for(int i=1;i<=n;i++) {
			queue.offer(i); //1부터 숫자 입력
		}
		
		
		
		while(queue.size()>1) {
			queue.poll();  //처음꺼 빼기
			queue.offer(queue.poll()); //두번째꺼 빼서 뒤로 넣어주기
			
		}
		System.out.println(queue.poll());
	}

}
