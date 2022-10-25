package graph;

import java.io.*;
import java.util.*;

public class Main_1991_트리순회 {
    static Map<String, List<String>> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();

            List<String> node = new ArrayList<>();
            node.add(st.nextToken());
            node.add(st.nextToken());

            tree.put(root, node);
        }

        preorder("A");
        sb.append("\n");

        inorder("A");
        sb.append("\n");

        postorder("A");

        System.out.println(sb.toString());

    }

    private static void preorder(String node) {
        if (node.equals("."))
            return;

        sb.append(node);
        preorder(tree.get(node).get(0));
        preorder(tree.get(node).get(1));
    }

    private static void inorder(String node) {
        if (node.equals("."))
            return;

        inorder(tree.get(node).get(0));
        sb.append(node);
        inorder(tree.get(node).get(1));
    }

    private static void postorder(String node) {
        if (node.equals("."))
            return;

        postorder(tree.get(node).get(0));
        postorder(tree.get(node).get(1));
        sb.append(node);
    }

}