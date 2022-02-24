package com.ssafy.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_정승우 {

	static int x,y,p,q,x1,y1,p1,q1;
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			
			//각 입력값 받음
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			p=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			p1=Integer.parseInt(st.nextToken());
			q1=Integer.parseInt(st.nextToken());

			
			//겹치는 부분 없는 경우
			if(q<y1||x>p1||y>q1||q<y1) {
				System.out.println('d');
			//선분이 겹침
			}else if((p1==x&&q1>y&&q>y1)||(p==x1&&q>y1&&q1>y)||(q==y1&&p1>x&&p>x1)||(q1==y&&p>x1&&p1>x)) {
				System.out.println('b');
			//점이 겹침
			}else if((x==p1||x1==p)||(y==q1)||(q==y1)) {
				System.out.println('c');
			//그 외의 경우(직사각형이 겹치는경우)
			}else {
				System.out.println('a');
			}				
		}
	}                                             
}
