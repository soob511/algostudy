import java.io.*;
import java.util.*;

public class Main_BJ_14888_연산자끼워넣기_김주은 {
	
	static int N;
	static int[] num;
	static int[] op;
	static int[] arr;
	static boolean[] visited;
	static int min = 1000000000;
	static int max = -1000000000;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		op = new int[N-1];
		int idx=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			int val = Integer.parseInt(st.nextToken());
			while(val-->0) {
				op[idx++]=i;
			}
		}
		
		arr = new int[N-1];
		visited = new boolean[N-1];
		
		dfs(0,0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int idx, int cnt) {
		
		if(cnt==N-1) {
//			for(int i=0;i<N-1;i++) {
//				System.out.print(arr[i]+",");
//			}
//			System.out.println();
			int ans = num[0];
			for(int i=0;i<N-1;i++) {
				if(arr[i]==0) {
					ans = ans + num[i+1];
				} else if(arr[i]==1) {
					ans = ans - num[i+1];
				} else if(arr[i]==2) {
					ans = ans * num[i+1];
				} else if(arr[i]==3) {
					ans = ans / num[i+1];
				}
			}
			
			if(ans>max) {
				max = ans;
			}
			if(ans<min) {
				min = ans;
			}
			
			return;
		}
		
		for(int i=0;i<N-1;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[cnt]=op[i];
				dfs(i+1,cnt+1);
				visited[i]=false;
			}

		}
		
	}
	
	

}
