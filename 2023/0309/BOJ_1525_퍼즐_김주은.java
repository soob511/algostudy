import java.io.*;
import java.util.*;

public class Main_BJ_1525_퍼즐_김주은 {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String target = "123456789";

		StringBuilder start = new StringBuilder();
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int v=Integer.parseInt(st.nextToken());
				if(v==0) {
					v=9;
				}
				start.append(v);
			}
		}
		
		Map<String,Integer> map = new HashMap<>();
		
		Queue<String> q = new ArrayDeque<>();
		q.add(start.toString());
		map.put(start.toString(),0);
		
		while(!q.isEmpty()) {
			
			String n = q.poll();
			
			if(n.equals(target)) {
				System.out.println(map.get(n));
				return;
			}
			
			int nineLoc = n.indexOf('9');
			int x = nineLoc/3;
			int y = nineLoc%3;
			
			for(int d=0;d<4;d++) {
				
				int nx = x+dr[d];
				int ny = y+dc[d];
				int m = nx*3+ny;
				
				if (nx>=0 && nx<3 && ny>=0 && ny<3) {
					StringBuilder next = new StringBuilder(n);
					char t = next.charAt(m);
					next.setCharAt(nineLoc, t);
					next.setCharAt(m, '9');
					String nextStr = next.toString();
					
					if(!map.containsKey(nextStr)) {
						q.add(nextStr);
						map.put(nextStr, map.get(n)+1);
					}
				}		
			}	
		}
		
//		if(map.containsKey(target)) {
//			System.out.println(map.get(target));
//		}else {
//			System.out.println(-1);
//		}
		
		System.out.println(-1);
		
	}

}
