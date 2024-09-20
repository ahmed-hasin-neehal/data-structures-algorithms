class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class InorderTraversal {
    private static final int MAX_SIZE = 100;  // Adjust size as needed

    public static void inorderTraverse(TreeNode root) {
        TreeNode[] stack = new TreeNode[MAX_SIZE];
        int top = 0;  // Top of stack
        TreeNode ptr = root;

        // Set Stack[0] = NULL equivalent in Java as initializing an empty stack with top = 0
        stack[top] = null;

        // Repeat while Ptr ≠ NULL
        while (ptr != null) {
            // Set Stack[Top] = Ptr and Top = Top + 1
            stack[top] = ptr;
            top++;

            // Set Ptr = Ptr->Left
            ptr = ptr.left;
        }

        // Set Ptr = Stack[Top] and Top = Top - 1
        if (top > 0) {
            top--;
            ptr = stack[top];
        }

        // Repeat steps 5 to 7 while Ptr ≠ NULL
        while (ptr != null) {
            // Process Ptr->Info
            System.out.print(ptr.val + " ");

            // If Ptr->Right ≠ NULL then set Ptr = Ptr->Right and go to step 2
            if (ptr.right != null) {
                ptr = ptr.right;

                // Repeat step 2
                while (ptr != null) {
                    stack[top] = ptr;
                    top++;
                    ptr = ptr.left;
                }

                if (top > 0) {
                    top--;
                    ptr = stack[top];
                }
            } else {
                // Set Ptr = Stack[Top] and Top = Top - 1
                if (top > 0) {
                    top--;
                    ptr = stack[top];
                } else {
                    ptr = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        inorderTraverse(root);
    }
}
