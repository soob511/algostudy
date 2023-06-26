import java.io.*;
import java.util.*;

public class Main_BJ_1707_이분그래프_김주은 {
	
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int k=0;k<K;k++) {
			
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			//그래프 생성
			adjList = new ArrayList[V];
			for(int v=0;v<V;v++) {
				adjList[v]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			int[] nodes = new int[V];
			int visited = 0;
			ArrayDeque<Integer> q = new ArrayDeque<>();
			
			boolean fail=false;
			A : while(visited<V) {
				
				//시작할 노드 선정
				for(int i=0;i<V;i++) {
					if(nodes[i]==0) {
						q.add(i);
						nodes[i]=1;
						visited+=1;
						break;
					}
				}
				
				while(!q.isEmpty()) {
					
					int v = q.poll();
					
					int nextNodeValue = nodes[v]>0?-1:1;
					
					for(int idx=0;idx<adjList[v].size();idx++) {
						
						int nextV = adjList[v].get(idx);
						
						//미방문 노드
						if(nodes[nextV]==0) {
							visited+=1;
							nodes[nextV]=nextNodeValue;
							q.add(nextV);
						} 
						//이미 방문한 노드
						else {
							if(nodes[v]==nodes[nextV]) {
								fail=true;
								break A;
							}
						}
					}
				}
			}
			
			if(fail) {
				sb.append("NO\n");
			} else {
				sb.append("YES\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
