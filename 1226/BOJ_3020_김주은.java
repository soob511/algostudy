import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_BJ_3020_개똥벌레_김주은 {
	
	static int N, H;
	static int[] down, up;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		H = sc.nextInt();
		
		down = new int[H+2];
		up = new int[H+2];
		
		for(int i=0;i<N/2;i++) {
			down[sc.nextInt()]++;
			up[H-sc.nextInt()+1]++;
		}
		
		for(int i=1;i<=H;i++) {
			down[i]+=down[i-1];
		}
		for(int i=H;i>=1;i--) {
			up[i]+=up[i+1];
		}
		
		int min = N;
		int cnt = 0;
		
		for(int i=1;i<=H;i++) {
			int obs = (down[H]-down[i-1])+(up[1]-up[i+1]);
			
			if(obs<min) {
				min = obs;
				cnt = 1;
			} else if(obs == min) {
				cnt++;
			}
		}
		
		
		System.out.println(min+" "+cnt);
	}
}
