class TreeNode {
    char info;
    TreeNode left, right;

    public TreeNode(char info) {
        this.info = info;
        left = null;
        right = null;
    }
}

class PreorderTraversal {
    void preorderTraverse(TreeNode root) {
        if (root == null)
            return;

        TreeNode[] stack = new TreeNode[100];
        stack[0] = null;
        int top = 1;
        TreeNode ptr = root;

        while (ptr != null) {
            System.out.print(ptr.info + " ");

            if (ptr.right != null) {
                stack[top] = ptr.right;
                top=top+1;
            }

            if (ptr.left != null) {
                ptr = ptr.left;
            } else {
                ptr = stack[top-1];
                top=top-1;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');

        PreorderTraversal traversal = new PreorderTraversal();
        traversal.preorderTraverse(root);
    }
}