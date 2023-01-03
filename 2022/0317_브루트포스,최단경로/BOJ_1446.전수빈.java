package Dijkstra;

import java.util.*;
import java.io.*;

public class Main_1446_지름길 {
	static int n,road;
	static int result;
	static ArrayList<int[]> list=new ArrayList<int[]>();

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //지름길 수
		road= Integer.parseInt(st.nextToken()); //고속도로 길이

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());//시작위치
			int end = Integer.parseInt(st.nextToken());//도착위치
			int gill = Integer.parseInt(st.nextToken());//지름길 길이
			if(end>road)continue; //역주행 불가
			if(end-start<=gill)continue; //지름길로 안가도됌
			list.add(new int[] {start,end,gill});

		}
		result = road; //결과 고속도로 길이로 설정
		drive(0,0);//(시작,최소값);
		System.out.println(result);
	}

	private static void drive(int go, int min) {
		
		if(min>=result) return; //최소값이 고속도로길이보다 크면
		if(go==road) { //도착하면 최솟값 반환
			result=min;
			return;
		}
		for(int i=0;i<list.size();i++) {//지름길로 감
			int[] g = list.get(i);
			if(g[0]==go) {//지름길 시작위치와 현재위치가 같다면
				drive(g[1],min+g[2]);//도착점을 시작위치로 넣어주고 최솟값을 더해줌
				}
				
		}
		drive(go+1,min+1);	//고속도로길로감
	}

}
