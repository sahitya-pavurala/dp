package leetcode.tree;

import java.util.*;

/**
 Given a n-ary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * */
public class Problem559 {

    public int maxDepth(Node root) {

        if(root == null)
            return 0;

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root, 1));
        int max = 0;

        while (!st.empty()){
            Pair curr = st.pop();
            max = Math.max(max, curr.depth);

            for(Node n : curr.node.children){
                st.push(new Pair(n, curr.depth+1));
            }
        }

        return max;
    }

    class Pair {
        Node node;
        int depth;

        public Pair(Node node, int i) {
            this.node = node;
            this.depth = i;
        }
    }

    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}