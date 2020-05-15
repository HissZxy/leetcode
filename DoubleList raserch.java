import java.util.Stack;
public class Solution {
   public  TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
             return null;
         } 
       TreeNode node=pRootOfTree;
             Stack<TreeNode> stack=new Stack<TreeNode>();
                Connection(node,stack);
                         
             node=stack.get(0);
             return node;
         }
          
   public  void Connection(TreeNode newNode,Stack<TreeNode> stack){
            if(newNode==null) {
                return;
            }
             Connection(newNode.left,stack);
              
             if(stack.isEmpty()){
                 stack.push(newNode);
            
             }
             else{
                    stack.peek().right=newNode;
                    newNode.left=stack.peek();
                 stack.push(newNode);
                            
             }
              
             Connection(newNode.right,stack);
           
         }
}