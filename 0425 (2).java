输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head.left != null){
            head =head.left;
        }
        return head;
    }
    TreeNode pre = null;
    public void ConvertChild(TreeNode root){
        if(root == null){
            return;
        }
        ConvertChild(root.left);
        root.left = pre;
        if(pre != null){
            pre.right = root;
        }
        pre = root;
        ConvertChild(root.right);
    }
}