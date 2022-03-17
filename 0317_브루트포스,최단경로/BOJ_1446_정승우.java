package com.ssafy.day0317;
import java.io.*;
import java.util.*;


public class BOJ_1446_정승우 {

    static int[] move; // 위치가 n일 때의 최소 이동거리 
    static HashMap<Integer, List<int[]>> info; // key : 도착지점, value : (출발지점,이동거리)리스트 형식의 지름길 정보

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //지름길 수
        int N = Integer.parseInt(st.nextToken());
        
        //고속도로 길이
        int D = Integer.parseInt(st.nextToken());

        
        info = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // 지름길 시작위치
            int start = Integer.parseInt(st.nextToken());
            // 지름길 도착위치
            int end = Integer.parseInt(st.nextToken());
            // 지름길의 길이
            int distance = Integer.parseInt(st.nextToken());

            // 키값에 이미 키가 있는지 확인
            if (!info.containsKey(end)) {
                
            	// to 키값이 없다면 키값 to와 arraylist추가
            	info.put(end, new ArrayList<>());
            }
            //지름길 도착위치에 해당하는 arraylist에 지름길 시작위치와 길이를 int형 배열에 저장하여 값을 넣음
            info.get(end).add(new int[]{start,distance});
        }

        move = new int[D+1]; // move 초기화

        for(int i = 1; i<=D; i++){  // 위치 1부터 시작하여 D위치까지 최소 이동거리를 채움
            int d = move[i-1]+1; // 기본값 : (현재 위치-1)에서의 최소 이동거리 + 1   // 직전의 값에서 +1해준값 

            if (info.containsKey(i)) {
                for(int[] pos : info.get(i)){
                    // 도착위치가 i인 지름길을 조회해서 최소 이동거리 갱신
                    d = Math.min(d, move[pos[0]]+pos[1]);
                }
            }

            move[i] = d;            
        }

        System.out.println(move[D]);
    }
}