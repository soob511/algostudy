import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_22862_가장긴짝수연속한부분수열large_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int start=N;
		int end=N;
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(start==N && end==N && arr[i]%2==0) {
				start=end=i;
			}
		}
		
		int k = 0;
		int even = 1;
		int maxEven = start==N?0:1;
		
		while(start<N && end<N) {
			
			if(k==K) {
				if(end+1<N && arr[end+1]%2==0) {
					end+=1;
					even+=1;
					maxEven = Math.max(even, maxEven);
				} else if(arr[start]%2==0) {
					even-=1;
					while(start<=end && start+1<N && arr[start+1]%2==1) {
						start+=1;
						k-=1;
					}
					start+=1;
					if(start==N) {
						break;
					}
				} 
			} else {
				end+=1;
				
				if(end==N) {
					break;
				}
				
				if(arr[end]%2==1) {//홀수
					k+=1;
				}else {//짝수
					even+=1;
					maxEven = Math.max(even, maxEven);
				}
			}
			
		}
		
		System.out.println(maxEven);
	}

}
