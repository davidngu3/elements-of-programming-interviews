import java.util.*;

/* strategy
    reverse postorder traversal, stopping when k elements added to result

*/
class Problem15_3 {
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

        List<Integer> res = findKthLargestElements(head, 5);
        for (int i : res) {
            System.out.println(i);
        }
    }


    public static List<Integer> findKthLargestElements(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        findKthLargestElementsAux(root, k, arr);
        return arr;
    }   
    
    public static void findKthLargestElementsAux(TreeNode n, int k, List<Integer> arr) {
        if (n != null && arr.size() < k) {
            findKthLargestElementsAux(n.right, k, arr); // process right subtree
            if (arr.size() < k) {
                arr.add(n.data); // process root
                findKthLargestElementsAux(n.left, k, arr); // process left
            }
        }
    }
}
