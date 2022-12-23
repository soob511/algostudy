import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BJ_1339_단어수학_김주은 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] alphabet = new int[26];
		
		for(int i=0;i<N;i++) {
			String s = sc.next();
			int l = s.length();
			for(int j=0;j<l;j++) {
				alphabet[s.charAt(j)-'A'] += Math.pow(10, l-j-1);
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<26;i++) {
			if(alphabet[i]>0) {
				pq.add(alphabet[i]);
			}
		}
		
		int num=9;
		int sum=0;
		
		while(!pq.isEmpty()) {
			int v = pq.poll();
			sum += v*num--;
		}
		
		System.out.println(sum);
		
	}

}
