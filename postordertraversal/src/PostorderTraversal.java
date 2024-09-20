import java.util.Arrays;

class TreeNode {
    int info;
    TreeNode left, right;

    public TreeNode(int info) {
        this.info = info;
        left = null;
        right = null;
    }
}

class PostorderTraversal {
    void postorderTraverse(TreeNode root) {
        if (root == null)
            return;

        TreeNode[] stack = new TreeNode[100]; // Assuming maximum 100 nodes in the tree
        TreeNode[] output = new TreeNode[100]; // Stack to store the output
        int top = -1;
        int outputTop = -1;

        stack[++top] = root;

        while (top >= 0) {
            TreeNode ptr = stack[top--];
            output[++outputTop] = ptr;

            // Push left child first
            if (ptr.left != null) {
                stack[++top] = ptr.left;
            }

            // Push right child next
            if (ptr.right != null) {
                stack[++top] = ptr.right;
            }
        }

        // Print all elements in the output stack
        while (outputTop >= 0) {
            System.out.print(output[outputTop--].info + " ");
        }
    }
    public static void main(String[] args) {
        // Sample usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostorderTraversal traversal = new PostorderTraversal();
        traversal.postorderTraverse(root);
    }
}
