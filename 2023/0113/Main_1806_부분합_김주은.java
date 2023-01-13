import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1806_부분합_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] partSum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			if(i==0) {
				partSum[i]=Integer.parseInt(st.nextToken());
			} else {
				partSum[i] = partSum[i-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		int start = 0;
		int end = 1;
		
		int min_length = N+1;
		
		while(end<=N) {
			if(partSum[end]-partSum[start]>=S) {
				min_length = Math.min(end-start, min_length);
				start+=1;
				
			} else {
				end+=1;
			}
		}
		
		System.out.println(min_length==N+1 ? 0 : min_length);
	}

}
