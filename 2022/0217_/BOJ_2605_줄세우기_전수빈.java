package IM;

import java.io.*;
import java.util.*;


public class Main_2605_줄세우기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		ArrayList<Integer> List = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			List.add(num,i+1);
		}
		for(int i=n-1;i>=0;i--) {
			System.out.print(List.get(i)+" ");
		}
	

	}

}
