输入一棵二叉树，判断该二叉树是否是平衡二叉树。
在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(TreeDepth(root.left)-TreeDepth(root.right))>1)
            return false;
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
    
    public int TreeDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right= TreeDepth(root.right);
        return left>right ?left+1:right+1;
    }
}

输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        int j=array.length-1;
        while(i<=j){
            int tmp= array[i]+array[j];
            if(tmp == sum){
                list.add(array[i]);
                list.add(array[j]);
                break;
            }else if(tmp<sum){
                i++;
            }else{
                j--;
            }
        }
        return list;
    }
}

一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] tmp = new int[2];
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],2);
            }
        }
        int j=0;
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])==1){
                tmp[j]=array[i];
                j++;
            }
        }
        Arrays.sort(tmp);
        return tmp;
    }
}