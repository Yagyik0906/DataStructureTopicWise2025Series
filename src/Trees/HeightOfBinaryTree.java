package Trees;

import java.util.Scanner;

public class HeightOfBinaryTree  {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        TreeNode root =null;
        root=buildTree(root);
        int count= heightOfBinaryTree(root);
        System.out.println("Height of the Tree is = "+count);
    }

    private static int heightOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static TreeNode buildTree(TreeNode root) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the root Node");
        root=new TreeNode(sc.nextInt());
        if(root.data==-1){
            return null;
        }
        System.out.println("Enter the left Node for root : "+root.data);
        root.left=buildTree(root.left);
        System.out.println("Enter the right Node for root : "+root.data);
        root.right=buildTree(root.right);
        return root;
    }
}
