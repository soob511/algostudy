import java.io.*;
import java.util.*;

public class Main_BJ_2529_부등호_김주은 {
	
	static int N;
	static int[] num;
	static boolean[] visited;
	static char[] size;
	static int[] max, min;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		size = new char[N];
		
		
		max = new int[N+1];
		min = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			max[i]=0;
			min[i]=9;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			size[i] = st.nextToken().charAt(0);
		}
		
		for(int i=0;i<10;i++) {
			num = new int[N+1];
			visited = new boolean[10];
			num[0]=i;
			visited[i]=true;
			dfs(0);
		}
		
		for(int i=0;i<N+1;i++) {
			System.out.print(max[i]);
		}
		System.out.println();
		for(int i=0;i<N+1;i++) {
			System.out.print(min[i]);
		}
		System.out.println();
	}

	private static void dfs(int cnt) {
		
		if(cnt==N) {
			isMax();
			isMin();
			return;
		}
		
		for(int i=0;i<10;i++) {
			
			if(visited[i]) {
				continue;
			}
			
			if(size[cnt] == '<' && num[cnt]<i) {
				num[cnt+1] = i;
				visited[i] = true;
				dfs(cnt+1);
				visited[i] = false;
			} else if(size[cnt]== '>' && num[cnt]>i) {
				num[cnt+1] = i;
				visited[i] = true;
				dfs(cnt+1);
				visited[i] = false;
			}
			
		}
	}

	private static void isMin() {
		for(int i=0;i<N+1;i++) {
			if(min[i]>num[i]) {
				copy(min,num);
				break;
			} else if(min[i]==num[i]) {
				continue;
			} else {
				break;
			}
		}
	}
	private static void isMax() {
		for(int i=0;i<N+1;i++) {
			if(max[i]<num[i]) {
				copy(max,num);
				break;
			}
		}
	}

	private static void copy(int[] a, int[] b) {
		for(int i=0;i<N+1;i++) {
			a[i] = b[i];
		}
	}
}
