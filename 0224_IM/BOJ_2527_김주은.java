package com.ssafy.add.d0224;

import java.util.*;
import java.io.*;

public class Main_BJ_2527_직사각형_김주은 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			
			//d인 경우 (상, 우, 하, 좌 순서)
			if(q1<y2 || p1<x2 || y1>q2 || p2<x1) {
				sb.append("d").append("\n");
			}
			//c인 경우 (우상, 우하, 좌하, 좌상 순서)
			else if((p1==x2 && q1==y2) || (p1==x2 && y1==q2) || (x1==p1 && y1==q1) || (x1==p2 && q1==y2)) {
				sb.append("c").append("\n");
			}
			//b인 경우 (상, 우, 하, 좌 차례로 접함)
			else if((q1==y2 && (x1<p2 || p1>x2)) || (p1==x2 && (q1>y2 || p1>x2)) || (y1==q2 &&(x1<p2 || p1>x2))|| (x1==p2 && (q1>y2 || p1>x2))) {
				sb.append("b").append("\n");
			}
//			else if((q1==y2 && x1<p2 && p1>x2) || (p1==x2 && q1>y2 && p1>x2) || (y1==q2 && x1<p2 && p1>x2)|| (x1==p2 && q1>y2 && p1>x2)) {
//				sb.append("b").append("\n");
//			}
			//a인 경우
			else {
				sb.append("a").append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
