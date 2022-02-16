package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2605 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
//		arr.add(1);
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
//			if(i==0) continue;
			if(num==0) {
				arr.add(i+1);
			}else {
				arr.add(arr.size()-num, i+1);
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(arr.get(i) + " ");
		}

	}

}
