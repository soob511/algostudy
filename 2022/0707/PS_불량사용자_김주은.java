import java.util.*;

class Solution {
    
    static int answer = 0;
    
    static String[] user, banned;
    static int N, M;
    
    static String[] arr;
	static String[] seq;
	static boolean[] selected;
	static boolean canAdd;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        user=user_id;
        N = user.length;
        banned=banned_id;
        M = banned.length;
        
		//1. user_id중 banned_id로 구성될 수 있는 조합 구하기
		arr = new String[M];
		comb(0,0);
        
        return answer;
    }
    
    static void comb(int start, int cnt) {
		
		if(cnt==M) {
            //2. 하나의 조합에 대해 순열을 생성하여 불량 사용자 아이디 목록이 될 수 있는지 확인
            //될 수 있으면 ++answer;
			seq = new String[M];
			selected = new boolean[M];
			canAdd=false;
			perm(0);
			if(canAdd) ++answer;
			return;
		}
		
		for(int i=start;i<N;i++) {
			arr[cnt]=user[i];
			comb(i+1, cnt+1);
		}
		
	}

	static void perm(int cnt) {
		if(cnt==M) {
			if(check()) { //문자열 비교
				canAdd=true;
			} 
			return;
		}
		
		if(canAdd) return;
		
		for(int i=0;i<M;i++) {
			if(selected[i]) continue;
			
			selected[i]=true;
			seq[cnt]=arr[i];
			perm(cnt+1);
			selected[i]=false;
		}
	}

	static boolean check() {
		for(int i=0;i<M;i++) {
			if(seq[i].length()!=banned[i].length()) {
				return false;
			} else {
				for(int c=0;c<seq[i].length();c++) {
					if(seq[i].charAt(c)==banned[i].charAt(c) || banned[i].charAt(c)=='*') {
						continue;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}