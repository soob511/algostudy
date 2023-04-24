class Solution {
    static int zero=0;
    static int one = 0;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        dfs(arr,0,arr.length,0,arr.length);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
    public void dfs(int[][] arr,int sx,int ex,int sy,int ey){
        int num = arr[sx][sy];
        boolean check = true;
        all:
        for(int i=sx;i<ex;i++){
            for(int j=sy;j<ey;j++){
                if(arr[i][j]!=num){
                    check = false;
                    break all;
                }
            }
        }
        
        if(check){
            if(num==0){
               zero++;
            }else{
                one++;
            }
            return;
        }
        
         dfs(arr,sx,(sx+ex)/2,sy,(sy+ey)/2);
         dfs(arr,sx,(sx+ex)/2,(sy+ey)/2,ey);
         dfs(arr,(sx+ex)/2,ex,sy,(sy+ey)/2);
         dfs(arr,(sx+ex)/2,ex,(sy+ey)/2,ey);
        
    }
}