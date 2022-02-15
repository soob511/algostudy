package day0215;
import java.util.*;

// 프린터 큐
public class BOJ_1966_이길상 {
	
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스
        int T = sc.nextInt();
        
        while(T-->0) {
        	// 문서 수, 대상 문서
            int N = sc.nextInt(), K = sc.nextInt();
            
            // 중요도 카운팅
            int[] pri = new int[10];
            // 문서 중요도 배열
            int[] doc = new int[N];
            
            for (int n = 0; n < N; n++) {
            	// 중요도 입력
            	doc[n] = sc.nextInt();
            	// 중요도 카운팅
				pri[doc[n]]++;
			}
            
            // 프린트 순번
            int print = 0;
            // 현재 가장 높은 중요도
            int maxP = 9;
            while(pri[maxP] == 0) maxP--;
            
            // 프린트 진행
            int idx = 0;
            while(doc[K] != 0) {
            	// 중요도가 가장 높을 경우
            	if(doc[idx] == maxP) {
            		// 프린트 처리
            		doc[idx] = 0;
            		print++;
            		
            		// 카운팅 감소
            		pri[maxP]--;
                    while(maxP>0 && pri[maxP]==0) maxP--;
            	}
            	// 다음 문서
            	idx = (idx+1) % N;
            }
            
            // 출력
            System.out.println(print);
        }
        
    }

}
