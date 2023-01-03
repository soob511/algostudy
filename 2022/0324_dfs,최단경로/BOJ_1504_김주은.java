package com.ssafy.add.d0324;

import java.io.*;
import java.util.*;

public class Main_BJ_1504_특정한최단경로_김주은 {
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static final int INF = 1001;
	static int N;
	static ArrayList<ArrayList<Node>> adjList;
	static int[] dist;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<ArrayList<Node>>(); //인접리스트
		
		for(int i=0;i<=N;i++) {
			adjList.add(new ArrayList<Node>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(new Node(to, weight));
			adjList.get(to).add(new Node(from, weight));
		}
		
		//반드시 거쳐야할 두 정점
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		
		int sum1=0;
		sum1 = dijkstra(1, a) + dijkstra(a, b) + dijkstra(b, N);
		
		int sum2=0;
		sum2 = dijkstra(1, b) + dijkstra(b, a) + dijkstra(a, N);
		
		
		if(dijkstra(1,a)==INF || dijkstra(1,b)==INF || dijkstra(a,b)==INF || dijkstra(b,N)==INF || dijkstra(a,N)==INF)
			System.out.println(-1);
		else 
		{
			int answer=Math.min(sum1, sum2);
			System.out.println(answer);
		}
		
	}
	
	
	static int dijkstra(int start, int end) {
		
		Arrays.fill(dist, INF); //초기화
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); //최소의 거리로 방문할 수 있는 다음 노드 반환을 위한 우선순위 큐
		
		//시작
		pq.offer(new Node(start, 0));
		dist[start]=0;

		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int n = node.to;
			int w = node.weight;
			
			if(dist[n]<w)
				continue;
			
			for(int i=0;i<adjList.get(n).size();i++) {
				int cost = dist[n] + adjList.get(n).get(i).weight;
				
				if(cost < dist[adjList.get(n).get(i).to]) {
					dist[adjList.get(n).get(i).to] = cost;
					pq.add(new Node(adjList.get(n).get(i).to, cost));
				}
			}
		}
		
		return dist[end];
		
	}

}
