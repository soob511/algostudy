import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int i, Node left, Node right) {
			super();
			this.val = i;
			this.left = left;
			this.right = right;
		}
		
	}
	
	static Node root;
	static Node[] tree;
	static StringBuilder sb;
	static char A = 'A';
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new Node[N];
		
		for(int i=0;i<N;i++) {
			tree[i] = new Node(A+i,null,null);
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char[] parent = st.nextToken().toCharArray();
			char[] left = st.nextToken().toCharArray();
			char[] right = st.nextToken().toCharArray();
			
			if(left[0]!='.') {
				tree[parent[0]-A].left = tree[left[0]-A];
			}
			if(right[0]!='.') {
				tree[parent[0]-A ].right = tree[right[0]-A];
			}
		}
		
		//전위
		preorder(0);
		sb.append("\n");
		
		//중위
		inorder(0);
		sb.append("\n");
		
		//후위
		postorder(0);
		sb.append("\n");
		
		System.out.println(sb);
	}

	private static void preorder(int i) {
		if(tree[i]==null) {
			return;
		}
		sb.append((char)tree[i].val);
		if(tree[i].left != null) {
			preorder(tree[i].left.val-A);
		}
		if(tree[i].right != null) {
			preorder(tree[i].right.val-A);
		}
	}
	
	private static void inorder(int i) {
		if(tree[i]==null) {
			return;
		}
		if(tree[i].left != null) {
			inorder(tree[i].left.val-A);
		}
		sb.append((char)tree[i].val);
		if(tree[i].right != null) {
			inorder(tree[i].right.val-A);
		}
	}

	private static void postorder(int i) {
		if(tree[i]==null) {
			return;
		}
		if(tree[i].left != null) {
			postorder(tree[i].left.val-A);
		}
		if(tree[i].right != null) {
			postorder(tree[i].right.val-A);
		}
		sb.append((char)tree[i].val);
	}
}
