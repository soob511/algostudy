import java.io.*;
import java.util.*;

public class Main_BJ_13904_과제_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
			if(o2[0]-o1[0]==0) {
				return o2[1]-o1[1];
			} else {
				return o2[0]-o1[0];
			}
		});
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		int[] v = pq.poll();
		int day = v[0];//남은 날짜
		int sum = v[1];//점수 합
		if(day>1) {
			while(!pq.isEmpty()) {
				
				v = pq.poll();
				
				if(v[0]==day) {
					pq.offer(new int[] {v[0]-1, v[1]}); //날짜 하루 감소
				} else if(v[0]<day) { //날짜 갱신
					day=v[0];
					sum+=v[1];
					if(day==1) {
						break;
					}
				}

			}
		}
		
		System.out.println(sum);
		
	}

}
