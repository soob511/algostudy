
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_12869_뮤탈리스크_김주은 {
	
	static int N;
	static int[][] att = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int[] scv = {0,0,0};
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			scv[i]=Integer.parseInt(st.nextToken());
		}
		
		dp = new int[61][61][61];
		
		System.out.println(dfs(scv[0],scv[1],scv[2]));
	}

	private static int dfs(int one, int two, int three) {
		
		if(one<0) {
			return dfs(0,two,three);
		}
		
		if(two<0) {
			return dfs(one,0,three);
		}
		
		if(three<0) {
			return dfs(one,two,0);
		}
		
		if(one==0 && two==0 && three==0) {
			return 0;
		}
		
		if(dp[one][two][three]!=0) {
			return dp[one][two][three];
		}
		
		dp[one][two][three]=Integer.MAX_VALUE;
		for(int i=0;i<6;i++) {
			dp[one][two][three] = Math.min(dp[one][two][three], dfs(one-att[i][0],two-att[i][1],three-att[i][2])+1);
		}
		
		return dp[one][two][three];
		
	}


}
