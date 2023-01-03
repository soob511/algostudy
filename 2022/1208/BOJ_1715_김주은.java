import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BJ_1715_카드정렬하기_김주은 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			q.add(sc.nextInt());
		}
		
		int count=0;
		
		while(q.size()>1) {
			int a = q.poll();
			int b = q.poll();
			count += (a+b);
			q.add(a+b);
		}
		
		System.out.println(count);
		
	}

}
