import java.io.*;
import java.util.*;

public class Main_BJ_1865_웜홀_김주은 {
	
	static class Node{
		int v;
		int time;
		public Node(int v, int time) {
			super();
			this.v = v;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		final int INF = 2700*10001;
		
		int Tc = Integer.parseInt(br.readLine());
		
		for(int t=0;t<Tc;t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			ArrayList<Node>[] list = new ArrayList[N+1];
			for(int i=1;i<=N;i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				list[S].add(new Node(E,T));
				list[E].add(new Node(S,T));
			}
			
			for(int i=0;i<W;i++){
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				list[S].add(new Node(E,-T));
			}
			
			int[] dist = new int[N+1];
			for(int i=1;i<=N;i++) {
				dist[i]=INF;
			}
			dist[1]=0;
			
			for(int v=1;v<=N-1;v++) {
				for(int i=1;i<=N;i++) {
					for(int j=0;j<list[i].size();j++) {
						Node n = list[i].get(j);
						if(dist[n.v]>dist[i]+n.time) {
							dist[n.v] = dist[i]+n.time;
						}
					}
				}
			}
			
			boolean isYes=false;
			A: for(int i=1;i<=N;i++) {
				for(int j=0;j<list[i].size();j++) {
					Node n = list[i].get(j);
					if(dist[n.v]>dist[i]+n.time) {
						sb.append("YES\n");
						isYes=true;
						break A;
					}
				}
			}
			if(!isYes) {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}

}
