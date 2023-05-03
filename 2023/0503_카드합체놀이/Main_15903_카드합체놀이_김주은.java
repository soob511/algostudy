import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_15903_카드합체놀이_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			long a = Integer.parseInt(st.nextToken());
			pq.add(a);
		}
		
		for(int i=0;i<M;i++) {
			long x = pq.poll();
			long y = pq.poll();
			
			pq.add(x+y);
			pq.add(x+y);
		}
		
		long ans = 0;
		while(!pq.isEmpty()) {
			ans+=pq.poll();
		}
		
		System.out.println(ans);
	}

}
