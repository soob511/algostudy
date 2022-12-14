import java.io.*;
import java.util.*;

public class Main_BJ_2042_구간합구하기_김주은 {

	static long[] input, tree;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		input = new long[N+1]; // 값 입력 배열
		
//		int k = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
//		int size = (int) Math.pow(2,k);
//		
//		tree = new long[size]; //세그먼트 트리 배열
		
		int size = 1;
		while(size<N) {
			size*=2;
		}
		
		tree = new long[size*2]; //세그먼트 트리 배열

		for(int i=1;i<=N;i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		
		createTree(1,1,N);
		
		for(int km=1;km<=K+M;km++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) { //숫자 변경
				long diff = c - input[b];
				input[b]=c;
				updateTree(1,1,N,b,diff);
			} else if(a==2) { //구간 합 구하기
				sb.append(query(1,1,N,b,(int)c)).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

	private static long query(int node, int l, int r, int ql, int qr) {
		if(qr<l || r<ql) {
			return 0;
		}
		
		if(ql<=l && r<=qr) {
			return tree[node];
		}
		
		int mid = (l+r)/2;
		
		return query(2*node, l, mid, ql,qr) + query(2*node+1,mid+1,r,ql,qr);
	}

	private static void updateTree(int node, int l, int r, int idx, long diff) {
		
		if(idx<l || r<idx) {
			return;
		}
		
		tree[node]+=diff;
		
		if(l==r) {
			return;
		}

		int mid = (l+r)/2;
		
		updateTree(2*node,l,mid,idx,diff);
		updateTree(2*node+1,mid+1,r,idx,diff);
	}

	private static long createTree(int node, int l, int r) {
		if(l==r) {
			return tree[node] = input[l];
		}
		
		int mid = (l+r)/2;
		
		return tree[node] = createTree(2*node, l, mid) + createTree(2*node+1,mid+1,r);
	}

}
