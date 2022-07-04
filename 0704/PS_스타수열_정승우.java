class Solution {
    public static int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];
        for (int i = 0; i < a.length; i++) count[a[i]]++;

        for (int i = 0; i < count.length; i++) {
			if(count[i]==0 || count[i]<=answer) continue;
			int tmp = 0;
			
			for (int j = 0; j < a.length-1; j++) {
          
				if(a[j] != i && a[j+1] !=i || a[j]==a[j+1])continue;       
				tmp++;
                j++;
			}
			answer = Math.max(answer, tmp);
		}
        
        return answer*2;
    }
}