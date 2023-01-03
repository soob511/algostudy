package IM;

import java.io.*;
import java.util.*;

public class Main_2527_직사각형 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(x2>p||y2>q||p2<x||q2<y) {//공통부분이없음
				System.out.println("d");
			}
			else if((x==p2&&y==q2)||(x==p2&&q==y2)||(p==x2&&q==y2)||(p==x2&&y==q2)) { //점 
				System.out.println("c");
			}
			else if((y==q2&&x2<p&&p2>x)||(x==p2&&q2>y&&y2<q)
					||(q==y2&&x2<p&&p2>x)||(x2==p&&q2>y&&y2<q)) {//선분
				System.out.println("b");
			}
			else{
				System.out.println("a");
			}
		}
		
	}

}
