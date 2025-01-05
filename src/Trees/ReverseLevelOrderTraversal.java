package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
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
        root=buildTreeLevelOrderTraversal(root);
        reverseLevelOrderTraversal(root);
        reverseLevelOrderTraversalStack(root);
        reverseLevelOrderTraversalHashMap(root);
    }

    private static void reverseLevelOrderTraversalHashMap(TreeNode root) {
        //todo
    }

    private static void reverseLevelOrderTraversalStack(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        Stack<TreeNode> st=new Stack<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.peek();
            q.remove();
            st.add(temp);
            if(temp.right!=null){
                q.add(temp.right);
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
        }
        while(!st.isEmpty()){
            System.out.println(st.pop().data+", ");
        }
    }

    private static void reverseLevelOrderTraversal(TreeNode root) {
        int height=treeHeight(root);
        for(int i=height;i>=1;i--){
            printGivenLevel(root,1,i);
            System.out.println();
        }
    }

    private static void printGivenLevel(TreeNode root, int givLevel, int reqLevel) {
        if(root==null){
            return;
        }
        if(givLevel==reqLevel){
            System.out.print(root.data+", ");
        }
        else if(givLevel<reqLevel){
            printGivenLevel(root.left,givLevel+1,reqLevel);
            printGivenLevel(root.right,givLevel+1,reqLevel);
        }
    }

    private static int treeHeight(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=treeHeight(root.left);
        int rightHeight=treeHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    private static TreeNode buildTreeLevelOrderTraversal(TreeNode root) {
        Scanner sc=new Scanner(System.in);
        Queue<TreeNode> q=new LinkedList<>();
        System.out.println("Enter the root Node = ");
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
}