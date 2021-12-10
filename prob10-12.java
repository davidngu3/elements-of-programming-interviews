import java.util.*;

class Problem10_12 {
    public static void main(String[] args) {
        ArrayList<Integer> preorder = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 3, 6, 7));
        ArrayList<Integer> inorder = new ArrayList<Integer>(Arrays.asList(4, 2, 5, 1, 6, 3, 7));

        reconstructTree(preorder, inorder);
    }

    public static TreeNode reconstructTree(List<Integer> preorder, List<Integer> inorder) {
        TreeNode node = new TreeNode(0, null, null); 
        Integer val = preorder.get(0);
        node.data = val;

        if (preorder.size() == 1) {
            return node;
        }
        
        int nodesInLeftSubtree = inorder.indexOf(val);

        List<Integer> leftSubtreePreorder = preorder.subList(1, nodesInLeftSubtree + 1); 
        List<Integer> leftSubtreeInorder = inorder.subList(0, nodesInLeftSubtree); 
        
        node.left = reconstructTree(leftSubtreePreorder, leftSubtreeInorder);
        
        List<Integer> rightSubtreePreorder = preorder.subList(nodesInLeftSubtree + 1, preorder.size());
        List<Integer> rightSubtreeInorder = inorder.subList(nodesInLeftSubtree + 1, preorder.size());

        node.right = reconstructTree(rightSubtreePreorder, rightSubtreeInorder);

        return node;
    }
}

