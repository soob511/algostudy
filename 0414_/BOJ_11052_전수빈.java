package dp;

import java.util.Scanner;

public class Main_11052_카드구매하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] card = new int[n+1];
		int[] d = new int[n+1];
		for(int i=1;i<=n;i++) {
			card[i]= sc.nextInt();
		}
		d[0]=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				  d[i] = Math.max(d[i], d[i - j] + card[j]);
			}
			
		}

		System.out.println(d[n]);
		
	}

}
