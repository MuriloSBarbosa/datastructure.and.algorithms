package murilo.barbosa.tree;

import java.util.Objects;
import murilo.barbosa.common.TreeNode;

public class BinarySearchTree {

    private TreeNode<Integer> root;

    public TreeNode<Integer> insert(Integer value) {
        return this.insertValue(this.root, value);
    }

    private TreeNode<Integer> insertValue(TreeNode<Integer> node, Integer value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (value < node.value) {
            node.left = insertValue(node.left, value);
        } else if (value > node.value) {
            node.right = insertValue(node.right, value);
        }

        return node;
        // O(log n)
    }

    public TreeNode<Integer> lookup(Integer value) {
        return this.find(this.root, value);
    }

    private TreeNode<Integer> find(TreeNode<Integer> node, Integer value) {
        if (node == null) {
            return null;
        }
        if (Objects.equals(value, node.value)) {
            return node;
        }
        if (value > node.value) {
            return this.find(node.right, value);
        } else {
            return this.find(node.left, value);
        }
    }

    private void remove(Integer value) {
        this.root = this.removeValue(this.root, value);
    }

    private TreeNode<Integer> removeValue(TreeNode<Integer> node, Integer value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = this.removeValue(node.left, value);
        } else if (value > node.value) {
            node.right = this.removeValue(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            TreeNode<Integer> temp = this.findMin(node.right);
            node.value = temp.value;
            node.right = this.removeValue(node.right, temp.value);
        }

        return node;
    }

    private TreeNode<Integer> findMin(TreeNode<Integer> node) {
        if (node.left == null) {
            return node;
        }
        return this.findMin(node.left);
    }


    // toString method
    @Override
    public String toString() {
        if (root == null) {
            return "Tree is empty";
        }

        var sb = new StringBuilder();
        this.traverseInOrder(this.root, sb);
        return sb.toString();
    }

    private void traverseInOrder(TreeNode<Integer> node, StringBuilder sb) {
        if (node.left != null) {
            this.traverseInOrder(node.left, sb);
        }
        sb.append(node.value).append(", ");
        if (node.right != null) {
            this.traverseInOrder(node.right, sb);
        }
    }

    public static void main(String[] args) {

        var tree = new BinarySearchTree();
        tree.root = new TreeNode<>(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        tree.remove(15);

        System.out.println(tree);

        System.out.println(tree.lookup(10));
        System.out.println(tree.lookup(13));

    }

}
