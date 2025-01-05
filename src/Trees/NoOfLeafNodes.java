package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NoOfLeafNodes {
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
        root=buildTree(root);
        countNoOfLeafs(root);
    }

    private static void countNoOfLeafs(TreeNode root) {
        int cnt=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode temp=q.peek();
            q.remove();
            if(temp.left==null && temp.right==null){
                cnt++;
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        System.out.println("No of Leaf Nodes = "+cnt);
    }//20 10 5 -1 -1 15 13 -1 -1 -1 35 30 -1 -1 42 -1 -1

    private static TreeNode buildTree(TreeNode root) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data for the root Node");
        root=new TreeNode(sc.nextInt());
        if(root.data==-1){
            return null;
        }
        System.out.println("Enter the value for the left child node");
        root.left=buildTree(root.left);
        System.out.println("Enter the value for the right child node");
        root.right=buildTree(root.right);
        return root;
    }
}