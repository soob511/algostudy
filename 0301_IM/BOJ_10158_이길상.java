import java.io.*;
import java.util.StringTokenizer;

public class IM_10_10158_개미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int W = Integer.parseInt(line[0]), H = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		int P = Integer.parseInt(line[0]), Q = Integer.parseInt(line[1]);
		int T = Integer.parseInt(br.readLine());
		
		P+=T;
		Q+=T;
		
		int i = P/W, j = Q/H;
		int x = P%W, y = Q%H;
		
		StringBuilder sb = new StringBuilder();
		
		if(i%2 == 0) sb.append(x);
		else sb.append(W - x);
		
		sb.append(" ");
		
		if(j%2 == 0) sb.append(y);
		else sb.append(H - y);
		
		System.out.println(sb.toString());
	}

}
