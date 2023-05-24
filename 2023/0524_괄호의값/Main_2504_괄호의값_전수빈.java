package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack  = new Stack<Character>();

        int num = 1;
        int sum = 0;
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='['){
                stack.push(c);
                num *= (c == '(') ? 2:3;
            }else if(c==')'){
                if(stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                }
                if(s.charAt(i-1)=='('){
                    sum +=num;
                }
                stack.pop();
                num/=2;
            }else if(c==']'){
                if (stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                }
                if(s.charAt(i-1)=='[') {
                    sum += num;
                }
                stack.pop();
                num/=3;
            }
        }
        if(stack.isEmpty()){
            System.out.println(sum);
        }else{
            System.out.println("0");
        }
    }
}
