import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17266_어두운굴다리_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] spot = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			spot[i]=Integer.parseInt(st.nextToken());
		}
		
		int min = spot[0]==0?1:spot[0];
		for(int i=1;i<M;i++) {
			min = Math.max(min,(spot[i]-spot[i-1]+1)/2);
		}
		min = Math.max(min, N-spot[M-1]);
		
		System.out.println(min);
	}

}
