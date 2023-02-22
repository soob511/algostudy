import java.io.*;
import java.util.*;

public class Main_BJ_18234_당근훔쳐먹기_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		long[][] taste = new long[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0]=Integer.parseInt(st.nextToken());
			taste[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(taste, (o1,o2)->{
			if(o1[1]==o2[1]) {
				return (int) (o1[0]-o2[0]);
			}else {
				return (int) (o1[1]-o2[1]);
			}
		});
		
		long ans=0;
		for(int i=0;i<N;i++) {
			ans+=(taste[i][0]+(T-N+i)*taste[i][1]);
		}
		
		System.out.println(ans);
		
	}

}
