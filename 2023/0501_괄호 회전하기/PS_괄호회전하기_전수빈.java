import java.io.*;
import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(String s) {
        check(s);
        for(int i=1;i<s.length();i++){
            String ns = "";
            for(int j=1;j<s.length();j++){
                ns+=s.charAt(j);
            }
            ns+=s.charAt(0);
            s= ns;
            check(s);
        }
        return answer;
    }
    public void check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(c=='}'&&stack.peek()=='{'){
                    stack.pop();
                }else if(c==']'&&stack.peek()=='['){
                    stack.pop();
                }else if(c==')'&&stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        if(stack.isEmpty()){
           answer++;
        }
    }
}
