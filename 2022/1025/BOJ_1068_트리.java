package graph;

import  java.io.*;
import  java.util.*;

public class Main_1068_트리 {
    static int N, D, ans = 0;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        int root = 0;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
                continue;
            }

            nodes[parent].child.add(nodes[i]);
        }
        D = Integer.parseInt(br.readLine());

        if (D != root) {
            deleteNode(root);
            dfs(root);
        }
        System.out.println(ans);
    }

    static void deleteNode(int idx) {
        for(Node child : nodes[idx].child) {
            if(child.idx == D) {
                nodes[idx].child.remove(child);
                return;
            }
            deleteNode(child.idx);
        }
    }

    static void dfs(int idx) {
        if (nodes[idx].child.size() == 0) {
            ans++;
            return;
        }

        for(Node child : nodes[idx].child) {
            dfs(child.idx);
        }
    }

    static class Node {
        int idx;
        ArrayList<Node> child = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }
    }
}