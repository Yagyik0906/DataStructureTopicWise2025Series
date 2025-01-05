package Trees;

import java.util.Scanner;

public class DiameterOfABinaryTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
        }
    }
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        TreeNode root =null;
        root=buildTree(root);
        int count=diameterOfABinaryTree(root);
        System.out.println("Diameter of the Tree is = "+count);
        Pair count1=diameterOfABinaryTreeUsingPair(root);
        System.out.println("Diameter of the Tree is = "+count1.first);
    }

    private static Pair diameterOfABinaryTreeUsingPair(TreeNode root) {//Time Complexity=O(n)
        if(root == null){
            return new Pair(0, 0);
        }
        Pair left=diameterOfABinaryTreeUsingPair(root.left);
        Pair right=diameterOfABinaryTreeUsingPair(root.right);

        int op1= left.first;
        int op2= right.first;
        int op3= left.second+right.second+1;

        Pair ans=new Pair(0,0);
        ans.first=Math.max(op1,Math.max(op2,op3));
        ans.second=Math.max(left.second, right.second)+1;
        return ans;
    }

    private static int diameterOfABinaryTree(TreeNode root) {//Time Complexity=o(n2)
        if(root == null){
            return 0;
        }
        int op1=diameterOfABinaryTree(root.left);
        int op2=diameterOfABinaryTree(root.right);
        int op3=heightOfBinaryTree(root.left)+heightOfBinaryTree(root.right)+1;

        return Math.max(op1,Math.max(op2,op3));
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
