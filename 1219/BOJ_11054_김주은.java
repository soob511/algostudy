import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11054_가장긴바이토닉부분수열_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp_l = new int[N];
		int[] dp_r = new int[N];
	
		//왼쪽에서부터 증가하는 부분수열 찾기
		dp_l[0]=1;
		for(int i=1;i<N;i++) {
			int max = 0;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && max<dp_l[j]) {
					max = dp_l[j];
				}
			}
			dp_l[i] = max+1;
		}
		
		//오른쪽에서부터 증가하는 부분수열 찾기
		dp_r[N-1]=1;
		for(int i=N-2;i>=0;i--) {
			int max=0;
			for(int j=N-1;j>i;j--) {
				if(arr[j]<arr[i] && max<dp_r[j]) {
					max = dp_r[j];
				}
			}
			dp_r[i] = max+1;
		}
		
		int[] dp = new int[N];
		int ans=0;
		for(int i=0;i<N;i++) {
			dp[i] = dp_l[i]+dp_r[i]-1;
			if(dp[i]>ans) {
				ans=dp[i];
			}
		}
		
		System.out.println(ans);
	}

}
