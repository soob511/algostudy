import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++) {
            if(i==0) {
                if(turn(sb)) answer++;
                continue;
            };

            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);

            if(turn(sb)) {
                answer++;
            }


        }

        return answer;
    }


    public boolean turn(StringBuilder sb) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<sb.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(sb.charAt(i));
            } else {
                if(sb.charAt(i) == ']') {
                    if(stack.peek() == '['){
                        stack.pop();
                    } else {
                        stack.push(sb.charAt(i));
                    }
                } else if(sb.charAt(i) == '}') {
                    if(stack.peek() == '{'){
                        stack.pop();
                    } else {
                        stack.push(sb.charAt(i));
                    }
                } else if(sb.charAt(i) == ')') {
                    if(stack.peek() == '('){
                        stack.pop();
                    } else {
                        stack.push(sb.charAt(i));
                    }
                } else {
                    stack.push(sb.charAt(i));
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}