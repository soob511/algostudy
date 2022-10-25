import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_정승우 {

    static class Node {
    char data;
    Node left,right;

    public Node(char data) {
        this.data = data;
    }


    public String toString() {
        return data + "";
    }
}

    private static int N;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Node[] nodeArr = new Node[N];

        char name = 'A';

        for( int i=0; i<N; i++) {
            nodeArr[i] = new Node(name++);

        }

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = st.nextToken().charAt(0) - 'A';
            System.out.println(idx);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            //자식 정보를 입력
            nodeArr[idx].left = left == '.' ? null : nodeArr[left - 'A'];
            nodeArr[idx].right = right == '.' ? null : nodeArr[right - 'A'];


        }
        System.out.println(preorder(nodeArr[0]));
        System.out.println(inorder(nodeArr[0]));
        System.out.println(postorder(nodeArr[0]));

}

    private static String preorder(Node node) {
        //반환할 문자열
        String result = "";

        //전위순회이므로 현재 노드 데이터부터 연결
        result += node.data;

        //왼쪽 자식 노드가 있으면 연결
        if (node.left != null) {
            result += preorder(node.left);
        }

        //오른쪽 자식 노드가 있으면 연결
        if (node.right != null) {
            result += preorder(node.right);
        }
        return result;
    }

    //중위
    private static String inorder(Node node) {
        //반환할 문자열
        String result = "";

        //왼쪽 자식 노드가 있으면 먼저 연결
        if (node.left != null) {
            result += preorder(node.left);
        }

        //현재 노드 연결
        result += node.data;

        //오른쪽 노드 연결
        if(node.right != null)
        {
            result += inorder(node.right);
        }

        return result;


    }

    private static String postorder(Node node) {

        //반환할 문자열
        String result="";

        //왼쪽 자식이 있음녀 먼저 연결
        if (node.left != null) {
            result += postorder(node.left);
        }

        //오른쪽 자식이 있으면 이어서 연결
        if(node.right != null) {
            result += postorder(node.right);
        }

        //마지막에 현재 노드 연결
        result += node.data;

        return result;
    }
}