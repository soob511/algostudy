import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(N<3) {
			System.out.println(N);
			return;
		}
		
		int max=2;
		
		for(int start=0;start<N-1;start++) {
			int sum = arr[start]+arr[start+1];
			for(int end=start+2;end<N;end++) {
				if(sum>arr[end]) {
					max = Math.max(max, end-start+1);
				}
			}
			
		}
		
		System.out.println(max);
		
	}

}
