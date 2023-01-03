import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");
        int root = -1;
        for (int node = 0; node < N; node++) {
            int parent = Integer.parseInt(input[node]);

            if (parent == -1) root = node;
            else              tree[parent].add(node);
        }

        
        int deleted = Integer.parseInt(br.readLine());
        System.out.println(leaf(root, deleted, tree));

    }

    static int leaf(int node, int deleted, List<Integer>[] tree){
        if (node == deleted)
            return 0;
        if (tree[node].size()==0)
            return 1;

        int count = 0;
        for(int child:tree[node]){
            count+=leaf(child, deleted, tree);
        }
        return count==0? 1: count;
    }
}
