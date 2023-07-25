import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1238_파티_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		
		ArrayList<int[]>[] graph_go = new ArrayList[N];
		ArrayList<int[]>[] graph_back = new ArrayList[N];
		for(int i=0;i<N;i++) {
			graph_go[i]=new ArrayList<>();
			graph_back[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			graph_go[s].add(new int[] {e,t});
			graph_back[e].add(new int[] {s,t});
		}
		
		ArrayDeque<int[]> q_back = new ArrayDeque<>();
		
		int[] back = new int[N];
		Arrays.fill(back, Integer.MAX_VALUE);
		
		q_back.add(new int[] {X,0});
		back[X]=0;
		
		while(!q_back.isEmpty()) {
			
			int[] v = q_back.poll();
			
			if(back[v[0]]<v[1]) {
				continue;
			}
			
			for(int i=0;i<graph_go[v[0]].size();i++) {
				int[] nv = graph_go[v[0]].get(i);
				int nd = v[1]+nv[1];
				if(nd<back[nv[0]]) {
					back[nv[0]]=nd;
					q_back.add(new int[] {nv[0],nd});
				}
			}
		}

		ArrayDeque<int[]> q_go = new ArrayDeque<>();
		int[] go = new int[N];
		Arrays.fill(go, Integer.MAX_VALUE);
		
		q_go.add(new int[] {X,0});
		go[X]=0;
		
		while(!q_go.isEmpty()) {
			
			int[] v = q_go.poll();
			
			if(go[v[0]]<v[1]) {
				continue;
			}
			
			for(int i=0;i<graph_back[v[0]].size();i++) {
				int[] nv = graph_back[v[0]].get(i);
				int nd = v[1]+nv[1];
				if(nd<go[nv[0]]) {
					go[nv[0]]=nd;
					q_go.add(new int[] {nv[0],nd});
				}
			}
		}
		
		int answer=0;
		for(int i=0;i<N;i++) {
			if(i==X) {
				continue;
			}
			answer = Math.max(answer, go[i]+back[i]);
		}
		
		System.out.println(answer);
		
	}

}
