import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class IM_16_2304_창고다각형 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 기둥 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 기둥 정보 입력
		int[] pillar = new int[1001];
		int low = 1000, high = 1;
		
		for (int n = 0; n < N; n++) {
			String[] line = br.readLine().split(" ");
			int L = Integer.parseInt(line[0]);
			int H = Integer.parseInt(line[1]);
			
			pillar[L] = H;
			
			low = Math.min(low, L);
			high= Math.max(high, L);
		}
			
		// 계산
		int result = 0, left = pillar[low], right = pillar[high];
		while(low<=high) {
			left = Math.max(left, pillar[low]);
			
			result += left;
			
			low++;
		}
		while(left>pillar[high]) {
			right = Math.max(right, pillar[high]);
			
			result -= (left - right);

			high--;
		}
		
		// 출력
		System.out.println(result);
	}

}
