import java.util.*;

class Solution {
    
    static int length;
    static int answer;
    
    public int solution(int[] a) {
        
        answer = a.length;
        length = a.length;
        
        if(length<=1){
            return 0;
        }
        
        int len = 0;
        
        if(length%2==1){
            len=1;
            //조합으로 제거할 인덱스 탐색
            search(a, 0, 0, len, new boolean[length]); //a배열, 선택한 인덱스, 선택한 갯수, 최대 갯수, 방문 체크 배열
            if(answer<a.length){
                return answer;
            }
        }
        for(int i=len;i<=length;i+=2){
            search(a, 0, 0, i, new boolean[length]);
            if(answer<a.length){
                return answer;
            }
        }
        
        return 0;
    }
    
    static void search(int[] a, int idx, int cnt, int len, boolean[] v){
        
        if(cnt==len){
            if(check(a, v, length-len)){
                answer = length-len;
            }
            return;
        }
        
        for(int i=idx;i<length;i++){
            v[i]=true;
            search(a,i+1, cnt+1, len, v);
            v[i]=false;
        }
        
    }
    
    static boolean check(int[] a, boolean[] v, int cnt){
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int xCnt = 0;
        int start=-1;
        int end=-1;
        
        for(int i=0;i<length;i++){
            
            if(v[i]) continue;
            
            if(start<0){
                start=a[i];
            } else if(end<0){
                end=a[i];
            }
            
            if(start>=0 && end>=0 && start!=end){
                ++xCnt;
                if(map.containsKey(start)){
                    map.put(start, map.get(start)+1);
                } else{
                    map.put(start, 1);
                }
                
                if(map.containsKey(end)){
                    map.put(end, map.get(end)+1);
                } else{
                    map.put(end, 1);
                }
                start=-1;
                end=-1;
            }
        }
        
        //map 순환하며 스타수열인지 확인(교집합이 하나 이상인지 확인)
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(xCnt == entry.getValue()){
                return true;
            }
        }
        return false;
        
    }
}