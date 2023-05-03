import java.io.*;
import java.util.*;

public class Main_BJ_1461_도서관_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> pos = new ArrayList<>();
		ArrayList<Integer> neg = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			
			if(a>0) {
				pos.add(a);
			}else {
				neg.add(-a);
			}
		}
		
		Collections.sort(pos);
		Collections.sort(neg);
		
		int answer = 0;
		
		int p = pos.size()-1;
		while(p>=0) {
			answer+=pos.get(p)*2;
			p-=M;
		}
		
		int n = neg.size()-1;
		while(n>=0) {
			answer+=neg.get(n)*2;
			n-=M;
		}

		if(neg.isEmpty()) {
			answer-=pos.get(pos.size()-1);
		}else if(pos.isEmpty()) {
			answer-=neg.get(neg.size()-1);
		}else {
			int max = Math.max(pos.get(pos.size()-1), neg.get(neg.size()-1));
			answer-=max;
		}
		
		
		System.out.println(answer);
		
	}

}
