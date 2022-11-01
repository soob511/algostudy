import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		//크루스칼 알고리즘
		parent = new int[V];
		for(int i=0;i<V;i++) {
			parent[i]=i;
		}
		
		int[][] edges = new int[E][3];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken())-1;
			edges[i][1] = Integer.parseInt(st.nextToken())-1;
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(edges, (v1, v2)->{
			return v1[2]-v2[2];
		});
		
		for(int i=0;i<E;i++) {
			if(isNotCycle(edges[i][0], edges[i][1])) {
				answer += edges[i][2];
			}
		}
		
		System.out.println(answer);
		
	}

	private static boolean isNotCycle(int i, int j) {
		
		int iparent = getParent(i);
		int jparent = getParent(j);
		
		if(iparent==jparent) { //사이클
			return false;
		}
		else {
			//연결
//			if(iparent<jparent) {
//				parent[jparent]=iparent;
//			} else {
//				parent[iparent]=jparent;
//			}
			
			parent[jparent]=iparent;
			return true;
		}
	}

	private static int getParent(int a) {
		if(parent[a]==a) return a;
		return parent[a] = getParent(parent[a]);
	}

}
