package recur;

import java.util.Scanner;

public class Main_10870 {
	
	public static int function(int n)
	{	
		if(n==0) return 0;
		if(n==1) return 1;
		
		return function(n-1)+function(n-2);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(function(n));
	}

}
