import java.io.*;
import java.util.*;

public class Main_BJ_10775_공항_김주은2 {
	
	static int G, P;
	static int[] gate, plane;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		
		P = Integer.parseInt(br.readLine());
		
		gate = new int[G+1];
		for(int i=1;i<=G;i++) {
			gate[i]=i;
		}
		
		plane = new int[P];
		for(int i=0;i<P;i++) {
			plane[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt=0;
		for(int i=0;i<P;i++) {
			int dockNum = findDockNum(plane[i]);
			if(dockNum>0) {
				++cnt;
				dock(dockNum,dockNum-1);
			}else {
				break;
			}
		}
		
		System.out.println(cnt);
		
	}

	private static void dock(int a, int b) {
		a = findDockNum(a);
		b = findDockNum(b);
		
		if(a!=b) {
			gate[a]=b;
		}
	}

	private static int findDockNum(int i) {
		if(gate[i]==i) {
			return i;
		}
		return gate[i] = findDockNum(gate[i]);
	}

	

}
