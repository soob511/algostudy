import java.util.ArrayDeque;
import java.util.Scanner;

public class Main_BJ_12852_1로만들기2_김주은 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		int[] path = new int[N+1];
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		int cnt=1;
		
		int[] arr = new int[cnt+1];
		arr[0]=N;
		arr[1]=N;
		q.add(arr);
		
		while(true) {
			int size = q.size();
			
			while(size-->0) {
				
				int[] v = q.poll();
				
				if(v[0]==1) {
					sb.append(cnt-1).append("\n");
					for(int i=1;i<cnt+1;i++) {
						sb.append(v[i]).append(" ");
					}
					sb.setLength(sb.length()-1);
					System.out.println(sb);
					return;
				}
				
				if(v[0]-1>=1) {
					int[] narr = new int[cnt+2];
					narr[0]=v[0]-1;
					System.arraycopy(v, 1, narr, 1, cnt);
					narr[cnt+1]=narr[0];
					q.add(narr);
				}
				
				if(v[0]%2==0 && v[0]/2>=1) {
					int[] narr = new int[cnt+2];
					narr[0]=v[0]/2;
					System.arraycopy(v, 1, narr, 1, cnt);
					narr[cnt+1]=narr[0];
					q.add(narr);
				}
				
				if(v[0]%3==0 && v[0]/3>=1) {
					int[] narr = new int[cnt+2];
					narr[0]=v[0]/3;
					System.arraycopy(v, 1, narr, 1, cnt);
					narr[cnt+1]=narr[0];
					q.add(narr);
				}
				
			}
			
			cnt+=1;
		}
	}

}
