/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.left==null && temp.right == null){
                TreeNode pop = stack.pop();
                result.add(pop.val);
            }
            else{
                if(temp.right!= null){
                    stack.push(temp.right);
                    temp.right = null;
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
        return result;
        
    }
}