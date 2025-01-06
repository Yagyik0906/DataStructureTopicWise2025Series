package Trees;

import java.util.Scanner;

public class BuildTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
        }
    }
     static TreeNode buildTree(TreeNode root) {
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
