import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2504_괄호의값_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') {
                tmp*= 2;
                stack.add(str.charAt(i));
            } else if(str.charAt(i)=='[') {
                tmp*= 3;
                stack.add(str.charAt(i));
            } else if(str.charAt(i)==')'&&!stack.isEmpty()) {
                if(i-1>=0&&str.charAt(i-1)=='(') {
                    sum+=tmp;
                } else {
                    if(stack.peek()!='(') {
                        sum = 0;
                        break;
                    }
                }
                tmp/=2;
                stack.pop();
            } else if(str.charAt(i)==']'&&!stack.isEmpty()) {
                if(i-1>=0&&str.charAt(i-1)=='[') {
                    sum+=tmp;
                } else {
                    if(stack.peek()!='[') {
                        sum=0;
                        break;
                    }
                }
                tmp/=3;
                stack.pop();
            } else {
                sum = 0;
                break;
            }
        }
        if(!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(sum);
        }



    }
}
