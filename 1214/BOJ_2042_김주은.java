import java.io.*;
import java.util.*;

public class Main_BJ_2042_구간합구하기_김주은 {
	
	static int N,M,K;
	static long[] input, tree;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new long[N+1]; // 값 입력 배열
		
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
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) { //숫자 변경
				updateTree(1,1,N,b,c-input[b]);
			} else if(a==2) { //구간 합 구하기
				sb.append(query(1,1,N,b,c)).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

	private static long query(int node, long l, long r, long ql, long qr) {
		if(qr<l || r<ql) {
			return 0;
		}
		
		if(ql<=l && r<=qr) {
			return tree[node];
		}
		
		long mid = (l+r)/2;
		
		return query(2*node, l, mid, ql,qr) + query(2*node+1,mid+1,r,ql,qr);
	}

	private static long updateTree(int node, long l, long r, long idx, long diff) {
		if(idx<l || r<idx) {
			return tree[node];
		}
		
		if(l==r) {
			return tree[node]+=diff;
		}

		long mid = (l+r)/2;
		
		return tree[node] = updateTree(2*node,l,mid,idx,diff) + updateTree(2*node+1,mid+1,r,idx,diff);
	}

	private static long createTree(int node, long l, long r) {
		if(l==r) {
			return tree[node] = input[l];
		}
		
		long mid = (l+r)/2;
		
		return tree[node] = createTree(2*node, l, mid) + createTree(2*node+1,mid+1,r);
	}

}
