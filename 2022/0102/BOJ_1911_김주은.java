import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1911_흙길보수하기_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] damp = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			damp[i][0]= Integer.parseInt(st.nextToken());
			damp[i][1]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(damp, (a,b)->{return a[0]-b[0];});
		
		int cnt=0;
		
		if(damp[N-1][1]-damp[0][0]+1<L) {
			cnt=1;
		} else {
			int nulpanzi=-1;
			for(int i=0;i<N;i++) {
				int start = damp[i][0]+1;
				int end = damp[i][1];
				int idx=start;
				
				if(i>=1 && nulpanzi>=end) {
					continue;
				} else if(i>=1 && nulpanzi>=start && nulpanzi<end) {
					idx = nulpanzi+1;
				} 
				
				while(idx+L-1<end) {
					idx += L;
					++cnt;
				}
				++cnt;
				nulpanzi = idx+L-1;
			}
		}
		
		System.out.println(cnt);
		
	}

}
