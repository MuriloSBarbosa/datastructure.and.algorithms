package murilo.barbosa.tree.exercises;

import java.util.HashMap;
import murilo.barbosa.common.leetcode.TreeNode;

public class CreateBinaryTree {

        // not finished
    public static void main(String[] args) {
        // [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]

        var descriptions = new int[][]{
              {20, 15, 1},
              {20, 17, 0},
              {30, 12, 1},
              {30, 20, 0},
        };
        var binaryTree = createBinaryTree(descriptions);
        System.out.println(binaryTree);
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        var root = new TreeNode();
        var map = new HashMap<Integer, Integer[]>();

        for (var description : descriptions) {
            var parent = description[0];
            var child = description[1];
            var isLeft = description[2];

            if (!map.containsKey(parent)) {
                map.put(parent, new Integer[]{0, 0});
            }

            if (isLeft == 1) {
                map.get(parent)[0] = child;
            } else {
                map.get(parent)[1] = child;
            }
        }

        for (var entry : map.entrySet()) {
            var parent = entry.getKey();
            var children = entry.getValue();
            var left = children[0];
            var right = children[1];
            root = findAndAdd(root, parent, left, true);
            root = findAndAdd(root, parent, right, false);
        }

        return root;
    }

    private static TreeNode findAndAdd(TreeNode node, int parent, int child, boolean isLeft) {
        if (node == null) {
            return null;
        }

        if (node.val == 0) {
            node.val = parent;
        }

        if (node.val == parent) {
            if (isLeft) {
                node.left = new TreeNode(child);
            } else {
                node.right = new TreeNode(child);
            }
        } else if (node.val == child) {
            var newRoot = new TreeNode(parent);
            if (isLeft) {
                newRoot.left = node;
            } else {
                newRoot.right = node;
            }
            node = newRoot;
        } else {
            var left = findAndAdd(node.left, parent, child, isLeft);
            var right = findAndAdd(node.right, parent, child, isLeft);

            if (left == null && right == null) {
                return null;
            }
        }

        return node;
    }

}
