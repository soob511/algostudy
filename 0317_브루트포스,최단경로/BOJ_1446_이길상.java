package day0317;
import java.io.*;
import java.util.*;

public class BOJ_1446_이길상 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        // 입력
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int D = Integer.parseInt(line[1]);
        
        // 지름길 정보
        int[][] info = new int[N][3];
        
        // 이동거리 기록지점 리스트
        List<Integer> road = new ArrayList<>();
        road.add(D);
        
        for (int n = 0; n < N; n++) {
        	line = br.readLine().split(" ");
        	info[n][0] = Integer.parseInt(line[0]);
        	info[n][1] = Integer.parseInt(line[1]);
        	info[n][2] = Integer.parseInt(line[2]);
        	
        	if(!road.contains(info[n][0])) road.add(info[n][0]);
        	if(!road.contains(info[n][1])) road.add(info[n][1]);
		}
        
        // 기록지점 별 최단 이동거리(시간)
        int[] time = new int[road.size()];
        Arrays.fill(time, Integer.MAX_VALUE);
        
        // 정렬
        Collections.sort(road);
        Arrays.sort(info, (a, b) -> (a[0] == b[0]) ? a[1]-b[1] : a[0]-b[0]);
        
        // 가장 앞 지점 초기화
        time[0] = road.get(0);
        
        // 연산
        for (int i = 0; i < road.size() - 1; i++) {
			int r = road.get(i);
			
			// 현 지점에서 이용할 수 있는 지름길을 사용하여 최단거리 갱신
			for (int j = 0; j < info.length; j++) {
				if(r == info[j][0]) {
					int k =  road.indexOf(info[j][1]);
					time[k] = Math.min(time[k], time[i] + info[j][2]);
				}
			}
			
			// 다음 지점 최단거리 갱신
			time[i+1] = Math.min(time[i+1], time[i] + road.get(i+1) - r);
		}
        
        // 출력
        System.out.println(time[road.indexOf(D)]);
        
    }

}
