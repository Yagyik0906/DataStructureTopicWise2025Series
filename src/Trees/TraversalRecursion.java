package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TraversalRecursion {// class to know about tree creation as well as traversal
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            data=x;
        }
    }

    public static void main(String[] args) {
        TreeNode root=null;
//        root=buildTree(root);
//        levelOrderTraversal(root);
//        inOrderTraversal(root);
//        System.out.println();
//        preOrderTraversal(root);
//        System.out.println();
//        postOrderTraversal(root);
        root=buildTreeFromLevelOrderTraversal(root);
        System.out.println("Level order Traversal for the current tree");
        levelOrderTraversal(root);
    }

    private static TreeNode buildTreeFromLevelOrderTraversal(TreeNode root) {
        Scanner sc=new Scanner(System.in);
        Queue<TreeNode> q=new LinkedList<>();
        System.out.println("Enter the data for the root node");
        root=new TreeNode(sc.nextInt());
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.peek();
            q.remove();
            System.out.println("Enter the left child for the root = "+temp.data);
            int leftData=sc.nextInt();
            if(leftData!=-1){
                temp.left=new TreeNode(leftData);
                q.add(temp.left);
            }
            System.out.println("Enter the right child for the root = "+temp.data);
            int rightData=sc.nextInt();
            if(rightData!=-1){
                temp.right=new TreeNode(rightData);
                q.add(temp.right);
            }
        }
        return root;
    }

    private static void postOrderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+", ");
    }

    private static void preOrderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+", ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+", ");
        inOrderTraversal(root.right);
    }

    private static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);// separator
        while(!q.isEmpty()){
            TreeNode temp=q.peek();
            q.remove();
            if(temp==null){//purana level complete complete traverse ho chuka hai
                System.out.println();
                if(!q.isEmpty()){// queue still has some child nodes
                    q.add(null);
                }
            }else{
                System.out.print(temp.data+" ,");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
    }

    private static TreeNode buildTree(TreeNode root) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the root value");
        root=new TreeNode(sc.nextInt());
        if(root.data==-1){
            return null;
        }
        System.out.println("Enter the value for left child for node "+root.data);
        root.left=buildTree(root.left);
        System.out.println("Enter the value for right child for node "+root.data);
        root.right=buildTree(root.right);
        return root;
    }


}
