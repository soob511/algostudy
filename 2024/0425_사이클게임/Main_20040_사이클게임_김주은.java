import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_20040_사이클게임_김주은 {
	
	static int[] link;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		link = new int[N];
		for(int i=0;i<N;i++) {
			link[i]=i;
		}
		
		int answer = 0;
		
		for(int m=0;m<M;m++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(union(x,y)<0) {
				answer = m+1;
				break;
			}
		}
		
		System.out.println(answer);
	}

	private static int union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py) {
			return -1;
		} 
		link[px]=py;
		return 1;
	}

	private static int find(int x) {
		if(link[x]==x) {
			return x;
		}
		return link[x]=find(link[x]);
	}

}
