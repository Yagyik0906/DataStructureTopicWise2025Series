package Trees;

import java.util.Scanner;
import java.util.Stack;


public class TraversalIteration {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            data=x;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args) {
        TreeNode root=null;
        root=buildTree(root);
        inOrderTraversal(root);
        preOrderTraversal(root);
    }

    private static void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
    }

    private static void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the node
            current = stack.pop();
            System.out.print(current.data + " ");

            // Traverse the right subtree
            current = current.right;
        }
    }

    private static TreeNode buildTree(TreeNode root) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data for the root node");
        root=new TreeNode(sc.nextInt());
        if(root.data==-1){
            return null;
        }
        System.out.println("Enter the left child for the node = "+ root.data);
        root.left=buildTree(root.left);
        System.out.println("Enter the right child for the node = "+root.data);
        root.right=buildTree(root.right);
        return root;
    }
}
