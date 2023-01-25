import java.util.ArrayList;
import java.util.Scanner;

public class Main_BJ_1062_가르침_김주은 {
	
	static int N, K, count = 0;
	static ArrayList<Character> arr;
	static String[] slist;
	static int max_read=0;
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		int[] alphabet = new int[26];

		if (K < 5) {
			System.out.println(0);
			return;
		}
		
		arr = new ArrayList<>();
		
		slist = new String[N];

		for (int i = 0; i < N; i++) {
			slist[i] = sc.next();
			int len = slist[i].length();
			
			for (int j = 0; j < len; j++) {
				char val = slist[i].charAt(j);
				if(val!='a' && val!='c' && val!='i' && val!='n'&& val!='t') {
					if(alphabet[val-'a']==0) {
						++count;
						arr.add(val);
					}
					alphabet[val-'a']+=1;
				}
			}
			
		}
		
		if(count<=K-5) {
			System.out.println(N);
			return;
		}
		
		select(0, 0, new char[K-5]);
		
		System.out.println(max_read);
	}

	private static void select(int cnt, int idx, char[] sel) {

		if(cnt==K-5) {
			int words = read(sel);
			max_read = Math.max(max_read, words);
			return;
		}
		
		for(int i=idx;i<arr.size();i++) {
			sel[cnt]=arr.get(i);
			select(cnt+1, i+1, sel);
		}
	}

	private static int read(char[] sel) {
		int word_cnt=0;
		for(int i=0;i<N;i++) {
			String s = slist[i].substring(4,slist[i].length()-4);
			int read_cnt=0;
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(c=='a'|| c=='c'|| c=='i'||c=='n'||c=='t') {
					++read_cnt;
				} else {
					for(int t=0;t<sel.length;t++) {
						if(sel[t]==c) {
							++read_cnt;
							break;
						}
					}
				}
				
			}
			if(read_cnt==s.length()) {
				++word_cnt;
			}
		}
		return word_cnt;
	}

}
