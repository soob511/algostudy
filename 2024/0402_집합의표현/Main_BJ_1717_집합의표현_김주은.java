
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1717_집합의표현 {
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i=0;i<N+1;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(flag==0) {
				union(A,B);
			} else {
				sb.append(isUnion(A,B)?"YES":"NO");
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}

	private static boolean isUnion(int a, int b) {
		return findParent(a)==findParent(b)?true:false;
	}

	private static int findParent(int a) {
		if(parent[a]==a) {
			return a;
		}
		return parent[a]=findParent(parent[a]);
	}

	private static void union(int a, int b) {
		int ap = findParent(a);
		int bp = findParent(b);
		if(ap!=bp) {
			parent[ap]=bp;
		}
		
	}

}
