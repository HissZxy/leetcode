
import java.util.*;
  
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Balance {
    public boolean isBalance(TreeNode root) {
        if(root==null){
            return true;
        }else{
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            if(Math.abs(left-right)<=1){
                return isBalance(root.left)&&isBalance(root.right);
            }else{
                return false;
            }
        }      
    }
      
    public int getDeep(TreeNode root){
        if(root!=null){
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            return left>right?left+1:right+1;
        }else{
            return 0;
        }
    }
}