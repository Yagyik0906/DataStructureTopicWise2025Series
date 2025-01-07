package Trees;

public class BoundaryTraversal extends BuildTree{
    public static void main(String[] args) {
        TreeNode root=null;
        root=buildTree(root);
        boundaryTraversal(root);
    }

    private static void boundaryTraversal(TreeNode root) {
        TreeNode rootRight=root,rootLeft=root;
        leftBoundaryTraversal(rootLeft);
        leafTraversal(root);
        if(rootRight.right!=null)
            rightBoundaryTraversal(rootRight.right);
    }

    private static void rightBoundaryTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.right!=null){
            rightBoundaryTraversal(root.right);
        }else{
            if(root.left!=null){
                rightBoundaryTraversal(root.left);
            }
        }
        if(root.left!=null || root.right!=null)
            System.out.print(" "+root.data+" ");
    }

    private static void leafTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        leafTraversal(root.left);
        if(root.left==null && root.right==null){
            System.out.print(" "+root.data+" ");
        }
        leafTraversal(root.right);
    }

    private static void leftBoundaryTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left!=null || root.right!=null)
            System.out.print(" "+root.data+" ");
        if(root.left!=null){
            leftBoundaryTraversal(root.left);
        }else{
            if(root.right!=null){
                leftBoundaryTraversal(root.right);
            }
        }
    }

}

