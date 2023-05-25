import java.io.*;
import java.util.*;

public class Main_BJ_2225_합분해_김주은 {
	

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int n = K+N-1;
		int r = N;
		
		long[][] comb = new long[n+1][n+1];
		
		comb[1][0]=comb[1][1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i) {
					comb[i][j]=1;
				}else {
					comb[i][j]=(comb[i-1][j-1]+comb[i-1][j])%1000000000;
				}
			}
		}
		
		System.out.println(comb[n][r]%1000000000);
	}

}
