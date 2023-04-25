import java.io.*;
import java.util.*;

public class Main_BJ_17396_백도어_김주은 {
	
	static class Node {
		int n;
		long t;
		
		public Node(int n, long t) {
			super();
			this.n = n;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception{
		
		final long INF = Long.MAX_VALUE;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] spot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			spot[i]=Integer.parseInt(st.nextToken())==1?true:false;
		}
		spot[N-1]=false;
		
		ArrayList<Node>[] adjList = new ArrayList[N];
		for(int i=0;i<N;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Node(b,t));
			adjList[b].add(new Node(a,t));
		}
		
		long[] dist = new long[N];
		Arrays.fill(dist, INF);
		dist[0]=0;
		
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
			return (int) (o1.t-o2.t);
		});
		q.add(new Node(0,0));
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			
			if(dist[n.n]<n.t) {
				continue;
			}
			
			for(int i=0;i<adjList[n.n].size();i++) {
				Node next = adjList[n.n].get(i);
				
				if(spot[next.n]) {
					continue;
				}
				
				if(dist[n.n]+next.t<dist[next.n]) {
					dist[next.n] = dist[n.n]+next.t;
					q.add(new Node(next.n, dist[next.n]));
				}
				
			}
			
		}
		
		if(dist[N-1]==INF) {
			System.out.println(-1);
		} else {
			System.out.println(dist[N-1]);
		}
		
	}

}
