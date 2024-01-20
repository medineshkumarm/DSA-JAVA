import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Level order traversal:");
        printLevelOrder(root);
        // System.out.println(kLevelDown(root, 2, root));
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
    public static void kLevelDown(TreeNode node, int k , TreeNode blocker){
        if(node == null || node == blocker){
            return ;
        }

        if(k ==0 ){
            System.out.print(node.val + " ");
        }

        kLevelDown(node.left, k -1, blocker);
        kLevelDown(node.right, k -1, blocker);
    }

    public static void kDistanceAway(TreeNode root , int target, int k){
        fun(root, target, k);
    }

    public static int fun (TreeNode root , int target, int k){
        if(root == null){
            return -1;
        }
        if(root.val == target){
            kLevelDown(root, k, null);
        }

        int lans = fun(root.left,target,k);
        if(lans != -1){
            kLevelDown(root, k- lans, root.left);
            return lans+1;
        }
        int rans = fun(root.right, target, k);
        if(rans != -1){
            kLevelDown(root, k - rans, root.right);
            return rans + 1;
        }
        return -1;

    }
}
