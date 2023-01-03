import java.io.*;
import java.util.*;

public class Main_BJ_16928_뱀과사다리게임_김주은2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] map = new int[101];
		boolean[] visited = new boolean[101];
		
		for(int i=0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start] = end;
		}
		
		int count=0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[1]=true;
		q.add(1);
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int pos = q.poll();
				
				if(pos==100) {
					System.out.println(count);
					return;
				}
				
				for(int d=1;d<=6;d++) {
					if(pos+d<=100) {
						if(map[pos+d]==0 && visited[pos+d]==false) {
							q.add(pos+d);
							visited[pos+d]=true;
						} else if(visited[map[pos+d]]==false) {
							q.add(map[pos+d]);
							visited[map[pos+d]]=true;
						}
					}
				}
			}
			++count;
		}
	}

}
