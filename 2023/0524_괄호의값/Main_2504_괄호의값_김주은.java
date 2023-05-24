import java.util.*;

public class Main_BJ_2504_괄호의값_김주은 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> stack = new Stack();
		
		int depth=-1;
		int[] val = new int[s.length()];
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(stack.isEmpty() && (c==']' || c==')')) {
				System.out.println(0);
				return;
			}
			
			if(c=='(' || c=='[') {
				depth+=1;
				stack.push(c);
			}else if(c==')') {
				if(stack.peek()=='(') {
					if(val[depth+1]>0) {
						val[depth]+=(val[depth+1]*2);
						val[depth+1]=0;
					} else {
						val[depth]+=2;
					}
					stack.pop();
					depth-=1;
				} else {
					System.out.println(0);
					return;
				}
			}else if(c==']') {
				if(stack.peek()=='[') {
					if(val[depth+1]>0) {
						val[depth]+=(val[depth+1]*3);
						val[depth+1]=0;
					} else {
						val[depth]+=3;
					}
					stack.pop();
					depth-=1;
				}else {
					System.out.println(0);
					return;
				}
			}
			
		}
		
		System.out.println(val[0]);
	}

}
