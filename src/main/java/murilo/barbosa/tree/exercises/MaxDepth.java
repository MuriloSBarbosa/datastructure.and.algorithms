package murilo.barbosa.tree.exercises;

import murilo.barbosa.common.leetcode.TreeNode;

public class MaxDepth {

    int count = 0;

    public int maxDepth(TreeNode root) {
        this.findNodes(root, 0);
        return this.count;
    }

    public void findNodes(TreeNode node, int children) {
        if (node == null) {
            return;
        }

        this.count = Math.max(this.count, ++children);

        this.findNodes(node.right, children);
        this.findNodes(node.left, children);
    }


//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        int l = maxDepth(root.left) + 1;
//        int r = maxDepth(root.right) + 1;
//        return Math.max(l,r);
//    }
}
