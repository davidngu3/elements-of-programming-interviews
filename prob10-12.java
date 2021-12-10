import java.util.*;

class Problem10_12 {
    public static void main(String[] args) {
        ArrayList<Integer> preorder = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 3, 6));
        ArrayList<Integer> inorder = new ArrayList<Integer>(Arrays.asList(4, 2, 5, 1, 6, 3));

        reconstructTree(preorder, inorder);
    }

    public static TreeNode reconstructTree(List<Integer> preorder, List<Integer> inorder) {
        // base case 1: empty subtree
        if (preorder.size() == 0) {
            return null;
        }

        TreeNode node = new TreeNode(0, null, null); 
        Integer val = preorder.get(0);
        node.data = val;

        // base case 2: single node subtree
        if (preorder.size() == 1) {
            return node;
        }
        
        int nodesInLeftSubtree = inorder.indexOf(val);

        // recursively compute left subtree
        List<Integer> leftSubtreePreorder = preorder.subList(1, nodesInLeftSubtree + 1); 
        List<Integer> leftSubtreeInorder = inorder.subList(0, nodesInLeftSubtree); 
        node.left = reconstructTree(leftSubtreePreorder, leftSubtreeInorder);
        
        // recursively compute rightsubtree
        List<Integer> rightSubtreePreorder = preorder.subList(nodesInLeftSubtree + 1, preorder.size());
        List<Integer> rightSubtreeInorder = inorder.subList(nodesInLeftSubtree + 1, preorder.size());
        node.right = reconstructTree(rightSubtreePreorder, rightSubtreeInorder);

        return node;
    }
}

