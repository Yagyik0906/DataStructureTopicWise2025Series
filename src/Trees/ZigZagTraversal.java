package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal extends BuildTree{
    public static void main(String[] args) {
        TreeNode root=null;
        root=buildTree(root);
        ArrayList<Integer> ans=zigZagTraversal(root) ;
        for(int i:ans){
            System.out.println(i);
        }

    }

    private static ArrayList<Integer> zigZagTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            int[] tempAns=new int[size];
            for(int i=0;i<size;i++){
                TreeNode temp=q.peek();
                q.remove();
                int index=leftToRight?i:size-i-1;
                tempAns[index]= temp.data;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            leftToRight=false;
            for(int i:tempAns){
                result.add(i);
            }
        }
        return result;
    }
}