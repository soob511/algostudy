import java.io.*;
import java.util.*;

public class Main_BJ_13305_주유소_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N-1];
		int[] price = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
	
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int sum_price = 0;
		int sum_dist = 0;
		int min_price = price[N-2];
		
		for(int i=N-2;i>=0;i--) {
			
			sum_dist += dist[i];
			
			if(price[i]<=min_price) {
				sum_price = sum_dist * price[i];
			} else {
				sum_price += dist[i]*price[i];
			}
		}
		
		System.out.println(sum_price);
	}
}
