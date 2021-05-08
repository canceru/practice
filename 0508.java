给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

叶子节点 是指没有子节点的节点。

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        // if(root.left==null&&root.right==null){
        //     return targetSum==root.val;
        // }
        // return hasPathSum(root.left,targetSum-root.val) ||hasPathSum(root.right,targetSum-root.val);

        Queue<TreeNode> queue1 =new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.offer(root.val);
        while(!queue1.isEmpty()){
            TreeNode tmp=queue1.poll();
            int tmpval=queue2.poll();
            if(tmp.left==null &&tmp.right==null){
                if(tmpval==targetSum){
                    return true;
                }
                continue;
            }

            if(tmp.left!=null){
                queue1.add(tmp.left);
                queue2.offer(tmp.left.val+tmpval);
            }

            if(tmp.right!=null){
                queue1.add(tmp.right);
                queue2.offer(tmp.right.val+tmpval);
            }
            
        }
        return false;
    }
}

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null &&root.right==null ){
            return 1;
        }
        int depth=Integer.MAX_VALUE;
        if(root.left!=null){
             depth=Math.min(minDepth(root.left),depth);
        }

        if(root.right!=null){
             depth=Math.min(minDepth(root.right),depth);
        }
        return depth+1;
    }
}