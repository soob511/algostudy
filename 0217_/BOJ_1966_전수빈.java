package queue;

import java.io.*;
import java.util.*;

public class Main_1966_프린터큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //testcase
		for (int t = 0; t < n; t++) {
			LinkedList<Integer> q = new LinkedList<>();  //문서
			Queue<Integer> iq = new LinkedList<>();//위치

			int m = sc.nextInt();//문서의개수
			int idx = sc.nextInt();//궁금한 문서 위치

			for (int i = 0; i < m; i++) {
				int num = sc.nextInt();//문서
				q.add(num); //리스트에 넣기
				
				if(i==idx) {
					iq.offer(idx); //위치큐에 넣기
				}
				else {
					iq.offer(-1);//다른수는 -1넣어줌 궁금한문서위치만 알면되기때문
				}
			}
			
			int count=0;
			while(!q.isEmpty()) {
				boolean check = true;
				
				for(int i=0; i<q.size();i++) {//제일 앞에꺼보다 뒤에 큰게있는지 확인
					if(q.peek()<q.get(i)) {
						check = false;
						break;
					}
				}
				
				if(!check) {//false 이면 맨앞꺼 뒤로 넣기
				q.add(q.poll());
				iq.offer(iq.poll());
				
				}
				else { //큰수부터 삭제
					q.poll();
					count++; //삭제한 순서세기
					if(iq.peek()==idx) {//궁금한 문서 빠진 차례
						System.out.println(count);
					}
					iq.poll();
				}
			}
			
			
			
			
			
		}

	}

}
