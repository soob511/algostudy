import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2531_회전초밥_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //벨트 위 초밥 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
	
		int[] belt = new int[N+k-1];
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			belt[i]= n;
			if(i<k-1) {
				belt[i+N]=n;
			}
		}
		
		int[] nums = new int[d+1];
		
		int max = 0;
		int cnt = 0;
		for(int i=0;i<k;i++) {
			if(nums[belt[i]]==0) {
				cnt+=1;
			}
			nums[belt[i]]+=1;
		}
		max = nums[c]==0?cnt+1:cnt;
		
		
		for(int i=0;i<N-1;i++) {
			//앞 숫자 제거
			nums[belt[i]]-=1;
			if(nums[belt[i]]==0) {
				cnt-=1;
			}
			//마지막 숫자 추가
			if(nums[belt[i+k]]==0) {
				cnt+=1;
			}
			nums[belt[i+k]]+=1;
			//쿠폰사용
			int temp_max = nums[c]==0?cnt+1:cnt;
			max = Math.max(max, temp_max);
		}
		
		System.out.println(max);
	
	}

}
