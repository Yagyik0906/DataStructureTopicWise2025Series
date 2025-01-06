package Trees;

public class SumTree extends BuildTree{
    static class Pair{
        Boolean ans;
        int sum;
        Pair(Boolean ans,int sum){
            this.ans=ans;
            this.sum=sum;
        }
    }
    public static void main(String[] args) {
        TreeNode root=null;
        root=buildTree(root);
        Pair res=checkSumTree(root);
        System.out.println("The tree is sum Tree "+res.ans);
    }

    private static Pair checkSumTree(TreeNode root) {
        if(root==null)
        {
            return new Pair(true,0);
        }
        if(root.left==null && root.right==null){
            return new Pair(true, root.data);
        }
        Pair leftSum=checkSumTree(root.left);
        Pair rightSum=checkSumTree(root.right);
        Boolean con=root.data== leftSum.sum+ rightSum.sum;
        Pair result=new Pair(false, root.data*2);
        if(leftSum.ans && rightSum.ans && con){
            result.ans=true;
        }
        return result;
    }
}
