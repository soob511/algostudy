import java.io.*;
import java.util.*;

public class Main_BJ_1092_배_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] crane = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			crane[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crane);
		
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> box= new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box);
		
		if(crane[N-1]<box.get(M-1)) {
			System.out.println(-1);
			return;
		}
		
		int cnt = 0;
		A : while(!box.isEmpty()) {
			cnt+=1;
			int bidx = box.size()-1;
			for(int i=N-1;i>=0;) {
				if(crane[i]>=box.get(bidx)) {
					box.remove(bidx);
					i-=1;
				}
				bidx-=1;
				if(bidx<0) {
					break;
				}
				if(box.isEmpty()) {
					break A;
				}
				
			}
			
		}
		
		System.out.println(cnt);
		
	}

}
