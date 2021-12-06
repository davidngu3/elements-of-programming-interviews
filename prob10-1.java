class Problem10_1 {
    public static void main(String[] args) {
        TreeNodeWithHeight a = new TreeNodeWithHeight(1, null, null);
        TreeNodeWithHeight b = new TreeNodeWithHeight(2, null, null);
        TreeNodeWithHeight c = new TreeNodeWithHeight(3, null, null);
        TreeNodeWithHeight d = new TreeNodeWithHeight(4, null, null);
        TreeNodeWithHeight e = new TreeNodeWithHeight(5, null, null);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        // d.left = f;

        System.out.println(isHeightBalanced(a));
    }

    public static boolean isHeightBalanced(TreeNodeWithHeight head) {
        return processSubtree(head).isHeightBalanced;
    }

    // postorder traversal
    public static TreeNodeWithHeight processSubtree(TreeNodeWithHeight head) {
        // base case
        if (head == null) {
            return new TreeNodeWithHeight(null, null, null, true, -1);
        }

        // process left and right subtrees        
        TreeNodeWithHeight leftSubtree = processSubtree(head.left);
        if (!leftSubtree.isHeightBalanced) {
            return leftSubtree;
        }

        TreeNodeWithHeight rightSubtree = processSubtree(head.right);
        if (!rightSubtree.isHeightBalanced) {
            return rightSubtree;
        }

        // process current node
        head.isHeightBalanced = (Math.abs(leftSubtree.height - rightSubtree.height) > 1) ? false : true;
        head.height = Math.max(leftSubtree.height, rightSubtree.height) + 1;
        
        return head;
    }
}

class TreeNodeWithHeight {
    Integer data;
    TreeNodeWithHeight left = null;
    TreeNodeWithHeight right = null;
    
    // additional data stored for this problem
    boolean isHeightBalanced;
    int height;

    public TreeNodeWithHeight(Integer data, TreeNodeWithHeight left, TreeNodeWithHeight right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNodeWithHeight(Integer data, TreeNodeWithHeight left, TreeNodeWithHeight right, boolean isHeightBalanced, int height) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.isHeightBalanced = isHeightBalanced;
        this.height = height;
    }
}
