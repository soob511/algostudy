import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2792_보석상자_김주은 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] jewels = new int[M];
		for(int m=0;m<M;m++) {
			jewels[m]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewels);
		
		int min = 1, max = jewels[M-1];
		int answer = 0;
		
		while(min<=max) {
			
			int mid = (min+max)/2;
			
			int sums = 0;
			for(int i=0;i<M;i++) {
				sums+=(jewels[i]%mid==0)?jewels[i]/mid:jewels[i]/mid+1;
			}
			
			if(sums<=N) {
				answer = mid;
				max=mid-1;
				
			}else {
				min=mid+1;
			}
		}
		
		System.out.println(answer);
		
	}

}
