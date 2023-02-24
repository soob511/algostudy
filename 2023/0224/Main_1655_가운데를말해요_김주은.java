import java.io.*;
import java.util.*;

public class Main_BJ_1655_가운데를말해요_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqMin = new PriorityQueue<>();
		
		int prev = Integer.parseInt(br.readLine());
		pqMax.add(prev);
		sb.append(prev+"\n");
		
		for(int i=1;i<N;i++) {
			int v = Integer.parseInt(br.readLine());
			
			if(i%2==1) {//홀수번째
				if(pqMax.peek()>v) {//왼쪽 큐 최댓값보다 작다면 오른쪽 큐로 이동 후 왼쪽에 넣기
					pqMin.add(pqMax.poll());
					pqMax.add(v);
				}else { //오른쪽 큐에 넣기
					pqMin.add(v);
				}
				
			} else {//짝수번째
				if(pqMin.peek()<v) { //오른쪽 큐 최솟값보다 크다면 왼쪽 큐로 이동후 오른쪽에 넣기
					pqMax.add(pqMin.poll());
					pqMin.add(v);
				} else { //왼쪽 큐에 넣기
					pqMax.add(v);
				}
				
			}
			
			sb.append(pqMax.peek()+"\n");
		}
		
		System.out.println(sb);
	}

}
