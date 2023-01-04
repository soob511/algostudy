import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int sum;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		sum = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		
		int M = Integer.parseInt(br.readLine());

		int max_budget = 0;
		
		int start = 1;
		int end = max;
		
		while(start<=end) {
		
			int mid = (start+end)/2;
			
			int val = 0;
			for(int i=0;i<N;i++) {
				if(mid<arr[i]) {
					val+=mid;
				} else {
					val+=arr[i];
				}
			}
			
			if(val>M) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		
		System.out.println(end);
	}

}
