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
		
		while(N-->0) {
			
		}
		
		System.out.println(L);
	}

}
