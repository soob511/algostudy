package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2304_창고다각형_김정윤 {
	
	static class top implements Comparable<top>{
		int x, y;

		public top(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(top o) {
			return this.x - o.x;	// 오름차순 정렬
		}
		
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	 // 기둥의 개수
		ArrayList<top> arr = new ArrayList<>();
		int area = 0;
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new top(x, y));
		}
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) System.out.println(arr.get(i));
		
		int maxX = 0;
		// 오른쪽에서 왼쪽으로
		top currenttop = arr.get(0);
		for(int i=1; i<N; i++) {
			if(currenttop.y <= arr.get(i).y) {
				area += (arr.get(i).x-currenttop.x)*currenttop.y;
				currenttop = arr.get(i);
				maxX = i;
			}
		}
		
		// 왼쪽에서 오른쪽으로
		currenttop = arr.get(N-1);
		for(int i=0; i<N-maxX; i++) {
			if(currenttop.y <= arr.get(N-i-1).y) {
				area += (currenttop.x - arr.get(N-i-1).x)*currenttop.y;
				currenttop = arr.get(N-i-1);
			}
		}
		area += currenttop.y;
//		System.out.println(area);

	}

}
