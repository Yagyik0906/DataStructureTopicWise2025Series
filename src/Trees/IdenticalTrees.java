package Trees;

public class IdenticalTrees extends BuildTree{
    public static void main(String[] args) {
        TreeNode root1=null,root2=null;
        System.out.println("Enter the details for the first tree");
        root1=buildTree(root1);
        System.out.println("Enter the details for the second tree");
        root2=buildTree(root2);
        Boolean res=checkIdentical(root1,root2);
        System.out.println("The trees are identical is "+res);
    }

    private static Boolean checkIdentical(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null && root2!=null){
            return false;
        }
        if(root1!=null && root2==null){
            return false;
        }
        Boolean leftAns=checkIdentical(root1.left,root2.left);
        Boolean rightAns=checkIdentical(root2.right,root2.right);
        if(leftAns && rightAns){
            return true;
        }
        if(root1.data!=root2.data){
            return false;
        }
        return true;
    }
}

