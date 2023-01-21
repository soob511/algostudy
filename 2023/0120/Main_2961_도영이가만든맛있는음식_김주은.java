import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min_diff;
	static int[] sour, bitter;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		sour = new int[N];
		bitter = new int[N];
		
		min_diff=1000000000;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			sour[i]=Integer.parseInt(st.nextToken());
			bitter[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			select(i, 0, 0, 1, 0);
		}
		
		System.out.println(min_diff);
	}

	private static void select(int sel_cnt, int cnt, int idx, int sour_mul, int bitter_sum) {

		if(cnt==sel_cnt) {
			if(Math.abs(bitter_sum - sour_mul)<min_diff) {
				min_diff = Math.abs(bitter_sum - sour_mul);
			}
			return;
		}
		
		for(int i=idx;i<N;i++) {
			select(sel_cnt, cnt+1, i+1, sour_mul*sour[i], bitter_sum+bitter[i]);
		}
	}

}
