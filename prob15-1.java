class Problem15_1 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5, null, null);
        TreeNode a = new TreeNode(3, null, null);
        TreeNode b = new TreeNode(7, null, null);
        TreeNode c = new TreeNode(1, null, null);
        TreeNode e = new TreeNode(4, null, null);
        TreeNode f = new TreeNode(2, null, null);
        TreeNode d = new TreeNode(9, null, null);

        head.left = a;
        head.right = b;
        a.left = c;
        a.right = e;
        e.left = f;
        b.right = d;

        System.out.println(isValidBST(head));
    }

    public static boolean isValidBST(TreeNode head) {
        return keysInRange(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean keysInRange(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if (Integer.compare(node.data, lower) < 0
        || Integer.compare(node.data, upper) > 0) {
            return false;
        }

        return keysInRange(node.left, lower, node.data) 
            && keysInRange(node.right, node.data, upper);
    }
}
