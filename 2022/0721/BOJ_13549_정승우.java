package com.ssafy.day0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_정승우 {
    
	static class Pos{
        int idx;
        int time;

        public Pos(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int k = Integer.parseInt(st.nextToken()); // 동생의 위치

        int[]  visited = new int[100001];

        Queue<Pos> q = new LinkedList<>(); // 위치 저장
        q.add(new Pos(n, 1)); 
        visited[n] = 1; 

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            

            //앞으로 이동할 때
            if(cur.idx+1>=0 && cur.idx+1<=100000){ //범위 안에 있음
                if(visited[cur.idx+1] == 0 || visited[cur.idx+1] > cur.time+1){ //방문한 적 없거나 방문한적이 있어도 방문된 시간이 지금 time+1보다 크다면
                    visited[cur.idx+1] = cur.time+1; // 다시 방문처리
                    q.add(new Pos(cur.idx + 1, cur.time + 1)); // q에 값을 넣어줌
                }
            }

            //뒤로 이동할 때
            if(cur.idx-1>=0 && cur.idx-1<=100000){ // 범위 안에 있고
                if(visited[cur.idx-1] == 0 || visited[cur.idx-1] > cur.time+1) { 
                    visited[cur.idx - 1] = cur.time + 1;
                    q.add(new Pos(cur.idx - 1, cur.time + 1));
                }
            }
            
            if(cur.idx*2>=0 && cur.idx*2<=100000){ // 순간이동
                if(visited[cur.idx*2] == 0 || visited[cur.idx*2] > cur.time) {
                    visited[cur.idx*2] = cur.time;
                    q.add(new Pos(cur.idx*2, cur.time));
                }
            }




        }

        System.out.println(visited[k]-1); //처음에 1을 넣어줘서 1을 빼줌



    }
}