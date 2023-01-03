package day0215;
import java.util.*;

// 스택 수열
public class BOJ_1874_이길상 {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Character> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int num = 1;
        while(N-->0){
        	// 수열 입력
            int next = sc.nextInt();
            
            // next를 pop 할수 있을 때까지 push
            while(num<=next){
                stack.push(num++);
                // push하면 + 기록
                result.add('+');
            }
            
            // 원하는 숫자를 pop할 수 있을 때
            if(stack.peek() == next){
                stack.pop();
                // pop하면 - 기록
                result.add('-');
            }
            
            // pop이 불가능할 경우 중단
            else{
                System.out.println("NO");
                return;
            }
        }
        
        // 중단이 없었을 경우 기록 출력
        for(char c: result)
            System.out.println(c);
        
    }

}
