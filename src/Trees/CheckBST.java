package Trees;

public class CheckBST extends BuildTree{
    public static void main(String[] args) {
        TreeNode root = null;
        root=buildTree(root);
        Boolean ans=checkBST(root);
    }

    private static Boolean checkBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return false;
    }
}
