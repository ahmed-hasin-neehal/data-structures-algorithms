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
                ptr = stack[top];
                top=top-1;
            }
        }
    }
}