import java.io.*;
import java.util.*;

public class Main_BJ_2529_부등호_김주은2 {
	
	static int N;
	static char[] arr;
	
	static ArrayList<String> answers = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		
		for(int i=0;i<10;i++) {
			boolean[] check = new boolean[10];
			check[i]=true;
			dfs(0,i+"",check);
		}
		
		Collections.sort(answers);
		System.out.println(answers.get(answers.size()-1));
		System.out.println(answers.get(0));
	}

	private static void dfs(int cnt, String str, boolean[] check) {
		
		if(cnt==N) {
			answers.add(str);
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(check[i]) {
				continue;
			}
			
			int last = str.charAt(cnt)-'0';
			
			if((arr[cnt]=='<' && last<i) || (arr[cnt]=='>' && last>i)) {
				check[i]=true;
				dfs(cnt+1, str+i, check);
				check[i]=false;
			} 
		}
	}
	
	

}
