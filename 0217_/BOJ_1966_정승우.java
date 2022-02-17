package com.ssafy.day0215;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_정승우 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for (int i=0; i<N; i++) {
				queue.offer(Integer.parseInt(st2.nextToken()));
			}
			//Queue에서 몇번째에 놓여있는지 나타내는 정수를 저장하는 배열
			int[] arr = new int[N];
			
			for (int i=0; i<queue.size(); i++) {
				arr[i] = queue.peek();
				queue.offer(queue.poll());
			}
			int k= arr[M];
			//배열 오름차순으로 정렬
			Arrays.sort(arr);
			
			int count=0;
			//범위를 맨뒤에서 앞으로가게하여 1,2,3,4 이런식으로 있다면 4,3,2,1 이렇게 접근하도록 반복문
			for (int i=arr.length-1; i>=0; i--) {

				//맨 뒤에값(우선순위가 가장 높은 값이 큐의 첫번째 값이 같지 않은동안)
				while(arr[i]!=queue.peek()) {
					queue.offer(queue.poll());//큐에 맨 앞에값을 맨 뒤쪽으로 보냄
				}
				count++;
				// 배열에 1,2,3,4가 있다면 반복문 제일 처음 i값은 우선순위가 가장 높은4
				if (i+1==k) { //i값이 
					System.out.println(count);
					
				}
			}
	

		}
		
	}

}
